import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Registracija } from './model/korisnici/registracija';
import { Korisnik } from './model/korisnici/korisnik';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient,
    private router: Router) { }

    /*getRoles(token: string) {
      let jwtData = token.split('.')[1];
      let decodedJwtJsonData = window.atob(jwtData);
      let decodedJwtData = JSON.parse(decodedJwtJsonData);
      console.log(decodedJwtData);
      console.log(decodedJwtData.auth[0].authority);
      console.log(decodedJwtData.sub); //username
      return decodedJwtData.auth[0].authority; //you can access role or username
    }
  
    getUsername(token: string) : string{
      let jwtData = token.split('.')[1];
      let decodedJwtJsonData = window.atob(jwtData);
      let decodedJwtData = JSON.parse(decodedJwtJsonData);
      console.log(decodedJwtData);
      console.log(decodedJwtData.auth[0].authority);
      console.log(decodedJwtData.sub); //username
      return decodedJwtData.sub; //you can access role or username
    }*/
  
    login(email:string, lozinka:string): Observable<Korisnik>{
      const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
      return this.http
        .post<Korisnik>('/api/login', {email, lozinka});
    }

    signup(korisnik: Registracija): Observable<Korisnik>{
      return this.http
        .post<Korisnik>('/api/signup', korisnik);
    }

    registerAdmin(korisnik: Korisnik): Observable<Korisnik>{
      return this.http.post<Korisnik>(`/korisnici/admini-kompanija?kompanija-id=1`, korisnik);
    }

    logout(): void {
      localStorage.removeItem('token');
      this.router.navigate(['login']);
    }

    promeniLozinku(korisnik: Korisnik): Observable<Korisnik>{
      return this.http.put<Korisnik>('/korisnici/admini-kompanija', korisnik);
    }

}
