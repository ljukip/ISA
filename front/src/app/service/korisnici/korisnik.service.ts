import { Injectable } from '@angular/core';
import { Korisnik } from 'app/model/korisnici/korisnik';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { ZahtevZaPrijateljstvo } from 'app/model/korisnici/zahtevZaPrijateljstvo';
import { Prijateljstvo } from 'app/model/korisnici/prijateljstvo';

@Injectable()
export class KorisnikService {

  constructor(private http: HttpClient) { }

  addKorisnik(novKorisnik: Korisnik): Observable<Korisnik> {
    return this.http.post<Korisnik>(`/korisnici/obicni`, novKorisnik);
  }

  findOne(id: number): Observable<Korisnik> {
    return this.http.get<Korisnik>(`/korisnici/obicni/${id}`);
  }

  findAll(): Observable<Korisnik[]> {
    return this.http.get<Korisnik[]>(`/korisnici/obicni`);
  }

  deleteKorisnik(id: number): Observable<{}> {
    return this.http.delete(`/korisnici/obicni/${id}`);
  }

  updateKorisnik(id: number, korisnik: Korisnik): Observable<Korisnik> {
    return this.http.put<Korisnik>(`/korisnici/obicni/${id}`, korisnik);
  }


  findByEmail(email: string): Observable<Korisnik> {
    return this.http.get<Korisnik>(`/korisnik/${email}/pronadjiPoMailu`);
  }

  findAllSort(paramSort: string, paramDir: string): Observable<Korisnik[]> {
    return this.http.get<Korisnik[]>(`api/korisnik/sort/${paramSort}/direkcija/${paramDir}`);
  }

  findAllFriends(idKorisnika: number): Observable<Korisnik[]> {
    return this.http.get<Korisnik[]>(`/korisnici/obicni/${idKorisnika}/prijatelji`);
  }

  findNotFriends(idKorisnika: number): Observable<Korisnik[]> {
    return this.http.get<Korisnik[]>(`/korisnici/obicni/${idKorisnika}/nepoznati`);
  }

   deletePrijatelj(idKorisnik: number, idPrijatelj: number): Observable<{}> {
    return this.http.delete(`/korisnici/obicni/${idKorisnik}/prijatelji/?prijatelj-id=${idPrijatelj}`);
  }

  sendRequest(idKorisnik: number, idPrijatelj: number): Observable<ZahtevZaPrijateljstvo> {
    return this.http.post<ZahtevZaPrijateljstvo>(`/korisnici/obicni/${idKorisnik}/zahtevi?prijatelj-id=${idPrijatelj}`, {});
  }

  acceptRequest(idKorisnik: number, idPrijatelj: number): Observable<Prijateljstvo> {
    return this.http.put<Prijateljstvo>(`/korisnici/obicni/${idKorisnik}/zahtevi?prijatelj-id=${idPrijatelj}`, {});
  }

  deleteRequest(idKorisnik: number, idPrijatelj: number): Observable<{}> {
    return this.http.delete<{}>(`/korisnici/obicni/${idKorisnik}/zahtevi?prijatelj-id=${idPrijatelj}`, {});
  }

  receivedRequests(idKorisnik: number): Observable<ZahtevZaPrijateljstvo[]> {
    return this.http.get<ZahtevZaPrijateljstvo[]>(`/korisnici/obicni/${idKorisnik}/zahtevi/primljeni`);
  }

  /*activateKorisnik(id: number): Observable<{}> {
    return this.http.put(`/api/korisnik/${id}/aktivirajNalog`, {"id": id});
  }

  changePassword(id: number, promenaLozinke: PromenaLozinke): Observable<{}>{
    return this.http.put(`api/korisnik/${id}/promeniLozinku`, promenaLozinke);
  }*/

  // findHistoryOfReservations(): Observable<number[]> {
  //   return this.http.get<number[]>('api/korisnik/rezervacije/istorijaRezervacija');
  // }

  // saljiMailZaPrihvatanjeRezervacije(email: string, idLeta: number, sediste: number, idRezervacije: number): Observable<{}>{
  //   return this.http.get<{}>(`api/slanjeMailaZaPotvrduRezervacije/${email}/idleta/${idLeta}/brsedista/${sediste}/rezervacija/${idRezervacije}`);
  // }

  // dodajPrijateljeURezervaciju(email: string, idRezervacije: number, sediste: number): Observable<{}>{
  //   return this.http.get<{}>(`api/dodajClanoveRezervacije/${email}/idRezervacije/${idRezervacije}/brsedista/${sediste}`);
  // }

  // dodajNeregistrovanePrijateljeURezervaciju(email: string, idRezervacije: number, sediste: number, pasos: string, ime: string, prezime: string): Observable<{}>{
  //   return this.http.get<{}>(`api/dodajNeregistrovaneClanoveRezervacije/${email}/idRezervacije/${idRezervacije}/brsedista/${sediste}/pasos/${pasos}/ime/${ime}/prezime/${prezime}`);
  // }

  // prihvatiRezervaciju(idKorisnika: number, idLeta: number, brSedista: number, pasos: string, idRezervacije: number): Observable<{}>{
  //   return this.http.get<{}>(`api/prihvatiRezervaciju/${idKorisnika}/idLeta/${idLeta}/brSedista/${brSedista}/pasos/${pasos}/rezervacija/${idRezervacije}`);
  // }
  
  // odbijVelikuRezervaciju(idKorisnika: number, idLeta: number, brSedista: number, idRezervacije: number): Observable<{}>{
  //   return this.http.get<{}>(`api/odbijRezervaciju/${idKorisnika}/idLeta/${idLeta}/brSedista/${brSedista}/rezervacija/${idRezervacije}`);
  // }

  // kreirajVelikuRezervacijuINjenogKorisnika(email: string, idLeta: number, sediste: number, pasos: string): Observable<number>{
  //   return this.http.get<number>(`api/kreirajVelikuRezervaciju/${email}/idleta/${idLeta}/brsedista/${sediste}/pasos/${pasos}`);
  // }

  // findAllSort(paramSort: string, paramDir: string): Observable<Korisnik[]> {
  //   return this.http.get<Korisnik[]>(`api/korisnik/sort/${paramSort}/direkcija/${paramDir}`);
  // }

  // findAllVrsteKorisnika(): Observable<VrstaRegistrovanogKorisnika[]> {
  //   return this.http.get<VrstaRegistrovanogKorisnika[]>(`/api/vrsteKorisnika`);
  // }

  // sacuvajPopuste(vrsteKorisnika : VrstaRegistrovanogKorisnika[]): Observable<VrstaRegistrovanogKorisnika[]> {
  //   return this.http.post<VrstaRegistrovanogKorisnika[]>('/api/sacuvajVrste', vrsteKorisnika);
  // }

  

  // dajMiMojePozivnice(): Observable<Pozivnica[]> {
  //   return this.http.get<Pozivnica[]>(`api/korisnik/dajMiPozivnice`);
  // }

  // posaljiMailNakonZavrsetkaKreiranjaRezervacije(idRezervacije: number): Observable<{}>{
  //   return this.http.get<{}>(`api/slanjeMailaInfoKrajRez/${idRezervacije}`);
  // }

  // pozivnicuPrebaciUStanje(id: number, stanje: string, pasos: string): Observable<{}>{
  //   return this.http.get<{}>(`api/prebaciUStanje/pozivnicu/${id}/stanje/${stanje}/pasos/${pasos}`);
  // }

  // nadjiRezervaciju(id: number): Observable<Rezervacija>{
  //   return this.http.get<Rezervacija>(`api/velikeRezervacije/${id}`);
  // }

  // nadjiRezervacijeKorisnika(): Observable<Rezervacija[]>{
  //   return this.http.get<Rezervacija[]>(`api/velikeRezervacije/odKorisnika`);
  // }

  // otkaziLet(idRezervacije: number): Observable<{}>{
  //   return this.http.get<{}>(`api/otkaziLet/${idRezervacije}`);
  // }

  // otkaziSobu(idRezervacije: number): Observable<{}>{
  //   return this.http.get<{}>(`api/otkaziSobu/${idRezervacije}`);
  // }

  // otkaziVozilo(idRezervacije: number): Observable<{}>{
  //   return this.http.get<{}>(`api/otkaziVozilo/${idRezervacije}`);
  // }
}
