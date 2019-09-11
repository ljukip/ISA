import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Soba } from 'app/model/hotel/soba';
import { Observable } from 'rxjs/Observable';
import { PretragaSobe } from 'app/model/opsti/pretragaSobe';

@Injectable()
export class SobaService {

  constructor(private http: HttpClient) { }
  
  /*addToRent(id: number, idRent: number): Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/api/rentacarovi/${idRent}/dodajURentVozilo/${id}`);
  }*/

  findOne(hotel: number, id: number): Observable<Soba> {
    return this.http.get<Soba>(`/hoteli/${hotel}/sobe/${id}`);
  }

  findAll(hotel: number): Observable<Soba[]> {
    return this.http.get<Soba[]>(`/hoteli/${hotel}/sobe`);
  }

  /*findAllVozilaToAdd(): Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/api/rentacarovi/svaVozilaKojaSeMoguDodati`);
  }

  findVozilaForRent(id: number):Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/api/rentacarovi/${id}/prikazVozila`);
  }*/

  delete(hotel: number,  id: number): Observable<{}> {
    return this.http.delete(`/hoteli/${hotel}/sobe/${id}`);
  }

  // deleteVoziloFromRent(id: number): Observable<{}> {
  //   return this.http.delete(`/api/vozila/${id}/deleteFromRent`);
  // }

  update(hotel: number,  id: number, vozilo: Soba): Observable<Soba> {
    return this.http.put<Soba>(`/hoteli/${hotel}/sobe`, vozilo);
  }

  add(hotel: number, vozilo: Soba): Observable<Soba> {
    return this.http.post<Soba>(`/hoteli/${hotel}/sobe`, vozilo);
  }

  pretraga(hotel: number, pretraga: PretragaSobe): Observable<Soba[]> {
    return this.http.post<Soba[]>(`/hoteli/${hotel}/sobe/pretraga`, pretraga);
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
}