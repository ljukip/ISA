import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Let } from 'app/model/avionskakompanija/let';
import { Observable } from 'rxjs/Observable';
import { Destinacija } from 'app/model/opsti/destinacija';
import { PretragaLeta } from 'app/model/opsti/pretragaLeta';

@Injectable()
export class LetService {

  constructor(private http: HttpClient) { }
  
  /*addToRent(id: number, idRent: number): Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/api/rentacarovi/${idRent}/dodajURentVozilo/${id}`);
  }*/

  findOne(kompanijaId: number, id: number): Observable<Let> {
    return this.http.get<Let>(`/avionske-kompanije/${kompanijaId}/letovi/${id}`);
  }

  findAll(kompanijaId: number): Observable<Let[]> {
    return this.http.get<Let[]>(`/avionske-kompanije/${kompanijaId}/letovi`);
  }

  vratiPoletanja(id: number): Observable<Let[]> {
    return this.http.get<Let[]>(`/destinacije/${id}/poletanja`);
  }

  vratiSletanja(id: number): Observable<Let> {
    return this.http.get<Let>(`/destinacije/${id}/sletanja`);
  }

  destinacije(): Observable<Destinacija[]> {
    return this.http.get<Destinacija[]>(`/destinacije`);
  }

  /*findAllVozilaToAdd(): Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/api/rentacarovi/svaVozilaKojaSeMoguDodati`);
  }

  findVozilaForRent(id: number):Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/api/rentacarovi/${id}/prikazVozila`);
  }*/

  delete(kompanijaId: number,  id: number): Observable<{}> {
    return this.http.delete(`/avionske-kompanije/${kompanijaId}/letovi/${id}`);
  }

  // deleteVoziloFromRent(id: number): Observable<{}> {
  //   return this.http.delete(`/api/vozila/${id}/deleteFromRent`);
  // }

  update(kompanijaId: number,  id: number, vozilo: Let): Observable<Let> {
    return this.http.put<Let>(`/avionske-kompanije/${kompanijaId}/letovi`, vozilo);
  }

  add(kompanijaId: number, vozilo: Let): Observable<Let> {
    return this.http.post<Let>(`/avionske-kompanije/${kompanijaId}/letovi`, vozilo);
  }

 /* traziVozilo(rezervacijaVozila: RezervacijaVozila, idRent: number): Observable<Vozilo[]> {
    return this.http.post<Vozilo[]>(`/api/vozila/rezervacijeVozila/${idRent}`, rezervacijaVozila);
  }

  rezervisiVozilo(rezervacijaVozila: RezervacijaVozila, idRezervacije: number): Observable<RezervacijaVozila> {
    return this.http.post<RezervacijaVozila>(`/api/vozila/rezervacijeVozila/klikRezervisano/${idRezervacije}`, rezervacijaVozila);
  }

  vratiSveTipove(): Observable<string[]> {
    return this.http.get<string[]>('/api/vozila/tipoviVozila');
  }

  findHistoryOfRentedCars(): Observable<RezervacijaVozila[]> {
    return this.http.get<RezervacijaVozila[]>('api/rezervacijeVozila/istorijaRezervisanihVozila');
  }

  oceniRezervisanoVozilo(id: number, ocena: number){
    return this.http.get<RezervacijaVozila>(`api/rezervacijeVozila/${id}/postaviOcenu/${ocena}`);
  }

  minimalnaCenaVozila(){
    return this.http.get<number>(`api/vozila/minimalnaCena`);
  }

  maksimalnaCenaVozila(){
    return this.http.get<number>(`api/vozila/maksimalnaCena`);
  }

  findRezervacijuVozilo(id: number) : Observable<RezervacijaVozila>{
    return this.http.get<RezervacijaVozila>(`/api/rezervacijeVozila/${id}`);
  }*/

  pretraga(kompanijaId: number, pretraga: PretragaLeta): Observable<Let[]> {
    return this.http.post<Let[]>(`/avionske-kompanije/${kompanijaId}/letovi/pretraga`, pretraga);
  }
}