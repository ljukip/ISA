import { Component, OnInit } from '@angular/core';
import { Opcija } from 'app/model/hotel/opcija';
import { OpcijaService } from 'app/service/hotel/opcija.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'app/auth.service';

@Component({
  selector: 'app-prikaz-opcija',
  templateUrl: './prikaz-opcija.component.html',
  styleUrls: ['./prikaz-opcija.component.css']
})
export class PrikazOpcijaComponent implements OnInit {

  constructor(private opcijeService: OpcijaService, private router: Router, private route: ActivatedRoute,  
    private authService: AuthService) {
    let res = localStorage.getItem('token');
    if(res != null){
      //this.tipkorisnika = this.authService.getRoles(res);
    }
    else{
      this.tipkorisnika = "nema_korisnika";
    }
  }

  id: number; //hotel-id
  public opcije: Opcija[] = [];
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
      if(params['hotel-id'] != null){
        this.id = +params['hotel-id']; // (+) konvertuje string 'id' u broj
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
    this.opcijeService.findAll(this.id).subscribe(
      s => { this.opcije = s; }
    );
  }

  update(id: number){
    this.router.navigate(['hoteli/' + this.id +  '/opcije/add/' + id]);
   }

   delete(id: number){
    this.opcijeService.delete(this.id, id).subscribe(
      s => this.getAll(),
      err=> console.log("err")
    );    
   }

  obrisiVoziloVidljivo(vozilo: Opcija){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    // if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
    //   return true;
    // }
    // return false; 
    return true;
  }

  azurirajVoziloVidljivo(vozilo: Opcija){
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
