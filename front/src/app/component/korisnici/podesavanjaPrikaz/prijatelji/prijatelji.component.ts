import { Component, OnInit } from '@angular/core';
import { KorisnikService } from 'app/service/korisnici/korisnik.service';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { KorisnikPrijava } from 'app/model/korisnici/korisnikPrijava';

@Component({
  selector: 'app-prijatelji',
  templateUrl: './prijatelji.component.html',
  styleUrls: ['./prijatelji.component.css']
})
export class PrijateljiComponent implements OnInit {

  constructor(private korisnikService: KorisnikService) { }

  paramDir: string = "ASC";
  ime: string = undefined;
  prezime: string = undefined;
  listaPrijatelja: Korisnik[] = [];
  ulogovaniKorisnik: Korisnik = new Korisnik();


  ngOnInit() {
    this.ulogovaniKorisnik = JSON.parse(localStorage.getItem('token'));
    //this.ulogovaniKorisnik.id = 1; //OBRISI
    this.getAllFriends();
  }

  getAllFriends(){
    this.korisnikService.findAllFriends(this.ulogovaniKorisnik.id).subscribe(
      s => {
        this.listaPrijatelja = s;
    })
  }

  getAllSort(paramSort: string){
    this.korisnikService.findAllSort(paramSort, this.paramDir).subscribe(
      ss => { 
        this.listaPrijatelja = ss; 
        //this.setListe();
      }
    );

    if (this.paramDir === 'ASC'){
      this.paramDir = 'DESC';
    } else {
      this.paramDir = 'ASC';
    }
  }

  cancelFriendship(idPrijatelj: number){
    this.korisnikService.deletePrijatelj(this.ulogovaniKorisnik.id, idPrijatelj).subscribe(
      s => {
        this.getAllFriends();
      }
    )
  }

  trazi(){
    alert("ime " + this.ime + " prezime " + this.prezime);
  }

}
