import { Component, OnInit } from '@angular/core';
import { CenovnikSobe } from 'app/model/hotel/cenovnikSobe';
import { ActivatedRoute, Router } from '@angular/router';
import { CenovnikService } from 'app/service/hotel/cenovnik.service';

@Component({
  selector: 'app-azuriranje-cenovnika',
  templateUrl: './azuriranje-cenovnika.component.html',
  styleUrls: ['./azuriranje-cenovnika.component.css']
})
export class AzuriranjeCenovnikaComponent implements OnInit {

  id: number; //cenovnik-id
  kompanijaId: number;
  sobaId: number;
  cenovnik: CenovnikSobe = new CenovnikSobe();
  private sub: any;
  isDataAvailable: boolean;
  maksimalnaDuzina: number = 30;

  constructor(private cenovnikService :CenovnikService,  private route: ActivatedRoute, private router: Router) 
  { 
      
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      this.kompanijaId = +params['hotel-id'];
      this.sobaId = +params['soba-id'];
      if(params['id'] != null){
        this.id = +params['id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa
        
        if(this.id != null )
        {
          this.cenovnikService.findOne(this.kompanijaId, this.sobaId, this.id).subscribe(
            e => {
              this.cenovnik = e;
              
            }
          )
          this.isDataAvailable = true;
        }
        else{
          this.isDataAvailable = false;
          this.cenovnik = new CenovnikSobe();
        }
     }
    //  else{
    //   this.isDataAvailable = false;
    //   this.opcija = new Opcija();

    //   this.kompanijaService.findOne(this.kompanijaId).subscribe(
    //     succ => {
    //       this.opcija.kompanijaDTO = succ;
    //     }
    //   );
    // }
   });
  }

  save(){
    let message: string = this.proveriUnos();
    if(message === "OK"){
      this.cenovnik.pocetniDatum = this.konvertujUDobroVreme(this.cenovnik.pocetniDatum.toString().substring(4,15));
      this.cenovnik.krajnjiDatum = this.konvertujUDobroVreme(this.cenovnik.krajnjiDatum.toString().substring(4,15));
      this.cenovnikService.add(this.cenovnik, this.kompanijaId, this.sobaId).subscribe(
        s => {
          this.cenovnik = s;
          this.router.navigate(['hoteli/' + this.kompanijaId + '/sobe/' + this.sobaId + '/cenovnici']);
        },
        err=> console.log("err")
      );
    }
    else{
      alert(message);
    }    
  }

  update(){
    let message: string = this.proveriUnos();
    if(message === "OK"){
      //this.cenovnik.id = 
      this.cenovnik.pocetniDatum = this.konvertujUDobroVreme(this.cenovnik.pocetniDatum.toString().substring(4,15));
      this.cenovnik.krajnjiDatum = this.konvertujUDobroVreme(this.cenovnik.krajnjiDatum.toString().substring(4,15));
      this.cenovnikService.update(this.kompanijaId, this.sobaId, this.cenovnik).subscribe(
        s => {
         this.cenovnik = s;
         this.router.navigate(['hoteli/' + this.kompanijaId + '/sobe/' + this.sobaId + '/cenovnici']);
        },
        err=> console.log("err")
      );
    }
    else{
      alert(message);
    }    
  }

  goBack(){
    this.router.navigate(['hoteli/' + this.kompanijaId + '/sobe/' + this.sobaId + '/cenovnici']);
  }

  proveriUnos(): string{
    if(this.cenovnik.cena < 0 ){
      return "Morate popuniti cenu koja mora biti pozitivan broj";
    }

    return "OK"
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


}
