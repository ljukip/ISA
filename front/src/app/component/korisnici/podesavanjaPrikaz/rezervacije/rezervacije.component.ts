import { Component, OnInit } from '@angular/core';
import { AvionskaKarta } from 'app/model/avionskakompanija/avionskaKarta';
import { ZakupSoba } from 'app/model/hotel/zakupSoba';
import { ZakupVozila } from 'app/model/vozila/zakupVozila';
import { Vozilo } from 'app/model/vozila/vozilo';
import { Rezervacija } from 'app/model/opsti/rezervacija';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';

@Component({
  selector: 'app-rezervacije',
  templateUrl: './rezervacije.component.html',
  styleUrls: ['./rezervacije.component.css']
})
export class RezervacijeComponent implements OnInit {

  rezervacije: Rezervacija[] = [];
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


  //   let soba: ZakupSoba = new ZakupSoba();
  //   soba.cenaZakupa = 50;
  //   soba.krajnjiDatum = "11/11/2011";
  //   soba.pocetniDatum = "11/11/2011";
  //   soba.tip = "tip";
  //   soba.ocena = 3;
  //  //zakup.sobe = [];
  //  //zakup.voziloDTO.naziv = "naziv";
  //  soba.brojGostiju = 5;


  //  let vozilo: ZakupVozila = new ZakupVozila();
  //  vozilo.cenaZakupa = 50;
  //  vozilo.krajnjiDatum = "11/11/2011";
  //  vozilo.pocetniDatum = "11/11/2011";
  //  vozilo.tip = "tip";
  //  vozilo.ocena = 1;
  //  vozilo.voziloDTO = new Vozilo();
  //  vozilo.voziloDTO.naziv = "naziv";
  //  vozilo.brojPutnika = 5;

  //  let rez1 = new Rezervacija();
  //  rez1.karta = zakup;
  //  rez1.zakupSoba = soba;
  //  rez1.zakupVozila = vozilo;

  //  let rez2 = new Rezervacija();
  //  rez2.karta = zakup;
  //  rez2.zakupVozila = vozilo;

  //  let rez3 = new Rezervacija();
  //  rez3.karta = zakup;
  //  rez3.zakupSoba = soba;

  //  this.rezervacije.push(rez1);
  //  this.rezervacije.push(rez2);
  //  this.rezervacije.push(rez3);

  this.korisnik = JSON.parse(localStorage.getItem('token'));
  this.rezervacijaService.korisnikoveRezervacije(this.korisnik.id).subscribe(
    s => {
      this.rezervacije = s;
    }
  )
  

  }

  otkaziLet(rezervacija){
    /*this.korisnikService.otkaziLet(rezervacija.id).subscribe(
      s => {
        let pomRezervacija: Rezervacija = new Rezervacija();
        this.rezervacije.forEach(element => {
          if(element.id === rezervacija.id){
            pomRezervacija = element;
          }
        })

        this.rezervacije.splice(this.rezervacije.indexOf(pomRezervacija))
      }
    )*/
  }

  otkazivanjeLetaDozvoljeno(rezervacijaLeta){
    /*if(this.inBetween(rezervacijaLeta.datumPoletanja) <=3 ){
      return false;
    }
    else{
      return true;
    }*/
  }

  

}
