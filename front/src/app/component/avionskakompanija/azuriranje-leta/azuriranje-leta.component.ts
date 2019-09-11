import { Component, OnInit } from '@angular/core';
import { Let } from 'app/model/avionskakompanija/let';
import { LetService } from 'app/service/avionskaKompanija/let.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Destinacija } from 'app/model/opsti/destinacija';

@Component({
  selector: 'app-azuriranje-leta',
  templateUrl: './azuriranje-leta.component.html',
  styleUrls: ['./azuriranje-leta.component.css']
})
export class AzuriranjeLetaComponent implements OnInit {

  id: number; //id let
  idKompanija: number;

  letic: Let = new Let();
  pomocnaLista: Destinacija[] = [];
  private sub: any;
  isDataAvailable: boolean;
  maksimalnaDuzina: number = 30;
  polaziste: string[] = [];
  odrediste: string[] = [];
  izabranoOdrediste: string = "";
  izabranoPolaziste: string = "";
  presedanja: string = "";
  dropdownSettings = {};
  dropdownSettings2 = {};

  constructor(private letService :LetService, private route: ActivatedRoute, private router: Router) 
  { 
      
  }

  ngOnInit() {

    let listaStringova: string[] = []

    this.letService.destinacije().subscribe(
      ss => {
        this.pomocnaLista = ss;
        this.pomocnaLista.forEach( item => {
          listaStringova.push(item.id + " " + item.grad + " " + item.zemlja);
          this.odrediste.push(item.id + " " + item.grad + " " + item.zemlja);
        })

        this.polaziste = listaStringova;
        this.odrediste = listaStringova;
      }
    )

    

    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      this.idKompanija = +params['kompanija-id'];
      //this.idGaraze = +params['garaza-id'];
      if(params['let-id'] != null){
        this.id = +params['let-id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa  
        if(this.id != null)
        {
          this.letService.findOne(this.idKompanija, this.id).subscribe(
            e => {
              this.letic = e;

             
            }
          )

          this.isDataAvailable = true;
        }
        else{
          //znaci dodajem novi koji ne postoji
          this.letic = new Let();
          this.isDataAvailable = false;
        }
     }
   });

   this.dropdownSettings = {
    singleSelection: true,
    // idField: 'id',
    //textField: 'adreseRenta',
    itemsShowLimit: 3,
    allowSearchFilter: true
  };

  this.dropdownSettings2 = {
    singleSelection: false,
    // idField: 'id',
    //textField: 'adreseRenta',
    itemsShowLimit: 3,
    allowSearchFilter: true
  };
  }

  create(){
    let message: string = this.proveriUnos();
    if(message === "OK"){
      this.letic.polazisteDTO.id = +this.izabranoPolaziste.toString().split(' ')[0];
      this.letic.odredisteDTO.id = +this.izabranoOdrediste.toString().split(' ')[0];
      this.letic.vremePoletanja = this.konvertujUDobroVreme(this.letic.vremePoletanja.toString().substring(4,21));
      this.letic.vremeSletanja = this.konvertujUDobroVreme(this.letic.vremeSletanja.toString().substring(4,21))
      this.letService.add(this.idKompanija, this.letic).subscribe(
        s => {
          this.letic = s;
          this.router.navigate(['avionske-kompanije/' + this.idKompanija  + '/letovi']);
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
      this.letService.update(this.idKompanija, this.letic.id, this.letic).subscribe(
        s => {
          this.letic = s;
          this.router.navigate(['avionske-kompanije/' + this.idKompanija  + '/letovi']);
        },
        err => 
        {
          console.log("err")
           if( err.status === 418){  // i'm a teapot znaci vec je izmenjeno od strane drugog admina
            alert("Nije moguce izmeniti zeljeni let vec je izmenjeno od strane drugog admina.")
            }
        }
      );    
    }
    else{
      alert(message)
    }
  }

  goBack(){
    this.router.navigate(['avionske-kompanije/' + this.idKompanija  + '/letovi']);
  }

  proveriUnos(): string{

    if(this.letic.cena <= 0){
      return "Morate popuniti cenu  po danu koja mora biti pozitivan broj";
    }

    return "OK"
  }

  konvertujUDobroVreme(primljeniString: string): string{
    let pravoVreme: string;
    pravoVreme = primljeniString.substring(7,11) + "/" + primljeniString.substring(0,3) + "/" + primljeniString.substring(4,6) + " " + primljeniString.substring(12,14) + ":" + 
                                                                                                                                        primljeniString.substring(15,17);
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
