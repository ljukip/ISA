import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, NavigationExtras } from '@angular/router';
import { AuthService } from 'app/auth.service';
import { SobaService } from 'app/service/hotel/soba.service';
import { Soba } from 'app/model/hotel/soba';
import { ZakupSoba } from 'app/model/hotel/zakupSoba';
import { Options, LabelType } from 'ng5-slider';
import { Hotel } from 'app/model/hotel/hotel';
import { ZakupVozila } from 'app/model/vozila/zakupVozila';
import { KorisnikPrijava } from 'app/model/korisnici/korisnikPrijava';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';
import { Rezervacija } from 'app/model/opsti/rezervacija';
import { PretragaSobe } from 'app/model/opsti/pretragaSobe';

@Component({
  selector: 'app-prikaz-soba',
  templateUrl: './prikaz-soba.component.html',
  styleUrls: ['./prikaz-soba.component.css']
})
export class PrikazSobaComponent implements OnInit {

  constructor(private voziloService : SobaService,  private router: Router, private route: ActivatedRoute,  
    private authService: AuthService, private rezervacijaService: RezervacijeService) {
    this.korisnik = JSON.parse(localStorage.getItem('token'));
    if(this.korisnik != null){
      //this.tipkorisnika = this.authService.getRoles(res);
    }
    else{
      this.tipkorisnika = "nema_korisnika";
    }
  }

  id: number; //hotel-id
  public sobe: Soba[] = [];
  private sub: any;
  isDataAvailable: boolean;
  public tipkorisnika: string;
  public rezervacijaSobe: ZakupSoba = new ZakupSoba();
  dropdownSettings = {};
  tipoviVozila: string[];
  mestaFilijala: string[];
  public min = new Date();
  idRezervacije: number = 0;
  korisnik: Korisnik = new Korisnik();
  vidljivaSedista: boolean = true;
  pretraga: PretragaSobe = new PretragaSobe();

  minValue: number = 100;
  maxValue: number = 400;
  options: Options = {
    floor: this.minValue,
    ceil: this.maxValue,
    translate: (value: number, label: LabelType): string => {
      switch (label) {
        case LabelType.Low:
          return '<b>Min price:</b> $' + value;
        case LabelType.High:
          return '<b>Max price:</b> $' + value;
        default:
          return '$' + value;
      }
    }
  };
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      if(params['hotel-id'] != null){
        this.id = +params['hotel-id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa
        //this.garazaId = +params['garaza-id'];
        if(this.id != null )
        {
          this.voziloService.findAll(this.id).subscribe(
            e => 
            {
              this.sobe = e;
            }
          )

          /*this.voziloService.vratiSveTipove().subscribe(
            s => 
            {
              this.tipoviVozila = s;
            }
          )

          this.filijalaService.vratiFilijaleForRent(this.id).subscribe(
            a => 
            {
              this.mestaFilijala = a;
            }
          )*/

          this.dropdownSettings = {
            singleSelection: true,
            // idField: 'id',
            // textField: 'tipoviVozila',
            itemsShowLimit: 3,
            allowSearchFilter: true
          };

          /*this.voziloService.minimalnaCenaVozila().subscribe(
            succ => 
            {
              this.minValue = succ;

              this.voziloService.maksimalnaCenaVozila().subscribe(
                success => 
                {
                  this.maxValue = success;
    
                  this.options =  {
                    floor: this.minValue,
                    ceil: this.maxValue,
                    translate: (value: number, label: LabelType): string => {
                      switch (label) {
                        case LabelType.Low:
                          return '<b>Min price:</b> $' + value;
                        case LabelType.High:
                          return '<b>Max price:</b> $' + value;
                        default:
                          return '$' + value;
                      }
                    }
                  };
                }
              )
            }
          ) */
        }
     }
   });

    // this.route.queryParams.subscribe(params => {
    //   if(params["idRezervacije"] !== undefined){
    //     this.idRezervacije = params["idRezervacije"];
    //   }
    // });
  }

  getAll(){
    this.voziloService.findAll(this.id).subscribe(
      s => { this.sobe = s; }
    );
  }

  delete(vozilo: Soba){
    this.voziloService.delete(this.id, vozilo.id).subscribe(
      s => {
        this.ngOnInit();
        //this.router.navigate(['hoteli/' + soba.hotel.id + '/prikazSoba']);
      },
      err=> console.log("err")
    );    
   }
 
   update(id: number){
    this.router.navigate(['hoteli/' + this.id +  '/sobe/add/' + id]);
   }


  add(id: number){ 
    this.router.navigate(['hoteli/' + this.id + '/sobe/add']);
  }

  rezervisiDugme(){
    let temp: Rezervacija = JSON.parse(localStorage.getItem('rezervacija'));
     if(this.korisnik.tipKorisnika === "KORISNIK" && temp != null){
        return true;
     }
     return false; 
   }

  obrisiVoziloVidljivo(vozilo: Hotel){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && this.korisnik.tipAdmina === "ADMIN_HOTELA"){
      return true;
   }
   return false; 
  }

  azurirajVoziloVidljivo(vozilo: Hotel){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && this.korisnik.tipAdmina === "ADMIN_HOTELA"){
      return true;
   }
   return false; 
  }

  dodajVoziloVidljivo(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" 
                  && this.korisnik.tipAdmina === "ADMIN_HOTELA"){
      return true;
   }
   return false; 
  }

  dodajAdminaVidljivo(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_SISTEMA"){
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

  vidljivoPretraga(){
    // if(this.tipkorisnika === "ROLE_Registrovani_korisnik" || this.tipkorisnika === "nema_korisnika"){
    //   return true;
    // }
    // return false; 
    return true;
  }

  prikaziCenovnike(sobaId: number){
    this.router.navigate(['hoteli/' + this.id + '/sobe/' + sobaId + '/cenovnici']);
  }

  createCenovnik(sobaId: number){
    this.router.navigate(['hoteli/' + this.id + '/sobe/' + sobaId + '/cenovnici/add']);
  }

  trazi(){
    this.pretraga.pocetnaCena = this.minValue;
    this.pretraga.krajnjaCena = this.maxValue;
    this.pretraga.pocetniDatum = this.konvertujUDobroVreme(this.pretraga.pocetniDatum.toString().substring(4,15));
    this.pretraga.krajnjiDatum = this.konvertujUDobroVreme(this.pretraga.krajnjiDatum.toString().substring(4,15));


    this.voziloService.pretraga(this.id, this.pretraga).subscribe(
      s => {
        this.sobe = s;
      }
    )

    /*let rezervacija = new RezervacijaVozila()
    if(this.proveriRezervaciju())
    {
      rezervacija.datumPreuzimanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumPreuzimanja.toString().substring(4,15));
      rezervacija.datumVracanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumVracanja.toString().substring(4,15));
      rezervacija.tipVozila = this.rezervacijaVozila.tipVozila.toString();
      rezervacija.mestoPreuzimanja = this.rezervacijaVozila.mestoPreuzimanja.toString();
      rezervacija.mestoVracanja = this.rezervacijaVozila.mestoVracanja.toString();
      rezervacija.brojPutnika = this.rezervacijaVozila.brojPutnika;
      rezervacija.minimalnaCena = this.minValue;
      rezervacija.maksimalnaCena = this.maxValue;
      this.voziloService.traziVozilo(rezervacija, this.id).subscribe(
        s => {
          this.vozila = s;
        },
        err=> console.log("err")
      );    
      }
      else{
        alert("morate uneti datum preuzimanja i vracanja, mesto preuzimanja i broj putnika veci od 0");
      }*/
  }

  konvertujUDobroVreme(primljeniString: string): string{
    let pravoVreme: string;
    pravoVreme = primljeniString.substring(7,11) + "-" + primljeniString.substring(0,3) + "-" + primljeniString.substring(4,6);
    pravoVreme = this.mesecPrebaciUbroj(pravoVreme); 
    //alert(pravoVreme)
    return pravoVreme;
  }

  mesecPrebaciUbroj(primljeniString: string): string{
    primljeniString = primljeniString.replace("Jan", "01");
    primljeniString = primljeniString.replace("Feb", "02");
    primljeniString = primljeniString.replace("Mar", "03");
    primljeniString = primljeniString.replace("Apr", "04");
    primljeniString = primljeniString.replace("May", "05");
    primljeniString = primljeniString.replace("Jun", "06");
    primljeniString = primljeniString.replace("Jul", "07");
    primljeniString = primljeniString.replace("Aug", "08");
    primljeniString = primljeniString.replace("Sep", "09");
    primljeniString = primljeniString.replace("Oct", "10");
    primljeniString = primljeniString.replace("Nov", "11");
    primljeniString = primljeniString.replace("Dec", "12");

    return primljeniString;
    
  }

  proveriRezervaciju(): boolean{
    /*if(this.rezervacijaVozila.datumPreuzimanja === "")
      return false;
    if(this.rezervacijaVozila.datumVracanja === "")
      return false;
    if(this.rezervacijaVozila.mestoPreuzimanja === "")
      return false;
    if(this.rezervacijaVozila.brojPutnika <= 0)
      return false;
    if(this.rezervacijaVozila.datumPreuzimanja > this.rezervacijaVozila.datumVracanja)
      return false;
*/
    return true;
  }

  rezervisi(soba: Soba){
      //alert(idVozila)
    //let rezervacija = new ZakupSoba();
    /*if(this.proveriRezervaciju())
    {*/
      this.rezervacijaSobe.pocetniDatum = this.konvertujUDobroVreme(this.rezervacijaSobe.pocetniDatum.toString().substring(4,15));
      this.rezervacijaSobe.krajnjiDatum = this.konvertujUDobroVreme(this.rezervacijaSobe.krajnjiDatum.toString().substring(4,15));
      this.rezervacijaSobe.soba = soba;
      this.rezervacijaSobe.tip = "REDOVAN";

      let temp: Rezervacija = JSON.parse(localStorage.getItem('rezervacija'));

      this.rezervacijaService.zakupSobe(temp.id, this.rezervacijaSobe).subscribe(
        s=> {
          let rezervacija: Rezervacija = s;
          localStorage.setItem('rezervacija', JSON.stringify(rezervacija));
          this.vidljivaSedista = false;
          //this.router.navigate(['kompanije-vozila']);
        }
      )
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
    let temp: Rezervacija = JSON.parse(localStorage.getItem('rezervacija'));
    this.rezervacijaService.zavrsiRezervaciju(temp.id).subscribe(
      s => {
        localStorage.removeItem('rezervacija');
        //idi na stranicu za prikaz rezervacije
        this.router.navigate(['rezervacije']);
      }
    )
  }

  dodajAdministratora(){
    this.router.navigate(['registracija/admin/hotel']);
  }

  izvestajPoslovanja(){
    this.router.navigate(['hoteli/' + this.id +  '/izvestaj-poslovanja-hotel']);
  }
}