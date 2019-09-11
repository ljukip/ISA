import { Component, OnInit } from '@angular/core';
import { ZahtevZaPrijateljstvo } from 'app/model/korisnici/zahtevZaPrijateljstvo';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { KorisnikService } from 'app/service/korisnici/korisnik.service';

@Component({
  selector: 'app-zahtevi-za-prijateljstvo',
  templateUrl: './zahtevi-za-prijateljstvo.component.html',
  styleUrls: ['./zahtevi-za-prijateljstvo.component.css']
})
export class ZahteviZaPrijateljstvoComponent implements OnInit {

  constructor(private korisnikService: KorisnikService) { }

  listaZahteva: ZahtevZaPrijateljstvo[] = [];
  ulogovaniKorisnik: Korisnik = new Korisnik();


  ngOnInit() {
    this.ulogovaniKorisnik = JSON.parse(localStorage.getItem('token'));
    //this.ulogovaniKorisnik.id = 1; //OBRISI
    this.getReceivedRequests();
  }

  getReceivedRequests(){
    this.korisnikService.receivedRequests(this.ulogovaniKorisnik.id).subscribe(
      s => {
        this.listaZahteva = s;
    })
  }

  accept(idPrijatelj: number){
    this.korisnikService.acceptRequest(this.ulogovaniKorisnik.id, idPrijatelj).subscribe(
      s => {
        this.getReceivedRequests();
      }
    )
  }

  decline(idPrijatelj: number){
    this.korisnikService.deleteRequest(this.ulogovaniKorisnik.id, idPrijatelj).subscribe(
      s => {
        this.getReceivedRequests();
      }
    )
  }

}
