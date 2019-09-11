import { Component, OnInit } from '@angular/core';
import { Let } from 'app/model/avionskakompanija/let';
import { Options, LabelType } from 'ng5-slider';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'app/auth.service';
import { LetService } from 'app/service/avionskaKompanija/let.service';
import { Destinacija } from 'app/model/opsti/destinacija';
import { AvionskaKarta } from 'app/model/avionskakompanija/avionskaKarta';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { PretragaLeta } from 'app/model/opsti/pretragaLeta';

@Component({
  selector: 'app-prikaz-letova',
  templateUrl: './prikaz-letova.component.html',
  styleUrls: ['./prikaz-letova.component.css']
})
export class PrikazLetovaComponent implements OnInit {
  public korisnik: Korisnik;
  pretraga: PretragaLeta = new PretragaLeta();

  constructor(private letService : LetService,  private router: Router, private route: ActivatedRoute,  
    private authService: AuthService) {
    this.korisnik = JSON.parse(localStorage.getItem('token'));
  }

  postaviVrednosti(){
    let let1 = new Let();
    let1.id = 1;
    let1.duzina = 1;
    let1.vreme = 1;
    let1.vremePoletanja = "2019/02/02";
    let1.vremeSletanja = "2019/02/02";

    let let2 = new Let();
    let2.id = 3;
    let2.duzina = 2;
    let2.vreme = 2;
    let2.vremePoletanja = "2019/03/03";
    let2.vremeSletanja = "2019/04/04";

    let destinacija1 = new Destinacija();
    destinacija1.id = 1;
    destinacija1.zemlja = "srbija";
    destinacija1.grad = "beograd";

    let destinacija2 = new Destinacija();
    destinacija2.id = 2;
    destinacija2.zemlja = "ssssss";
    destinacija2.grad = "sssada";

    let destinacija3 = new Destinacija();
    destinacija3.id = 3;
    destinacija3.zemlja = "aaaa";
    destinacija3.grad = "aaaa";

    let1.polazisteDTO = destinacija1;
    let1.odredisteDTO = destinacija1;
    // let1.presedanja.push(destinacija2);
    // let1.presedanjaDTO.push(destinacija2);
    // let1.presedanjaDTO.push(destinacija3);

    let2.polazisteDTO = destinacija3;
    let2.odredisteDTO = destinacija3;
    // let2.presedanjaDTO.push(destinacija1);
    // let2.presedanjaDTO.push(destinacija2);

    this.letovi = [];
    this.letovi.push(let1);
    this.letovi.push(let2);
  }

  id: number; //kompanija-id
  public letovi: Let[] = [];
  private sub: any;
  isDataAvailable: boolean;
  public tipkorisnika: string;
  public avionskaKarta: AvionskaKarta = new AvionskaKarta();
  dropdownSettings = {};
  tipoviVozila: string[];
  mestaFilijala: string[];
  public min = new Date();
  idRezervacije: number = 0;

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
        //this.garazaId = +params['garaza-id'];
        if(this.id != null )
        {
          this.letService.findAll(this.id).subscribe(
            e => 
            {
              this.letovi = e;
            }
          )

          //this.postaviVrednosti();

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
    this.letService.findAll(this.id).subscribe(
      s => { this.letovi = s; }
    );
  }

  delete(vozilo: Let){
    this.letService.delete(this.id, vozilo.id).subscribe(
      s => {
        this.ngOnInit();
        //this.router.navigate(['hoteli/' + soba.hotel.id + '/prikazSoba']);
      },
      err=> console.log("err")
    );    
   }
 
   update(id: number){
    this.router.navigate(['avionske-kompanije/' + this.id +  '/letovi/add/' + id]);
   }


  add(id: number){ 
    this.router.navigate(['avionske-kompanije/' + this.id + '/letovi/add']);
  }

  // rezervisiDugme(){
  //   if(this.tipkorisnika === "ROLE_Registrovani_korisnik" && this.idRezervacije !==0){
  //     return true;
  //   }
  //   return false; 
  // }

  obrisiVoziloVidljivo(vozilo: Let){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && 
                    this.korisnik.tipAdmina === "ADMIN_AVIONSKE_KOMPANIJE"){
       return true;
    }
    return false; 
  }

  azurirajVoziloVidljivo(vozilo: Let){
    /*if(!vozilo.dozvoljenoBrisanjeIzmena){
      return false;
    }*/

    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && 
                    this.korisnik.tipAdmina === "ADMIN_AVIONSKE_KOMPANIJE"){
       return true;
    }
    return false; 
  }

  dodajVoziloVidljivo(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE" && 
                    this.korisnik.tipAdmina === "ADMIN_AVIONSKE_KOMPANIJE"){
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

  prikaziSedista(sobaId: number){
    this.router.navigate(['avionske-kompanije/' + this.id + '/letovi/' + sobaId + '/sedista']);
  }

  createSedista(sobaId: number){
    this.router.navigate(['avionske-kompanije/' + this.id + '/letovi/' + sobaId + '/sedista/add']);
  }

  trazi(){

    this.pretraga.datumPoletanja = this.konvertujUDobroVreme(this.pretraga.datumPoletanja.toString().substring(4,15));
    this.pretraga.datumSletanja = this.konvertujUDobroVreme(this.pretraga.datumSletanja.toString().substring(4,15));

    this.letService.pretraga(this.id, this.pretraga).subscribe(
      s => {
        this.letovi = s;
      }
    )
    /*let rezervacija = new RezervacijaVozila()
    if(this.proveriRezervaciju())
    {
      

  
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

  rezervisiVozilo(idVozila: number){
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
  }

  dodajAdministratora(){
    this.router.navigate(['registracija/admin/avion']);
  }

 izvestajPoslovanja(){  //avionske-kompanije/:id/izvestaj-poslovanja-avion
    this.router.navigate(['avionske-kompanije/' + this.id +  '/izvestaj-poslovanja-avion']);
  }
}