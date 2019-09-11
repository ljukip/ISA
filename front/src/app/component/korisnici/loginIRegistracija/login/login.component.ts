import { Component, OnInit } from '@angular/core';
import { KorisnikPrijava } from 'app/model/korisnici/korisnikPrijava';
import { AuthService } from 'app/auth.service';
import { Router } from '@angular/router';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { KorisnikService } from 'app/service/korisnici/korisnik.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  korisnik: KorisnikPrijava;
  public logovaniKorisnik: Korisnik;
  public nijeAktiviranMail: boolean = false;
  public losiKredencijali:  boolean = false;

  constructor(private auth: AuthService, private router: Router, private korisnikService: KorisnikService) { 
    this.korisnik = new KorisnikPrijava();
  }

  ngOnInit() {
  }

  login(){
    let message: string = this.proveriUnosKorisnik();
    if(message === "OK")
    {
      localStorage.removeItem('token');
      this.auth.login(this.korisnik.email, this.korisnik.lozinka)
          .subscribe(
            res => 
            {
              console.log(res);
              this.logovaniKorisnik = res;

               if(this.logovaniKorisnik.aktiviran == true){
                localStorage.setItem('token', JSON.stringify(this.logovaniKorisnik));
                this.router.navigate(['avionske-kompanije']);
              }
              else if(this.logovaniKorisnik.tipKorisnika = "ADMIN_KOMPANIJE"){
                localStorage.setItem('token', JSON.stringify(this.logovaniKorisnik));
                this.router.navigate(['promeniLozinku']);
              }
              else{
                alert('nije aktiviran mail');
              }

            
              //let uloga = this.auth.getRoles(res);

              // this.korisnikService.findByEmail(this.korisnik.email).subscribe(
              //   s => {
              //     this.logovaniKorisnik = s;

              //    /* if ( (uloga === 'ROLE_Administrator_aviokompanije' || 
              //     uloga === 'ROLE_Administrator_hotela' ||
              //     uloga === 'ROLE_Administrator_rent_a_car_servisa' ) && !this.logovaniKorisnik.aktiviranNalog){
              //       this.router.navigate(['korisnik/' + this.logovaniKorisnik.id + '/promenaLozinke/0']);
              //     }
              //     else{
              //       this.router.navigate(['home/0']);
              //     }*/
                  
              //   },
              //   err => console.log("err")
              // );

            },
            err => {
              console.log("usao kao error");
              if (err.status === 400) { // bad request losi kredencijali
                console.log("usao 400");
                this.losiKredencijali = true;
              } else if( err.status === 404){  // not found nije aktiviran nalog
                console.log("usao 404");
                this.nijeAktiviranMail = true;
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

  proveriUnosKorisnik(): string{
    if(this.korisnik.email === "" || this.korisnik.email.length > 60){
      return "Morate popuniti validnu e-mail adresu koja mora biti kraca od " + 60 + " karaktera";
    }
  
    if(!this.validateEmail(this.korisnik.email)){
      return "Morate uneti validnu e-mail adresu";
    }
    
    if(this.korisnik.lozinka === "" || this.korisnik.lozinka.length > 30){
      return "Morate popuniti validnu e-mail adresu koja mora biti kraca od " + 30 + " karaktera";
    }

    return "OK";
  }

}
