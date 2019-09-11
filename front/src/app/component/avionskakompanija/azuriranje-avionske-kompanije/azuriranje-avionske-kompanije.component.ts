import { Component, OnInit } from '@angular/core';
import { AvionskaKompanija } from 'app/model/avionskakompanija/avionskaKompanija';
import { ActivatedRoute, Router } from '@angular/router';
import { AvionskaKompanijaService } from 'app/service/avionskaKompanija/avionska-kompanija.service';

@Component({
  selector: 'app-azuriranje-avionske-kompanije',
  templateUrl: './azuriranje-avionske-kompanije.component.html',
  styleUrls: ['./azuriranje-avionske-kompanije.component.css']
})
export class AzuriranjeAvionskeKompanijeComponent implements OnInit {

  id: number;

  aviokompanija: AvionskaKompanija = new AvionskaKompanija();
  private sub: any;
  isDataAvailable: boolean;
  maksimalnaDuzina: number = 30;
  maksimalnaDuzinaOpis: number = 140;

  constructor(private avionskaKompanijaService :AvionskaKompanijaService, private route: ActivatedRoute, private router: Router) 
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
          this. avionskaKompanijaService.findOne(this.id).subscribe(
            e => {
              this.aviokompanija = e;
            }
          )
        
          this.isDataAvailable = true;
        }
        else{
          //znaci dodajem novi koji ne postoji
          this.aviokompanija = new AvionskaKompanija();
          this.isDataAvailable = false;
        }
     }
   });
  }

  save(){
    let message: string = this.proveriUnos();
    if(message === "OK"){
      this. avionskaKompanijaService.add(this.aviokompanija).subscribe(
        s => {
          this.aviokompanija = s;
          this.router.navigate(['avionske-kompanije']);
        },
        err=> console.log("err")
      );
    } 
    else{
      alert(message);
    }   
  }

  update(){
    let message: string = this.proveriUnos();
    if(message === "OK"){
      this. avionskaKompanijaService.update(this.aviokompanija.id, this.aviokompanija).subscribe(
        s => {
          this.aviokompanija = s;
          
          this.router.navigate(['avionske-kompanije']);
        },
        err=> console.log("err")
      );    
    }
    else{
      alert(message);
    }
  }

  goBack(){
    this.router.navigate(['avionske-kompanije']);
  }

  proveriUnos(): string{
    if(this.aviokompanija.naziv === "" || this.aviokompanija.naziv.length > this.maksimalnaDuzina){
      return "Morate popuniti naziv koja mora biti kraci od " + this.maksimalnaDuzina + " karaktera";
    }

    /*if(this.hotel.adresa === "" ||this.hotel.adresa.length > this.maksimalnaDuzina){
      return "Morate popuniti adresu rent-a koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    }*/

    if(this.aviokompanija.opis === "" || this.aviokompanija.opis.length > this.maksimalnaDuzinaOpis){
      return "Morate popuniti opis koji mora biti kraci od " + this.maksimalnaDuzinaOpis + " karaktera";
    }
    /*if(isNaN(this.hotel.latitude) || isNaN(this.hotel.longitude)){
      return "Geografska sirina i duzina moraju biti brojevi";
    }*/
    return "OK"
  }
}