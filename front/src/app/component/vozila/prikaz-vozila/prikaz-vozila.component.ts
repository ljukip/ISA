import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router, ActivatedRoute } from '@angular/router';
import { Vozilo } from 'app/model/vozila/vozilo';
import { LabelType, Options } from 'ng5-slider';
import { VoziloService } from 'app/service/vozila/vozilo.service';
import { AuthService } from 'app/auth.service';
import { GarazaService } from 'app/service/vozila/garaza.service';
import { ZakupVozila } from 'app/model/vozila/zakupVozila';
import { ZakupSoba } from 'app/model/hotel/zakupSoba';
import { Rezervacija } from 'app/model/opsti/rezervacija';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { PretragaVozila } from 'app/model/opsti/pretragaVozila';

@Component({
  selector: 'app-prikaz-vozila',
  templateUrl: './prikaz-vozila.component.html',
  styleUrls: ['./prikaz-vozila.component.css']
})
export class PrikazVozilaComponent implements OnInit {
  public korisnik: Korisnik;
  constructor(private voziloService : VoziloService, private filijalaService: GarazaService, private router: Router, 
    private route: ActivatedRoute,  private authService: AuthService, private rezervacijaService: RezervacijeService) {
    this.korisnik = JSON.parse(localStorage.getItem('token'));
  }

  id: number; //kompanija-id
  garazaId: number;
  public vozila: Vozilo[] = [];
  private sub: any;
  isDataAvailable: boolean;
  public tipkorisnika: string;
  public rezervacijaVozila: ZakupVozila = new ZakupVozila();
  dropdownSettings = {};
  tipoviVozila: string[];
  mestaFilijala: string[];
  public min = new Date();
  idRezervacije: number = 0;
  vidljivaSedista: boolean = true;
  pretraga: PretragaVozila = new PretragaVozila();

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
      if(params['kompanija-id'] != null){
        this.id = +params['kompanija-id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa
        this.garazaId = +params['garaza-id'];
        if(this.id != null )
        {
          this.voziloService.findAll(this.id, this.garazaId).subscribe(
            e => 
            {
              this.vozila = e;
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
    this.voziloService.findAll(this.id, this.garazaId).subscribe(
      s => { this.vozila = s; }
    );
  }

  deleteVoziloFromRent(vozilo: Vozilo){
    this.voziloService.deleteVozilo(this.id, this.garazaId, vozilo.id).subscribe(
      s => {
        this.ngOnInit();
        //this.router.navigate(['hoteli/' + soba.hotel.id + '/prikazSoba']);
      },
      err=> console.log("err")
    );    
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
 
   update(id: number){
    this.router.navigate(['kompanije-vozila/' + this.id + '/garaze/' + this.garazaId + '/vozila/add/' + id]);
   }


  addVozilo(id: number){ 
    this.router.navigate(['kompanije-vozila/' + this.id + '/garaze/' + this.garazaId + '/vozila/add']);
  }

  rezervisiDugme(){
    let temp: Rezervacija = JSON.parse(localStorage.getItem('rezervacija'));
    if(this.korisnik != null && this.korisnik.tipKorisnika === "KORISNIK" && temp != null){
      return true;
    }
    return false; 
  }

  obrisiVoziloVidljivo(vozilo: Vozilo){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && this.korisnik.tipAdmina === "ADMIN_KOMPANIJE_VOZILA"){
      return true;
     }
     return false; 
  }

  azurirajVoziloVidljivo(vozilo: Vozilo){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && this.korisnik.tipAdmina === "ADMIN_KOMPANIJE_VOZILA"){
      return true;
     }
     return false; 
  }

  dodajVoziloVidljivo(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && this.korisnik.tipAdmina === "ADMIN_KOMPANIJE_VOZILA"){
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

  trazi(){

    this.pretraga.pocetnaCena = this.minValue;
    this.pretraga.krajnjaCena = this.maxValue;
    this.pretraga.pocetniDatum = this.konvertujUDobroVreme(this.pretraga.pocetniDatum.toString().substring(4,15));
    this.pretraga.krajnjiDatum = this.konvertujUDobroVreme(this.pretraga.krajnjiDatum.toString().substring(4,15));

    this.voziloService.pretraga(this.id, this.garazaId, this.pretraga).subscribe(
      s => {
        this.vozila = s;
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

  rezervisiVozilo(vozilo: Vozilo){
      //alert(idVozila)
    /*let rezervacija = new RezervacijaVozila()
    if(this.proveriRezervaciju())
    {
      rezervacija.datumPreuzimanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumPreuzimanja.toString().substring(4,15));
      rezervacija.datumVracanja = this.konvertujUDobroVreme(this.rezervacijaVozila.datumVracanja.toString().substring(4,15));
      rezervacija.tipVozila = this.rezervacijaVozila.tipVozila.toString();
      rezervacija.mestoPreuzimanja = this.rezervacijaVozila.mestoPreuzimanja.toString();
      rezervacija.mestoVracanja = this.rezervacijaVozila.mestoVracanja.toString();
      rezervacija.brojPutnika = this.rezervacijaVozila.brojPutnika;
      rezervacija.vozilo.id = idVozila;
      rezervacija.minimalnaCena = this.minValue;
      rezervacija.maksimalnaCena = this.maxValue;

      let navigationExtras: NavigationExtras = {
        queryParams: {
            "datumPreuzimanja": rezervacija.datumPreuzimanja,
            "datumVracanja": rezervacija.datumVracanja,
            "brojPutnika" : rezervacija.brojPutnika,
            "mestoPreuzimanja" : rezervacija.mestoPreuzimanja,
            "mestoVracanja" : rezervacija.mestoVracanja,
            "idRezervacije" : this.idRezervacije,
            
        }
    };
        this.router.navigate(['/rentacarovi/' + idVozila + '/potvrdiRezervaciju'], navigationExtras);

    }
    else{
      alert("morate uneti datum preuzimanja i vracanja, datum preuzimanja mora biti pre datuma vracanja, mesto preuzimanja i broj putnika veci od 0");
    }*/

    this.rezervacijaVozila.pocetniDatum = this.konvertujUDobroVreme(this.rezervacijaVozila.pocetniDatum.toString().substring(4,15));
      this.rezervacijaVozila.krajnjiDatum = this.konvertujUDobroVreme(this.rezervacijaVozila.krajnjiDatum.toString().substring(4,15));
      this.rezervacijaVozila.voziloDTO = vozilo;
      this.rezervacijaVozila.tip = "REDOVAN";

      let temp: Rezervacija = JSON.parse(localStorage.getItem('rezervacija'));

      this.rezervacijaService.zakupVozila(temp.id, this.rezervacijaVozila).subscribe(
        s=> {
          let rezervacija: Rezervacija = s;
          localStorage.setItem('rezervacija', JSON.stringify(rezervacija));
          this.vidljivaSedista = false;
          //this.router.navigate(['kompanije-vozila']);
        }
      )
  }

  dodajAdministratora(){
    this.router.navigate(['registracija/admin/vozilo']);
  }

  izvestajPoslovanja(){
    //this.router.navigate(['rentacarovi/' + this.id +  '/izvestaj']); izvestaj-poslovanja-vozilo
    this.router.navigate(['/kompanije-vozila/' + this.id + '/izvestaj-poslovanja-vozilo']);
  }
}