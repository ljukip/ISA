import { Component, OnInit } from '@angular/core';
import { CenovnikSobe } from 'app/model/hotel/cenovnikSobe';
import { CenovnikService } from 'app/service/hotel/cenovnik.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'app/auth.service';
import { Korisnik } from 'app/model/korisnici/korisnik';

@Component({
  selector: 'app-prikaz-cenovnika',
  templateUrl: './prikaz-cenovnika.component.html',
  styleUrls: ['./prikaz-cenovnika.component.css']
})
export class PrikazCenovnikaComponent implements OnInit {

  public korisnik: Korisnik;

  constructor(private cenovnikService: CenovnikService, private router: Router, private route: ActivatedRoute,  
    private authService: AuthService) {
    this.korisnik = JSON.parse(localStorage.getItem('token'));
  }

  id: number; //hotel-id
  sobaId: number;
  public cenovnici: CenovnikSobe[] = [];
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
        this.sobaId = +params['soba-id'];
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
    this.cenovnikService.findAll(this.id, this.sobaId).subscribe(
      s => { this.cenovnici = s; }
    );
  }

  update(id: number){
    this.router.navigate(['hoteli/' + this.id + '/sobe/' + this.sobaId + '/cenovnici/add/' + id]);
   }

   delete(id: number){
    this.cenovnikService.delete(this.id, this.sobaId, id).subscribe(
      s => this.getAll(),
      err=> console.log("err")
    );    
   }

  obrisiVoziloVidljivo(vozilo: CenovnikSobe){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" 
                  && this.korisnik.tipAdmina === "ADMIN_HOTELA"){
      return true;
   }
   return false;  
  }

  azurirajVoziloVidljivo(vozilo: CenovnikSobe){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" 
                  && this.korisnik.tipAdmina === "ADMIN_HOTELA"){
      return true;
   }
   return false; 
  }


}

