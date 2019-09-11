import { Component, OnInit } from '@angular/core';
import { VoziloService } from 'app/service/vozila/vozilo.service';
import { KorisnikService } from 'app/service/korisnici/korisnik.service';
import { ZakupVozila } from 'app/model/vozila/zakupVozila';
import { Vozilo } from 'app/model/vozila/vozilo';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';
import { KorisnikPrijava } from 'app/model/korisnici/korisnikPrijava';
import { Korisnik } from 'app/model/korisnici/korisnik';

@Component({
  selector: 'app-istorija-vozila',
  templateUrl: './istorija-vozila.component.html',
  styleUrls: ['./istorija-vozila.component.css']
})
export class IstorijaVozilaComponent implements OnInit {

  constructor(private voziloService: VoziloService, private korisnikService: KorisnikService,
    private rezervacijaService: RezervacijeService) { }

  listaIstorijeVozila: ZakupVozila[] = []
  korisnik: Korisnik = new Korisnik();

  ngOnInit() {

  //  let zakup: ZakupVozila = new ZakupVozila();
  //  zakup.cenaZakupa = 50;
  //  zakup.krajnjiDatum = "11/11/2011";
  //  zakup.pocetniDatum = "11/11/2011";
  //  zakup.tip = "tip";
  //  zakup.ocena = 1;
  //  zakup.voziloDTO = new Vozilo();
  //  zakup.voziloDTO.naziv = "naziv";
  //  zakup.brojPutnika = 5;

  // this.listaIstorijeVozila.push(zakup);
  // this.listaIstorijeVozila.push(zakup);

  this.korisnik = JSON.parse(localStorage.getItem('token'));
  this.rezervacijaService.istorijaZakupaVozila(this.korisnik.id).subscribe(
    s => {
      this.listaIstorijeVozila = s;
    }
  )
  
  }

  getHistoryOfRentedCars(){
    /*this.voziloService.findHistoryOfRentedCars().subscribe(
      suc => { 
        this.listaIstorijeVozila = suc;
        
        this.listaIstorijeVozila.forEach(element => {
          if(element.ocena > 0){
            element.mozeDaOceni = false; 
          }
          else{
            element.mozeDaOceni = true; 
          }          
        });
      }
    );*/
  }

  oceniVozilo(rezervisanoVozilo: ZakupVozila){
    // if(rezervisanoVozilo.mozeDaOceni){
    //   this.voziloService.oceniRezervisanoVozilo(rezervisanoVozilo.id, rezervisanoVozilo.ocena).subscribe(
    //     s =>{
    //       rezervisanoVozilo.mozeDaOceni = false;
    //     }
    //   );
    // }

    this.rezervacijaService.oceniVozilo(rezervisanoVozilo.id, rezervisanoVozilo.ocena).subscribe(
      s => {
        
      }
    )
  }

}
