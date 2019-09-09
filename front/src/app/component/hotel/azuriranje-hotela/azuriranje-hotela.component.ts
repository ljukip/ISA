import { Component, OnInit } from '@angular/core';
import { Hotel } from 'app/model/hotel/hotel';
import { HotelService } from 'app/service/hotel/hotel.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-azuriranje-hotela',
  templateUrl: './azuriranje-hotela.component.html',
  styleUrls: ['./azuriranje-hotela.component.css']
})
export class AzuriranjeHotelaComponent implements OnInit {

  id: number;

  hotel: Hotel = new Hotel();
  private sub: any;
  isDataAvailable: boolean;
  maksimalnaDuzina: number = 30;
  maksimalnaDuzinaOpis: number = 140;

  constructor(private hotelService :HotelService, private route: ActivatedRoute, private router: Router) 
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
          this.hotelService.findOne(this.id).subscribe(
            e => {
              this.hotel = e;
            }
          )
        
          this.isDataAvailable = true;
        }
        else{
          //znaci dodajem novi koji ne postoji
          this.hotel = new Hotel();
          this.isDataAvailable = false;
        }
     }
   });
  }

  save(){
    let message: string = this.proveriUnosRentacar();
    if(message === "OK"){
      this.hotelService.add(this.hotel).subscribe(
        s => {
          this.hotel = s;
          this.router.navigate(['hoteli']);
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
      this.hotelService.update(this.hotel.id, this.hotel).subscribe(
        s => {
          this.hotel = s;
          
          this.router.navigate(['hoteli']);
        },
        err=> console.log("err")
      );    
    }
    else{
      alert(message);
    }
  }

  goBack(){
    this.router.navigate(['hoteli']);
  }

  proveriUnosRentacar(): string{
    if(this.hotel.naziv === "" || this.hotel.naziv.length > this.maksimalnaDuzina){
      return "Morate popuniti naziv rent-a koja mora biti kraci od " + this.maksimalnaDuzina + " karaktera";
    }

    /*if(this.hotel.adresa === "" ||this.hotel.adresa.length > this.maksimalnaDuzina){
      return "Morate popuniti adresu rent-a koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    }*/

    if(this.hotel.opis === "" || this.hotel.opis.length > this.maksimalnaDuzinaOpis){
      return "Morate popuniti opis rent-a koji mora biti kraca od " + this.maksimalnaDuzinaOpis + " karaktera";
    }
    /*if(isNaN(this.hotel.latitude) || isNaN(this.hotel.longitude)){
      return "Geografska sirina i duzina moraju biti brojevi";
    }*/
    return "OK"
  }
}