import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'app/auth.service';
import { AvionskaKompanijaService } from 'app/service/avionskaKompanija/avionska-kompanija.service';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-izvestaj-poslovanja-avion',
  templateUrl: './izvestaj-poslovanja-avion.component.html',
  styleUrls: ['./izvestaj-poslovanja-avion.component.css']
})
export class IzvestajPoslovanjaAvionComponent implements OnInit {

  public pocetniDatum;
  public krajnjiDatum;
  dropdownSettings = {};
  period: string[] = ["Dnevno", "Nedeljno", "Mesecno"];
  prihod: number = 0;
  sub : any;
  id: number;
  public posecenost : String[];
  chart = [];
  labels: string[] = [];
  data: string[] = [];
  
  constructor(private router: Router, private route: ActivatedRoute,  private authService: AuthService,
     private aviokompanijaService: AvionskaKompanijaService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      if(params['id'] != null){
        this.id = +params['id']; // (+) konvertuje string 'id' u broj
        //id postavljamo kao path parametar pomocu interpolacije stringa
      }
    });

    this.dropdownSettings = {
      singleSelection: true,
    };
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

  prikaziPrihod(){
    if(this.pocetniDatum !== undefined && this.krajnjiDatum !== undefined){
      let pocetni = this.konvertujUDobroVreme(this.pocetniDatum.toString().substring(4,15));
      let krajnji = this.konvertujUDobroVreme(this.krajnjiDatum.toString().substring(4,15));
      this.aviokompanijaService.prihodServisa(pocetni, krajnji, this.id).subscribe(
        s => 
        {
          this.prihod = s;
        }
      )
    }
    else{
      alert("Morate uneti pocetni i krajnji datum");
    }
  }

  izvestajPoslovanja(){
    if(this.pocetniDatum !== undefined && this.krajnjiDatum !== undefined){
      let pocetni = this.konvertujUDobroVreme(this.pocetniDatum.toString().substring(4,15));
      let krajnji = this.konvertujUDobroVreme(this.krajnjiDatum.toString().substring(4,15));
      this.labels = [];
      this.data = [];
      this.aviokompanijaService.posecenostServisa(this.id, pocetni, krajnji).subscribe(
        s => {
          this.posecenost = s;

          for(let pom of this.posecenost){
            if(this.labels.find(x => x === pom.split("=")[0]) === undefined){
              this.labels.push(pom.split("=")[0])
              this.data.push(pom.split("=")[1])
            }
          }
          this.chart = new Chart('canvas', {
            type: 'bar',
            data: {
                labels: this.labels,
                datasets: [{
                    label: 'Letovi',
                    data: this.data,
                    backgroundColor: [
                      'rgba(0, 0, 255, 0.3)',
                      'rgba(0, 0, 255, 0.3)',
                      'rgba(0, 0, 255, 0.3)',
                      'rgba(0, 0, 255, 0.3)',
                      'rgba(0, 0, 255, 0.3)',
                      'rgba(0, 0, 255, 0.3)',
                      'rgba(0, 0, 255, 0.3)',
                    ],
                    borderColor: [
                      'rgba(0, 0, 255, 0.6)',
                      'rgba(0, 0, 255, 0.6)',
                      'rgba(0, 0, 255, 0.6)',
                      'rgba(0, 0, 255, 0.6)',
                      'rgba(0, 0, 255, 0.6)',
                      'rgba(0, 0, 255, 0.6)',
                      'rgba(0, 0, 255, 0.6)',
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero:true
                        }
                    }]
                }
            }
          });
        }
      );
    }
    else{
      alert("Morate uneti pocetni i krajnji datum");
    }
  }
}
