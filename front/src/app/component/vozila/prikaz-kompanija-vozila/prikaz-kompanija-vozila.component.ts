import { Component, OnInit } from '@angular/core';
import { KompanijaVozila } from 'app/model/vozila/kompanijaVozila';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';
import { AuthService } from 'app/auth.service';
import { KompanijaVozilaService } from 'app/service/vozila/kompanija-vozila.service';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { ZakupVozila } from 'app/model/vozila/zakupVozila';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';
import { Rezervacija } from 'app/model/opsti/rezervacija';
import { PretragaKompanijeVozila } from 'app/model/opsti/pretragaKompanijaVozila';

@Component({
  selector: 'app-prikaz-kompanija-vozila',
  templateUrl: './prikaz-kompanija-vozila.component.html',
  styleUrls: ['./prikaz-kompanija-vozila.component.css']
})
export class PrikazKompanijaVozilaComponent implements OnInit {

  public rentacarovi: KompanijaVozila[] = [];
  public korisnik: Korisnik;
  adreseRenta: string[] = [];
  pomAdreseRenta: string[] = [];
  naziviRenta: string[] = [];
  dropdownSettings = {};
  izabranaAdresa: string = "";
  izabraniNaziv: string = "";
  paramDir: string = "ASC";
  ocenjiviRentovi: number[];
  prihod: number;
  idRezervacije: number = 0;
  idFilijala: number = 0;

  
  brzeVidljiveClick = false;
  zakupi: ZakupVozila[] = [];
  rezervacija: Rezervacija = new Rezervacija();
  ajde: boolean = false;


  constructor(private route: ActivatedRoute, private rentacarService : KompanijaVozilaService, private router: Router, 
    private authService: AuthService, private rezervacijaService: RezervacijeService
   ) 
   {
    this.korisnik = JSON.parse(localStorage.getItem('token'));
    this.rezervacija = JSON.parse(localStorage.getItem('rezervacija'));

    if(this.rezervacija != null){
      this.ajde = true;
    }


    this.getAll();
  }

  ngOnInit() {

    this.rentacarService.vratiSveAdrese().subscribe(
      s => 
      {
       s.forEach(item => {
          let temp: string = item.zemlja + " " + item.grad + " " + item.ulica + " " + item.broj;
          this.pomAdreseRenta.push(temp);
        }); 

        this.adreseRenta = this.pomAdreseRenta;
      }
    )

    this.rentacarService.vratiSveNazive().subscribe(
      a => 
      {
        this.naziviRenta = a;
      }
    )


    this.dropdownSettings = {
      singleSelection: true,
      // idField: 'id',
      //textField: 'adreseRenta',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

   /* this.route.queryParams.subscribe(params => {
      if(params["idRezervacije"] !== undefined){
        this.idRezervacije = params["idRezervacije"];
      }
    });*/
  }

  getAll(){
    /*if(this.tipkorisnika !== "nema_korisnika"){
      this.rentacarService.vratiListuOcenjivihServisa().subscribe(
        a => 
        {
          this.ocenjiviRentovi = a;
          this.rentacarService.findAll().subscribe(
        
            s => { 
              this.rentacarovi = s;  
            }
          );
        }
      );
    }*/
    //else{
      this.rentacarService.findAll().subscribe(
        
        s => { 
          this.rentacarovi = s;
        }
      );
   // }
  }

  delete(id: number){
    this.rentacarService.deleteRentACar(id).subscribe(
      s => this.getAll(),
      err=> console.log("err")
    );    
   }
 
   update(id: number){
    this.router.navigate(['kompanije-vozila/add', id]);
   }

   postaviFilijalu(id: number){
    this.idFilijala = id;
   }

   viewDetails(id: number){
     //if(this.idFilijala != 0){
      this.router.navigate(['kompanije-vozila/' + id + '/garaze']);
     /*}
     else{
       alert('izaberi filjalu');
     }*/
    
  }

  createGarage(id: number){
    this.router.navigate(['kompanije-vozila/' + id + '/garaze/add']);
  }

  imageClick(id: number){
    /*if(this.idRezervacije !== 0){
      let navigationExtras: NavigationExtras = {
        queryParams: {
            "idRezervacije" : this.idRezervacije
        }
      };
      this.router.navigate(['rentacarovi/' +  id + '/prikazVozila'], navigationExtras);
    }
    else {
      this.router.navigate(['rentacarovi/' +  id + '/prikazVozila']);
    }*/
  }

  spanClick(id: number){
    //this.router.navigate(['rentacarovi/' +  id + '/prikazFilijala']);
  }

  ulogovaniKorisnikImaDozvoluDaMenja(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && this.korisnik.tipAdmina === "ADMIN_KOMPANIJE_VOZILA"){
      return true;
     }
     return false; 
  }

  ulogovaniKorisnikImaDozvoluDaBrise(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && this.korisnik.tipAdmina === "ADMIN_KOMPANIJE_VOZILA"){
      return true;
     }
     return false; 
  }

  rezervisiDugme(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "KORISNIK"){
      return true;
    }
    return false; 
  }

  ocenaVidljivo(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "KORISNIK"){
      return true;
    }
    return false; 
  }

  trazi(){
    // this.rentacarService.trazenjeRentacarova(this.izabraniNaziv, this.izabranaAdresa).subscribe(
    //   s => {
    //     this.rentacarovi = s;
    //   },
    //   err=> console.log("err")
    // );
    
    let pretraga: PretragaKompanijeVozila = new PretragaKompanijeVozila();
    pretraga.naziv = this.izabraniNaziv;
    pretraga.destinacija.zemlja = this.izabranaAdresa;

    this.rentacarService.trazi(pretraga).subscribe(
      s => {
        this.rentacarovi = s;
      }
    )
    
  }

  getAllSort(paramSort: string){
    this.rentacarService.findAllSort(paramSort, this.paramDir).subscribe(
      ss => { this.rentacarovi = ss; }
    );
    if (this.paramDir === 'ASC'){
      this.paramDir = 'DESC';
    } else {
      this.paramDir = 'ASC';
    }
  }

  brzaRezervacija(){
    // let navigationExtras: NavigationExtras = {
    //   queryParams: {
    //       "idRezervacije" : this.idRezervacije
    //   }
    // };
    // this.router.navigate(['rentacarovi/brzaRezervacijaVozila'], navigationExtras);
    this.brzeVidljiveClick = true;
    this.rezervacijaService.vratiBrzeRezervacijeVozila(0).subscribe(
      s => {
        this.zakupi = s;
      }
    )
  }

  rezervisi(zakupSobe: ZakupVozila){
    this.rezervacijaService.zakupVozila(this.rezervacija.id, zakupSobe).subscribe(
      s => {
        alert('uspesno rezervisano');
      }
    )
  }

  daLiSmeDaOceni(id: number): boolean{
    if(this.ocenjiviRentovi.indexOf(id) > -1 ) {
      return false;
    }
    else{
      return true;
    }
  }

  oceniServis(rentacar: KompanijaVozila){
    /*if(rentacar.ulogovanogKorisnikaOcena > 0){
      let ocena: OcenaRenta = new OcenaRenta();
      ocena.rentACar = rentacar;
      ocena.ocenaRenta = rentacar.ulogovanogKorisnikaOcena;
      this.rentacarService.oceniServis(1, ocena).subscribe(
        ajde => 
        {
        }
      )
    }*/
  }

  pokaziMapu(longitude : number, latitude: number){
    this.router.navigate(['prikaziMapu/' + longitude + "/" + latitude]);
  }

  vidjivoBrzeRezervacije(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "KORISNIK" /*&& this.idRezervacije !== 0*/){
      return true;
    }
    return false; 
  }

  BrzoRezervisiVozilo(zakup: ZakupVozila){
    //let rezervacija: Rezervacija = JSON.parse(localStorage.getItem('rezervacija'));
    this.rezervacijaService.brzoRezervisiVozilo(this.rezervacija.id, zakup.id).subscribe(
      s => {
        localStorage.removeItem('rezervacija');
      }
    )
  }
}