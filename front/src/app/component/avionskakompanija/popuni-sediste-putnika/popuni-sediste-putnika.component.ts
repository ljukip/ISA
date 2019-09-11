import { Component, OnInit } from '@angular/core';
import { SedisteNaLetu } from 'app/model/avionskakompanija/sedisteNaLetu';
import { Router } from '@angular/router';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';
import { Rezervacija } from 'app/model/opsti/rezervacija';
import { KorisnikService } from 'app/service/korisnici/korisnik.service';
import { SedisteService } from 'app/service/avionskaKompanija/sediste.service';

@Component({
  selector: 'app-popuni-sediste-putnika',
  templateUrl: './popuni-sediste-putnika.component.html',
  styleUrls: ['./popuni-sediste-putnika.component.css']
})
export class PopuniSedistePutnikaComponent implements OnInit {

  vidljivaSedista: boolean = true;
  sedista: SedisteNaLetu[] = [];
  korisnik: Korisnik = new Korisnik();
  rezervacija: Rezervacija = new Rezervacija();
  listaEmailova: string[] = [];
  listaPrikazna: string[] = [];

  constructor(private router: Router, private korisnikService: KorisnikService, 
    private sedisteService: SedisteService, private rezervacijaService: RezervacijeService) { }

  ngOnInit() {
    this.korisnik = JSON.parse(localStorage.getItem('token'));
    this.rezervacija = JSON.parse(localStorage.getItem('rezervacija'));
    this.sedista = this.rezervacija.karta.sedistaDTO;
    this.getAllFriends();
  }

  getAllFriends(){
    this.korisnikService.findAllFriends(this.korisnik.id).subscribe(
      s => {
        let listaPrijatelja: Korisnik[] = s;
        listaPrijatelja.forEach(
          item => {
            this.listaEmailova.push(item.email);
          }
        )

          this.listaPrikazna = this.listaEmailova;

        }
       )
      }


  popuniSedista(){
    this.vidljivaSedista = false;

    this.sedista.forEach( item => {
      item.email = item.email.toString();
      this.sedisteService.azurirajSediste(item.id, item).subscribe(
        s => {

        }
      )
    })
  }

  idiNaStranicu(stranica: string){
    if(stranica == "RENT"){
      this.router.navigate(['kompanije-vozila']);
    }
    else{
      this.router.navigate(['hoteli']);
    }
  }

  zavrsi(){
    this.rezervacijaService.zavrsiRezervaciju(this.rezervacija.id).subscribe(
      s => {
        localStorage.removeItem('rezervacija');
        //idi na stranicu za prikaz rezervacije
        this.router.navigate(['rezervacije']);
      }
    )
  }

}
