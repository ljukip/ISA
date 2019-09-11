import { Component, OnInit } from '@angular/core';
import { Vozilo } from 'app/model/vozila/vozilo';
import { ActivatedRoute, Router } from '@angular/router';
import { VoziloService } from 'app/service/vozila/vozilo.service';

@Component({
  selector: 'app-azuriranje-vozila',
  templateUrl: './azuriranje-vozila.component.html',
  styleUrls: ['./azuriranje-vozila.component.css']
})
export class AzuriranjeVozilaComponent implements OnInit {

  id: number; //id vozila
  idGaraze: number;
  idKompanija: number;

  vozilo: Vozilo = new Vozilo();
  private sub: any;
  isDataAvailable: boolean;
  maksimalnaDuzina: number = 30;

  constructor(private voziloService :VoziloService, private route: ActivatedRoute, private router: Router) 
  { 
      
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      this.idKompanija = +params['kompanija-id'];
      this.idGaraze = +params['garaza-id'];
      if(params['id'] != null){
        this.id = +params['id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa  
        if(this.id != null)
        {
          this.voziloService.findOne(this.idKompanija, this.idGaraze, this.id).subscribe(
            e => {
              this.vozilo = e;
            }
          )

          this.isDataAvailable = true;
        }
        else{
          //znaci dodajem novi koji ne postoji
          this.vozilo = new Vozilo();
          this.isDataAvailable = false;
        }
     }
   });
  }

  create(){
    let message: string = this.proveriUnosVozilo();
    if(message === "OK"){
      this.voziloService.addVozilo(this.idKompanija, this.idGaraze, this.vozilo).subscribe(
        s => {
          this.vozilo = s;
          this.router.navigate(['kompanije-vozila/' + this.idKompanija + '/garaze/' + this.idGaraze + '/vozila']);
        },
        err=> console.log("err")
      );    
    }
    else{
      alert(message)
    }
  }

  update(){
    let message: string = this.proveriUnosVozilo();
    if(message === "OK")
    {
      this.voziloService.updateVozilo(this.idKompanija, this.idGaraze, this.vozilo.id, this.vozilo).subscribe(
        s => {
          this.vozilo = s;
          this.router.navigate(['kompanije-vozila/' + this.idKompanija + '/garaze/' + this.idGaraze + '/vozila']);
        },
        err => 
        {
          console.log("err")
           if( err.status === 418){  // i'm a teapot znaci vec je izmenjeno od strane drugog admina
            alert("Nije moguce izmeniti zeljeno vozilo vec je izmenjeno od strane drugog admina rent a car servisa.")
            }
        }
      );    
    }
    else{
      alert(message)
    }
  }

  goBack(){
    this.router.navigate(['kompanije-vozila/' + this.idKompanija + '/garaze/' + this.idGaraze + '/vozila']);
  }

  proveriUnosVozilo(): string{
    if(this.vozilo.marka === "" || this.vozilo.marka.length > this.maksimalnaDuzina){
      return "Morate popuniti marku vozila koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    }

    // if(this.vozilo.model === "" || this.vozilo.model.length > this.maksimalnaDuzina){
    //   return "Morate popuniti model vozila koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    // }

    // if(this.vozilo.naziv === "" || this.vozilo.naziv.length > this.maksimalnaDuzina){
    //   return "Morate popuniti naziv vozila koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    // }

    if(this.vozilo.tip === "" || this.vozilo.tip.length > this.maksimalnaDuzina){
      return "Morate popuniti tip vozila koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    }

    if(this.vozilo.cenaPoDanu <= 0){
      return "Morate popuniti cenu vozila po danu koja mora biti pozitivan broj";
    }

    if(this.vozilo.godinaProizvodnje <= 0){
      return "Morate popuniti godinu proizvodnje vozila koja mora biti pozitivan broj";
    }

    if(this.vozilo.brojPutnika <= 0){
      return "Morate popuniti broj putnika vozila koja mora biti pozitivan broj";
    }

    return "OK"
  }
}
