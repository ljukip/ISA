import { Component, OnInit } from '@angular/core';
import { Registracija } from 'app/model/korisnici/registracija';
import { AuthService } from 'app/auth.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Korisnik } from 'app/model/korisnici/korisnik';

@Component({
  selector: 'app-registracija-admina',
  templateUrl: './registracija-admina.component.html',
  styleUrls: ['./registracija-admina.component.css']
})
export class RegistracijaAdminaComponent implements OnInit {

  korisnik: Korisnik;
  tip: string;
  maksimalnaDuzina: number = 30;
  mailNijeJedinstven: boolean = true;
  private sub: any;

  constructor(private auth: AuthService, private router: Router, private route: ActivatedRoute) {
    this.korisnik = new Korisnik();
    
    this.sub = this.route.params.subscribe(params => {
      if(params['tip'] != null){
        this.tip = params['tip'];
        console.log(this.tip);
      }
    });
  }

  ngOnInit() {
  }


  register(){
    let message: string = "OK"; //this.proveriUnosKorisnik();
    if(message === "OK")
    {

      this.korisnik.tipKorisnika = "ADMIN_KOMPANIJE";

      if(this.tip == "vozilo"){
        this.korisnik.tipAdmina = "ADMIN_KOMPANIJE_VOZILA"
      }
      else if(this.tip == "hotel"){
        this.korisnik.tipAdmina = "ADMIN_HOTELA"
      }
      else{
        this.korisnik.tipAdmina = "ADMIN_AVIONSKE_KOMPANIJE"
      }

      this.auth.registerAdmin(this.korisnik)
          .subscribe(
            res => 
            {
              //this.router.navigate(['login'])
              console.log(this.tip);
              //u zavisnosti odakle je dosao tako popuniti tip
              alert('USPESNO REGISTROVAN');
            },
            err => {
              console.log("usao kao error");
              if (err.status === 400) { // bad request losi kredencijali
                console.log("usao 400");
                this.mailNijeJedinstven = false;
            }
          }
        )
    }
    else{
      alert(message);
    }
  }

  validateEmail(email: string) 
  {
    let re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
  }
  


}
