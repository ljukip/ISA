import { Component } from '@angular/core';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  public disableNavBar: boolean = true;
  //public logovaniKorisnik: Korisnik;
  public prijavljen: boolean = false;
  public tipkorisnika: string;


  constructor(private authService: AuthService, private router: Router) { 
    let res = localStorage.getItem('token');
    if(res != null){
      this.prijavljen = true;
     // let uloga = this.authService.getRoles(res);
      //let email = this.authService.getUsername(res);
      //this.tipkorisnika = this.authService.getRoles(res);

      /*this.korisnikService.findByEmail(email).subscribe(
        s => {
          this.logovaniKorisnik = s;

          if ( (uloga === 'ROLE_Administrator_aviokompanije' || 
          uloga === 'ROLE_Administrator_hotela' ||
          uloga === 'ROLE_Administrator_rent_a_car_servisa' ) && !this.logovaniKorisnik.aktiviranNalog){
            this.disableNavBar = false;
          }
          else{
            this.disableNavBar = true;
          }
          
        },
        err => console.log("err")
      );*/
    }
  }

  ngOnInit() {

  }

  goToProfile(){
    if(this.tipkorisnika === "ROLE_Registrovani_korisnik"){
      //this.router.navigate(['korisnik/' + this.logovaniKorisnik.id]);
    }
  }

  podesiPopuste(){
    if(this.tipkorisnika === "ROLE_Administrator_sistema"){
      this.router.navigate(['admin/popusti']);
    }
  }

  odjaviSe(){
    this.authService.logout();
    this.prijavljen = false;
    this.router.navigate(['login']);

  }

  dodavanje(){
    // if(this.tipkorisnika === "ROLE_Administrator_sistema"){
    //   return true;
    // }
    // return false; 
    return true;
  }

  profilKorisnika(){
    if(this.tipkorisnika === "ROLE_Registrovani_korisnik"){
      return true;
    }
    return false; 
  }

  profilAdmina(){
    if(this.tipkorisnika === "ROLE_Administrator_aviokompanije"){
      return true;
    }

    if(this.tipkorisnika === "ROLE_Administrator_hotela"){
      return true;
    }

    if(this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa"){
      return true;
    }

    if(this.tipkorisnika === "ROLE_Administrator_sistema"){
      return true;
    }

    return false; 
  }

  vidljivoPopusti(){
    if(this.tipkorisnika === "ROLE_Administrator_sistema"){
      return true;
    }

    return false;
  }

  goToProfileAdmin(){
    if(this.tipkorisnika === "ROLE_Administrator_aviokompanije" || this.tipkorisnika === "ROLE_Administrator_hotela" ||
    this.tipkorisnika === "ROLE_Administrator_rent_a_car_servisa" || this.tipkorisnika === "ROLE_Administrator_sistema"){
      //this.router.navigate(['admin/' + this.logovaniKorisnik.id]);
    }
  }

}
