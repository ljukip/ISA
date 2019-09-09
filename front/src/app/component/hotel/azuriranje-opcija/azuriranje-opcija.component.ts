import { Component, OnInit } from '@angular/core';
import { Opcija } from 'app/model/hotel/opcija';
import { OpcijaService } from 'app/service/hotel/opcija.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelService } from 'app/service/hotel/hotel.service';

@Component({
  selector: 'app-azuriranje-opcija',
  templateUrl: './azuriranje-opcija.component.html',
  styleUrls: ['./azuriranje-opcija.component.css']
})
export class AzuriranjeOpcijaComponent implements OnInit {

  id: number; //opcija-id
  kompanijaId: number;
  opcija: Opcija = new Opcija();
  private sub: any;
  isDataAvailable: boolean;
  maksimalnaDuzina: number = 30;

  constructor(private opcijaService :OpcijaService,  private route: ActivatedRoute, private router: Router) 
  { 
      
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.isDataAvailable = false;
      this.kompanijaId = +params['hotel-id'];
      if(params['opcija-id'] != null){
        this.id = +params['opcija-id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa
        
        if(this.id != null )
        {
          this.opcijaService.findOne(this.kompanijaId, this.id).subscribe(
            e => {
              this.opcija = e;
              
            }
          )
          this.isDataAvailable = true;
        }
        else{
          this.isDataAvailable = false;
          this.opcija = new Opcija();
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
      this.opcijaService.add(this.opcija, this.kompanijaId).subscribe(
        s => {
          this.opcija = s;
          this.router.navigate(['hoteli/' + this.kompanijaId + '/opcije']);
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
      this.opcijaService.update(this.kompanijaId, this.opcija).subscribe(
        s => {
         this.opcija = s;
         this.router.navigate(['hoteli/' + this.kompanijaId + '/opcije']);
        },
        err=> console.log("err")
      );
    }
    else{
      alert(message);
    }    
  }

  goBack(){
    this.router.navigate(['hoteli/' + this.kompanijaId + '/opcije']);
  }

  proveriUnos(): string{
    if(this.opcija.naziv === "" || this.opcija.naziv.length > this.maksimalnaDuzina){
      return "Morate popuniti ime filijale koje mora biti kraca od " + this.maksimalnaDuzina + " karaktera";
    }

    return "OK"
  }
}