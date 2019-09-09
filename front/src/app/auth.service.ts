import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
//import { KorisnikRegistracija } from './model/korisnik/korisnikRegistracija';

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
    }
  
    login(email:string, lozinka:string): Observable<string>{
      const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
      return this.http
        .post<string>('/api/login', {email, lozinka});
    }*/

    /*signup(korisnik: KorisnikRegistracija): Observable<string>{
      return this.http
        .post<string>('/api/signup', korisnik);
    }

    registerAdmin(id: number,korisnik: KorisnikRegistracija): Observable<string>{
      return this.http
        .post<string>(`/api/register/${id}`, korisnik);
    }*/

    logout(): void {
      localStorage.removeItem('token');
      this.router.navigate(['login']);
    }

}
