import { Component, OnInit } from '@angular/core';
import { Soba } from 'app/model/hotel/soba';
import { ActivatedRoute, Router } from '@angular/router';
import { SobaService } from 'app/service/hotel/soba.service';

@Component({
  selector: 'app-azuriranje-soba',
  templateUrl: './azuriranje-soba.component.html',
  styleUrls: ['./azuriranje-soba.component.css']
})
export class AzuriranjeSobaComponent implements OnInit {

  id: number; //id sobe
  idGaraze: number;
  idKompanija: number;

  soba: Soba = new Soba();
  private sub: any;
  isDataAvailable: boolean;
  maksimalnaDuzina: number = 30;

  constructor(private sobaService :SobaService, private route: ActivatedRoute, private router: Router) 
  { 
      
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      this.idKompanija = +params['hotel-id'];
      //this.idGaraze = +params['garaza-id'];
      if(params['soba-id'] != null){
        this.id = +params['soba-id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa  
        if(this.id != null)
        {
          this.sobaService.findOne(this.idKompanija, this.id).subscribe(
            e => {
              this.soba = e;
            }
          )

          this.isDataAvailable = true;
        }
        else{
          //znaci dodajem novi koji ne postoji
          this.soba = new Soba();
          this.isDataAvailable = false;
        }
     }
   });
  }

  create(){
    let message: string = this.proveriUnos();
    if(message === "OK"){
      this.sobaService.add(this.idKompanija, this.soba).subscribe(
        s => {
          this.soba = s;
          this.router.navigate(['hoteli/' + this.idKompanija  + '/sobe']);
        },
        err=> console.log("err")
      );    
    }
    else{
      alert(message)
    }
  }

  update(){
    let message: string = this.proveriUnos();
    if(message === "OK")
    {
      this.sobaService.update(this.idKompanija, this.soba.id, this.soba).subscribe(
        s => {
          this.soba = s;
          this.router.navigate(['hoteli/' + this.idKompanija  + '/sobe']);
        },
        err => 
        {
          console.log("err")
           if( err.status === 418){  // i'm a teapot znaci vec je izmenjeno od strane drugog admina
            alert("Nije moguce izmeniti zeljenu sobu vec je izmenjeno od strane drugog admina.")
            }
        }
      );    
    }
    else{
      alert(message)
    }
  }

  goBack(){
    this.router.navigate(['hoteli/' + this.idKompanija  + '/sobe']);
  }

  proveriUnos(): string{

    if(this.soba.tip === "" || this.soba.tip.length > this.maksimalnaDuzina){
      return "Morate popuniti tip koja mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    }

    if(this.soba.cenaPoDanu <= 0){
      return "Morate popuniti cenu  po danu koja mora biti pozitivan broj";
    }

    if(this.soba.sprat <= 0){
      return "Morate popuniti sprat koja mora biti pozitivan broj";
    }

    if(this.soba.brojKreveta <= 0){
      return "Morate popuniti broj kreveta koja mora biti pozitivan broj";
    }

    return "OK"
  }
}
