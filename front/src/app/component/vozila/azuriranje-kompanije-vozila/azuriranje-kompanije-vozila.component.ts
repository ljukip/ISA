import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { KompanijaVozila } from 'app/model/vozila/kompanijaVozila';
import { KompanijaVozilaService } from 'app/service/vozila/kompanija-vozila.service';

@Component({
  selector: 'app-azuriranje-kompanije-vozila',
  templateUrl: './azuriranje-kompanije-vozila.component.html',
  styleUrls: ['./azuriranje-kompanije-vozila.component.css']
})
export class AzuriranjeKompanijeVozilaComponent implements OnInit {

  
  id: number;

  rentacar: KompanijaVozila = new KompanijaVozila();
  private sub: any;
  isDataAvailable: boolean;
  maksimalnaDuzina: number = 30;
  maksimalnaDuzinaOpis: number = 140;

  constructor(private rentacarService :KompanijaVozilaService, private route: ActivatedRoute, private router: Router) 
  { 
      
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      if(params['id'] != null){
        this.id = +params['id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa
        
        if(this.id != null )
        {
          this.rentacarService.findOne(this.id).subscribe(
            e => {
              this.rentacar = e;
            }
          )
        
          this.isDataAvailable = true;
        }
        else{
          //znaci dodajem novi koji ne postoji
          this.rentacar = new KompanijaVozila();
          this.isDataAvailable = false;
        }
     }
   });
  }

  save(){
    let message: string = this.proveriUnosRentacar();
    if(message === "OK"){
      this.rentacarService.addRentACar(this.rentacar).subscribe(
        s => {
          this.rentacar = s;
          this.router.navigate(['kompanije-vozila']);
        },
        err=> console.log("err")
      );
    } 
    else{
      alert(message);
    }   
  }

  update(){
    let message: string = this.proveriUnosRentacar();
    if(message === "OK"){
      this.rentacarService.updateRentACar(this.rentacar.id, this.rentacar).subscribe(
        s => {
          this.rentacar = s;
          
          this.router.navigate(['kompanije-vozila']);
        },
        err=> console.log("err")
      );    
    }
    else{
      alert(message);
    }
  }

  goBack(){
    this.router.navigate(['kompanije-vozila']);
  }

  proveriUnosRentacar(): string{
    if(this.rentacar.naziv === "" || this.rentacar.naziv.length > this.maksimalnaDuzina){
      return "Morate popuniti naziv rent-a koja mora biti kraci od " + this.maksimalnaDuzina + " karaktera";
    }

    /*if(this.rentacar.adresa === "" ||this.rentacar.adresa.length > this.maksimalnaDuzina){
      return "Morate popuniti adresu rent-a koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    }*/

    if(this.rentacar.opis === "" || this.rentacar.opis.length > this.maksimalnaDuzinaOpis){
      return "Morate popuniti opis rent-a koji mora biti kraca od " + this.maksimalnaDuzinaOpis + " karaktera";
    }
    if(isNaN(this.rentacar.latitude) || isNaN(this.rentacar.longitude)){
      return "Geografska sirina i duzina moraju biti brojevi";
    }
    return "OK"
  }
}
