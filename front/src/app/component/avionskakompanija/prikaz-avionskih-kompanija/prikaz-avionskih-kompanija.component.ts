import { Component, OnInit } from '@angular/core';
import { AvionskaKompanija } from 'app/model/avionskakompanija/avionskaKompanija';
import { NavigationExtras, ActivatedRoute, Router } from '@angular/router';
import { AvionskaKompanijaService } from 'app/service/avionskaKompanija/avionska-kompanija.service';
import { AuthService } from 'app/auth.service';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { PretragaKompanijeVozila } from 'app/model/opsti/pretragaKompanijaVozila';

@Component({
  selector: 'app-prikaz-avionskih-kompanija',
  templateUrl: './prikaz-avionskih-kompanija.component.html',
  styleUrls: ['./prikaz-avionskih-kompanija.component.css']
})
export class PrikazAvionskihKompanijaComponent implements OnInit {

  public aviokompanije: AvionskaKompanija[] = [];
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

  constructor(private route: ActivatedRoute, private avionskaKompanijaService : AvionskaKompanijaService, 
    private router: Router, private authService: AuthService) 
   {
    this.korisnik = JSON.parse(localStorage.getItem('token'));
    this.getAll();
  }

  ngOnInit() {

    this.avionskaKompanijaService.vratiSveAdrese().subscribe(
      s => 
      {
       s.forEach(item => {
          let temp: string = item.zemlja + " " + item.grad + " " + item.ulica + " " + item.broj;
          this.pomAdreseRenta.push(temp);
        }); 

        this.adreseRenta = this.pomAdreseRenta;
      }
    )

    this.avionskaKompanijaService.vratiSveNazive().subscribe(
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
      this.avionskaKompanijaService.findAll().subscribe(
        
        s => { 
          this.aviokompanije = s;
        }
      );
   // }
  }

  delete(id: number){
    this.avionskaKompanijaService.delete(id).subscribe(
      s => this.getAll(),
      err=> console.log("err")
    );    
   }
 
   update(id: number){
    this.router.navigate(['avionske-kompanije/add', id]);
   }


   viewDetails(id: number){
     //if(this.idFilijala != 0){
      this.router.navigate(['avionske-kompanije/' + id + '/letovi']);
     /*}
     else{
       alert('izaberi filjalu');
     }*/
    
  }

  createLet(id: number){
    this.router.navigate(['avionske-kompanije/' + id + '/letovi/add']);
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
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && 
                    this.korisnik.tipAdmina === "ADMIN_AVIONSKE_KOMPANIJE"){
      return true;
    }
    return false; 
  }

  ulogovaniKorisnikImaDozvoluDaBrise(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && 
                    this.korisnik.tipAdmina === "ADMIN_AVIONSKE_KOMPANIJE"){
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

    this.avionskaKompanijaService.trazi(pretraga).subscribe(
      s => {
        this.aviokompanije = s;
      }
    )
  }

  getAllSort(paramSort: string){
    this.avionskaKompanijaService.findAllSort(paramSort, this.paramDir).subscribe(
      ss => { this.aviokompanije = ss; }
    );
    if (this.paramDir === 'ASC'){
      this.paramDir = 'DESC';
    } else {
      this.paramDir = 'ASC';
    }
  }

  brzaRezervacija(){
    let navigationExtras: NavigationExtras = {
      queryParams: {
          "idRezervacije" : this.idRezervacije
      }
    };
    this.router.navigate(['rentacarovi/brzaRezervacijaVozila'], navigationExtras);
  }

  daLiSmeDaOceni(id: number): boolean{
    if(this.ocenjiviRentovi.indexOf(id) > -1 ) {
      return false;
    }
    else{
      return true;
    }
  }

  oceniServis(rentacar: AvionskaKompanija){
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
    if(this.korisnik != null && this.korisnik.tipKorisnika === "KORISNIK"/* && this.idRezervacije !== 0*/){
      return true;
    }
    return false; 
  }
}