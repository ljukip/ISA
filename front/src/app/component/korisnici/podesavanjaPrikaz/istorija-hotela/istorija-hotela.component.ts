import { Component, OnInit } from '@angular/core';
import { KorisnikService } from 'app/service/korisnici/korisnik.service';
import { ZakupSoba } from 'app/model/hotel/zakupSoba';
import { SobaService } from 'app/service/hotel/soba.service';
import { Soba } from 'app/model/hotel/soba';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { RezervacijeService } from 'app/service/rezervacije/rezervacije.service';

@Component({
  selector: 'app-istorija-hotela',
  templateUrl: './istorija-hotela.component.html',
  styleUrls: ['./istorija-hotela.component.css']
})
export class IstorijaHotelaComponent implements OnInit {

 
  constructor(private hotelService: SobaService, private korisnikService: KorisnikService, 
    private rezervacijaService: RezervacijeService) { }

  listaIstorijeSoba: ZakupSoba[] = []
  korisnik: Korisnik = new Korisnik();

  ngOnInit() {

  //  let zakup: ZakupSoba = new ZakupSoba();
  //  zakup.cenaZakupa = 50;
  //  zakup.krajnjiDatum = "11/11/2011";
  //  zakup.pocetniDatum = "11/11/2011";
  //  zakup.tip = "tip";
  //  zakup.ocena = 3;
  // //zakup.sobe = [];
  // //zakup.voziloDTO.naziv = "naziv";
  //  zakup.brojGostiju = 5;

  // this.listaIstorijeSoba.push(zakup);
  // this.listaIstorijeSoba.push(zakup);

  this.korisnik = JSON.parse(localStorage.getItem('token'));
  this.rezervacijaService.istorijaZakupaSoba(this.korisnik.id).subscribe(
    s => {
      this.listaIstorijeSoba = s;
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

  oceniSobu(rezervisanoVozilo: ZakupSoba){
    // if(rezervisanoVozilo.mozeDaOceni){
    //   this.voziloService.oceniRezervisanoVozilo(rezervisanoVozilo.id, rezervisanoVozilo.ocena).subscribe(
    //     s =>{
    //       rezervisanoVozilo.mozeDaOceni = false;
    //     }
    //   );
    // }

    this.rezervacijaService.oceniSobu(rezervisanoVozilo.id, rezervisanoVozilo.ocena).subscribe(
      s => {
        
      }
    )
  }

}
