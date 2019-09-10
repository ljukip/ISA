import { Component, OnInit } from '@angular/core';
import { Garaza } from 'app/model/vozila/garaza';
import { GarazaService } from 'app/service/vozila/garaza.service';
import { ActivatedRoute, Router } from '@angular/router';
import { KompanijaVozilaService } from 'app/service/vozila/kompanija-vozila.service';

@Component({
  selector: 'app-azuriranje-garaze',
  templateUrl: './azuriranje-garaze.component.html',
  styleUrls: ['./azuriranje-garaze.component.css']
})
export class AzuriranjeGarazeComponent implements OnInit {

  id: number; //garaza-id
  kompanijaId: number;
  filijala: Garaza = new Garaza();
  private sub: any;
  isDataAvailable: boolean;
  maksimalnaDuzina: number = 30;

  constructor(private filijalaService :GarazaService, private kompanijaService :KompanijaVozilaService, private route: ActivatedRoute, private router: Router) 
  { 
      
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      this.kompanijaId = +params['kompanija-id'];
      if(params['garaza-id'] != null){
        this.id = +params['garaza-id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa
        
        if(this.id != null )
        {
          this.filijalaService.findOne(this.kompanijaId, this.id).subscribe(
            e => {
              this.filijala = e;
              
            }
          )
          this.isDataAvailable = true;
        }
        else{
          this.isDataAvailable = false;
          this.filijala = new Garaza();
        }
     }
     else{
      this.isDataAvailable = false;
      this.filijala = new Garaza();

      this.kompanijaService.findOne(this.kompanijaId).subscribe(
        succ => {
          this.filijala.kompanijaDTO = succ;
        }
      );
    }
   });
  }

  save(){
    let message: string = this.proveriUnosFilijala();
    if(message === "OK"){
      this.filijalaService.addFilijala(this.filijala, this.kompanijaId).subscribe(
        s => {
          this.filijala = s;
          this.router.navigate(['kompanije-vozila/' + this.kompanijaId + '/garaze']);
        },
        err=> console.log("err")
      );
    }
    else{
      alert(message);
    }    
  }

  update(){
    let message: string = this.proveriUnosFilijala();
    if(message === "OK"){
      this.filijalaService.update(this.kompanijaId, this.filijala).subscribe(
        s => {
         this.filijala = s;
         this.router.navigate(['kompanije-vozila/' + this.kompanijaId + '/garaze']);
        },
        err=> console.log("err")
      );
    }
    else{
      alert(message);
    }    
  }

  goBack(){
    this.router.navigate(['kompanije-vozila/' + this.kompanijaId + '/garaze']);
  }

  proveriUnosFilijala(): string{
    /*if(this.filijala.ime === "" || this.filijala.ime.length > this.maksimalnaDuzina){
      return "Morate popuniti ime filijale koje mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    }

    if(this.filijala.adresa === "" || this.filijala.adresa.length > this.maksimalnaDuzina){
      return "Morate popuniti adresu filijale koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    }*/

    return "OK"
  }
}