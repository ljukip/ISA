import { Component, OnInit } from '@angular/core';
import { Garaza } from 'app/model/vozila/garaza';
import { GarazaService } from 'app/service/vozila/garaza.service';
import { AuthService } from 'app/auth.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-prikaz-garaza',
  templateUrl: './prikaz-garaza.component.html',
  styleUrls: ['./prikaz-garaza.component.css']
})
export class PrikazGarazaComponent implements OnInit {

  constructor(private filijalaService: GarazaService, private router: Router, private route: ActivatedRoute,  
    private authService: AuthService) {
    let res = localStorage.getItem('token');
    if(res != null){
      //this.tipkorisnika = this.authService.getRoles(res);
    }
    else{
      this.tipkorisnika = "nema_korisnika";
    }
  }

  id: number; //kompanija-id
  public garaze: Garaza[] = [];
  private sub: any;
  isDataAvailable: boolean;
  public tipkorisnika: string;
  dropdownSettings = {};
  tipoviVozila: string[];
  mestaFilijala: string[];
  public min = new Date();
  idRezervacije: number = 0;

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      if(params['kompanija-id'] != null){
        this.id = +params['kompanija-id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa
        
        if(this.id != null )
        {
          /*this.voziloService.findVozilaForRent(this.id).subscribe(
            e => 
            {
              this.vozila = e;
            }
          )*/
          this.getAll();
          }
        }
      }
      );
    }



  getAll(){
    this.filijalaService.findAll(this.id).subscribe(
      s => { this.garaze = s; }
    );
  }

  update(id: number){
    this.router.navigate(['kompanije-vozila/' + this.id +  '/garaze/add/' + id]);
   }

   delete(id: number){
    this.filijalaService.delete(this.id, id).subscribe(
      s => this.getAll(),
      err=> console.log("err")
    );    
   }

  // addVoziloToRent( ){
  //   this.router.navigate(['rentacarovi/' + this.id +  '/svaVozilaKojaSeMoguDodati']);
  // }

  viewDetails(idGaraze: number){
    this.router.navigate(['kompanije-vozila/' + this.id +  '/garaze/' + idGaraze + '/vozila']);
  }

 addVozilo(idGaraze: number){
  this.router.navigate(['kompanije-vozila/' + this.id +  '/garaze/' + idGaraze + '/vozila/add']);
  }


  obrisiVoziloVidljivo(vozilo: Garaza){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
    //   return true;
    // }
    // return false; 
    return true;
  }

  azurirajVoziloVidljivo(vozilo: Garaza){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
    //   return true;
    // }
    // return false; 
    return true;
  }


}
