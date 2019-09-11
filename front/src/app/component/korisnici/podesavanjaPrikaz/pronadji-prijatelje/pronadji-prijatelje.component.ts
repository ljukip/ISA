import { Component, OnInit } from '@angular/core';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { KorisnikService } from 'app/service/korisnici/korisnik.service';

@Component({
  selector: 'app-pronadji-prijatelje',
  templateUrl: './pronadji-prijatelje.component.html',
  styleUrls: ['./pronadji-prijatelje.component.css']
})
export class PronadjiPrijateljeComponent implements OnInit {

  constructor(private korisnikService: KorisnikService) { }

  paramDir: string = "ASC";
  ime: string = undefined;
  prezime: string = undefined;
  listaPrijatelja: Korisnik[] = [];
  ulogovaniKorisnik: Korisnik = new Korisnik();


  ngOnInit() {
    this.ulogovaniKorisnik = JSON.parse(localStorage.getItem('token'));
    //this.ulogovaniKorisnik.id = 1; //OBRISI
    this.getAllNotFriends();
  }

  getAllNotFriends(){
    this.korisnikService.findNotFriends(this.ulogovaniKorisnik.id).subscribe(
      s => {
        this.listaPrijatelja = s;
    })
  }

  addFriend(idPrijatelj: number){
    this.korisnikService.sendRequest(this.ulogovaniKorisnik.id, idPrijatelj).subscribe(
      s => {
        alert('Vas zahtev za prijateljstvo je poslat.')
        this.getAllNotFriends();
      }
    )
  }

}
