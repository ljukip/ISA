import { Component, OnInit } from '@angular/core';
import { AvionskaKarta } from 'app/model/avionskakompanija/avionskaKarta';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';

@Component({
  selector: 'app-istorija-letova',
  templateUrl: './istorija-letova.component.html',
  styleUrls: ['./istorija-letova.component.css']
})
export class IstorijaLetovaComponent implements OnInit {

  listaIstorijeLetova: AvionskaKarta[] = [];
  korisnik: Korisnik = new Korisnik();

  constructor(private rezervacijaService: RezervacijeService) { }

  ngOnInit() {
  //   let zakup: AvionskaKarta = new AvionskaKarta();
  //   zakup.cena = 50;
  //   zakup.vremeDolaska = "11/11/2011";
  //   zakup.vremePolaska = "11/11/2011";
  //   zakup.mestoDolaska = "mesto1";
  //   zakup.ocena = 1;
  //   zakup.mestoPolaska  = "mesto122";
 
  //  this.listaIstorijeLetova.push(zakup);
  //  this.listaIstorijeLetova.push(zakup);

  this.korisnik = JSON.parse(localStorage.getItem('token'));
  this.rezervacijaService.istorijaZakupaKarata(this.korisnik.id).subscribe(
    s => {
      this.listaIstorijeLetova = s;
    }
  )
  }

  getHistoryOfRentedPlanes(){
   /* this.aviokompanijaService.findHistoryOfRentedPlanes().subscribe(
      success => { 
        this.listaIstorijeLetova = success; 

        this.listaIstorijeLetova.forEach(element => {
          if(element.ocena > 0){
            element.mozeDaOceni = false; 
          }
          else{
            element.mozeDaOceni = true; 
          }          
        });
      }
    );*/
  }

  oceniLet(rezervisaniLet: AvionskaKarta){
    /*if(rezervisaniLet.mozeDaOceni){
      this.aviokompanijaService.oceniRezervisaniLet(rezervisaniLet).subscribe(
        s =>{
          rezervisaniLet.mozeDaOceni = false;
        }
      );
    }*/

    this.rezervacijaService.oceniAvionskuKartu(rezervisaniLet.id, rezervisaniLet.ocena).subscribe(
      s => {
        
      }
    )
  }

  dozvoliOcenjivanjeLeta(ocena: number): boolean{
    if(ocena > 0){
      return true;
    }
    else{
      return false;
    }
  }

  enableizmeniOcenuLet(rezervacijaLeta){
    //rezervacijaLeta.mozeDaOceni = true;
    //rezervacijaLeta.ocena = 0;
  }


  
  public inBetween(drugoVreme: string) { 
    var one_day=1000*60*60; //1h
  
    var datumDolaska = new Date(); //trenutno vreme
    var datumOdlaska = new Date(drugoVreme);

    // Convert both dates to milliseconds
    var date1_ms = datumDolaska.getTime();
    var date2_ms = datumOdlaska.getTime();
  
    // Calculate the difference in milliseconds
    var difference_ms = date2_ms - date1_ms;

    return Math.round(difference_ms/one_day); 
  }

}
