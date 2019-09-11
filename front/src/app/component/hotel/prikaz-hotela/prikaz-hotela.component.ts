import { Component, OnInit } from '@angular/core';
import { Hotel } from 'app/model/hotel/hotel';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';
import { AuthService } from 'app/auth.service';
import { HotelService } from 'app/service/hotel/hotel.service';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { ZakupSoba } from 'app/model/hotel/zakupSoba';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';
import { Rezervacija } from 'app/model/opsti/rezervacija';
import { PretragaKompanijeVozila } from 'app/model/opsti/pretragaKompanijaVozila';

@Component({
  selector: 'app-prikaz-hotela',
  templateUrl: './prikaz-hotela.component.html',
  styleUrls: ['./prikaz-hotela.component.css']
})
export class PrikazHotelaComponent implements OnInit {

  public hoteli: Hotel[] = [];
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
  ajde: boolean = false;

  brzeVidljiveClick = false;
  zakupi: ZakupSoba[] = [];
  rezervacija: Rezervacija = new Rezervacija();


  constructor(private route: ActivatedRoute, private hotelService : HotelService, private router: Router, 
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

    this.hotelService.vratiSveAdrese().subscribe(
      s => 
      {
       s.forEach(item => {
          let temp: string = item.zemlja + " " + item.grad + " " + item.ulica + " " + item.broj;
          this.pomAdreseRenta.push(temp);
        }); 

        this.adreseRenta = this.pomAdreseRenta;
      }
    )

    this.hotelService.vratiSveNazive().subscribe(
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
      this.hotelService.findAll().subscribe(
        
        s => { 
          this.hoteli = s;
        }
      );

      this.rezervacijaService.vratiBrzeRezervacijeSobe(1).subscribe(
        s => {

        }
      )
   // }
  }

  delete(id: number){
    this.hotelService.delete(id).subscribe(
      s => this.getAll(),
      err=> console.log("err")
    );    
   }
 
   update(id: number){
    this.router.navigate(['hoteli/add', id]);
   }

   postaviFilijalu(id: number){
    this.idFilijala = id;
   }

   viewDetails(id: number){
     //if(this.idFilijala != 0){
      this.router.navigate(['hoteli/' + id + '/sobe']);
     /*}
     else{
       alert('izaberi filjalu');
     }*/
    
  }

  createRoom(id: number){
    this.router.navigate(['hoteli/' + id + '/sobe/add']);
  }

  createOption(id: number){
    this.router.navigate(['hoteli/' + id + '/opcije/add']);
  }

  viewOption(id: number){
    this.router.navigate(['hoteli/' + id + '/opcije']);
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
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && this.korisnik.tipAdmina === "ADMIN_HOTELA"){
      return true;
   }
   return false; 
  }

  ulogovaniKorisnikImaDozvoluDaBrise(){
   if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && this.korisnik.tipAdmina === "ADMIN_HOTELA"){
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

    this.hotelService.trazi(pretraga).subscribe(
      s => {
        this.hoteli = s;
      }
    )
  }

  getAllSort(paramSort: string){
    this.hotelService.findAllSort(paramSort, this.paramDir).subscribe(
      ss => { this.hoteli = ss; }
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
    this.rezervacijaService.vratiBrzeRezervacijeSobe(0).subscribe(
      s => {
        this.zakupi = s;
      }
    )
  }

  rezervisi(zakupSobe: ZakupSoba){
    this.rezervacijaService.zakupSobe(this.rezervacija.id, zakupSobe).subscribe(
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

  oceniServis(rentacar: Hotel){
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

  BrzoRezervisiVozilo(zakup: ZakupSoba){
    //let rezervacija: Rezervacija = JSON.parse(localStorage.getItem('rezervacija'));
    this.rezervacijaService.brzoRezervisiSobu(this.rezervacija.id, zakup.id).subscribe(
      s => {
        localStorage.removeItem('rezervacija');
      }
    )
  }
}