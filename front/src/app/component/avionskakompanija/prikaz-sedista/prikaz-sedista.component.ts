import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { SedisteNaLetu } from 'app/model/avionskakompanija/sedisteNaLetu';
import { SedisteService } from 'app/service/avionskaKompanija/sediste.service';
import { Route, Router, ActivatedRoute } from '@angular/router';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';
import { Rezervacija } from 'app/model/opsti/rezervacija';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { AvionskaKarta } from 'app/model/avionskakompanija/avionskaKarta';
import { AvionskaKompanijaService } from 'app/service/avionskaKompanija/avionska-kompanija.service';

@Component({
  selector: 'app-prikaz-sedista',
  templateUrl: './prikaz-sedista.component.html',
  styleUrls: ['./prikaz-sedista.component.css']
})
export class PrikazSedistaComponent implements OnInit {

  

  listaBrojeva: number[] = [1, 2, 3];
  listaBrojevaDo6: number[] = [1, 2, 3, 4, 5, 6];
  matricaZaPrikaz: number[][] = [[1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12], [13, 14]];
  matricaSedista: SedisteNaLetu[][] = [];
  kompanijaId: number = 0;
  letid: number = 0;
  izabranaSedista: SedisteNaLetu[] = [];
  korisnik: Korisnik = new Korisnik();
  private sub: any;

  //avionske-kompanije/:kompanija-id/letovi/:let-id/sedista
  constructor(private sedisteService: SedisteService, private router: Router, private route: ActivatedRoute, 
    private rezervacijaService: RezervacijeService) { 

    //this.matricaZaPrikaz = [];
    //this.napraviSvaSedista();
   // console.log(this.matricaSedista);
   this.sub = this.route.params.subscribe(params => {
    this.kompanijaId = +params['kompanija-id'];
    this.letid = +params['let-id'];
    this.korisnik = JSON.parse(localStorage.getItem('token'));

    //alert(this.kompanijaId + " " + this.letid);
    this.vratiSvaSedista();
   });
   

  }

  vratiSvaSedista(){
    this.sedisteService.vratiSedistaLeta(this.kompanijaId, this.letid).subscribe(
      s =>{
        this.matricaSedista = s;
    })
  }


  ngOnInit() {
  }

  dodajSediste(){
    // let tempLista: SedisteNaLetu[] = [];
    // tempLista.push(this.napraviSediste(this.matricaSedista.length*10));
    // this.matricaSedista.push(tempLista);
    let sediste: SedisteNaLetu = new SedisteNaLetu();
    this.sedisteService.dodajSediste(this.kompanijaId, this.letid).subscribe(
      s =>{
        this.matricaSedista = s;
    })
  }

  obrisiSediste(){
    this.sedisteService.obrisiSediste(this.kompanijaId, this.letid, 0).subscribe(
      s =>{
        this.matricaSedista = s;
    })
  }

  dalje(){
    //posalje sedista
    //this.izabranaSedista.push(sediste);

    let avionskaKarta: AvionskaKarta = new AvionskaKarta();
    avionskaKarta.sedistaDTO = this.izabranaSedista;
    this.rezervacijaService.rezervisiSedista(this.kompanijaId, this.letid, this.korisnik.id, avionskaKarta).subscribe(
      s => {
        let rezervacija: Rezervacija = s;
        localStorage.setItem('rezervacija', JSON.stringify(rezervacija));
        this.router.navigate(['popuniSedista']);
      }
    )

    //sacuva rezervaciju
    //
    
  }

  kliknutoSediste(sediste: SedisteNaLetu){
    let i = 0;
    let promenjeno: boolean = false;
    this.izabranaSedista.forEach(item => {
      if(item.id == sediste.id){
        this.izabranaSedista.splice(i, 1);
        promenjeno = true;
      }
      ++i;
    })
    if(!promenjeno){
      this.izabranaSedista.push(sediste);
    }
    
  }

  napraviSediste(id: number): SedisteNaLetu{
    let sediste: SedisteNaLetu = new SedisteNaLetu();
    sediste.id = id;
    return sediste;
  }

  napraviRedSedista(brojReda: number): SedisteNaLetu[]{
    let tempLista: SedisteNaLetu[] = [];
    for (let i = 1+(brojReda-1)*6; i <= 6+(brojReda-1)*6; i++) {
      tempLista.push(this.napraviSediste(i))
    }

    return tempLista;
  }

  napraviSvaSedista(){
    this.matricaSedista.push(this.napraviRedSedista(1));
    this.matricaSedista.push(this.napraviRedSedista(2));
    this.matricaSedista.push(this.napraviRedSedista(3));
    this.matricaSedista.push(this.napraviRedSedista(4));
  }

  vidljivo(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && 
                    this.korisnik.tipAdmina === "ADMIN_AVIONSKE_KOMPANIJE"){
       return true;
    }
    return false; 
  }

}
