import { Component, OnInit } from '@angular/core';
import { AuthService } from 'app/auth.service';
import { Router } from '@angular/router';
import { Korisnik } from 'app/model/korisnici/korisnik';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  public disableNavBar: boolean = true;
  //public logovaniKorisnik: Korisnik;
  public prijavljen: boolean = false;
  public tipkorisnika: string;
  public korisnik: Korisnik;


  constructor(private authService: AuthService, private router: Router) { 
    this.korisnik = JSON.parse(localStorage.getItem('token'));
    if(this.korisnik != null){
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
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_SISTEMA"){
      this.router.navigate(['admin/popusti']);
    }
  }

  odjaviSe(){
    this.authService.logout();
    this.prijavljen = false;
    this.router.navigate(['login']);

  }

  dodavanje(){
    if (this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_SISTEMA"){
      return true;
    }
    return false;
  }

  profilKorisnika(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "KORISNIK"){
      return true;
    }
    return false; 
  }

  profilAdmina(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE"){
      return true;
    }


    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_SISTEMA"){
      return true;
    }

    return false; 
  }

  vidljivoPopusti(){
    if(this.korisnik != null && this.korisnik.tipKorisnika === "ADMIN_SISTEMA"){
      return true;
    }

    return false;
  }

  goToProfileAdmin(){
    if(this.korisnik != null && (this.korisnik.tipKorisnika === "ADMIN_SISTEMA" || this.korisnik.tipKorisnika === "ADMIN_KOMPANIJE")){
      //this.router.navigate(['admin/' + this.logovaniKorisnik.id]);
    }
  }

}
