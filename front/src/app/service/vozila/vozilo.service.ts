import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Vozilo } from 'app/model/vozila/vozilo';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class VoziloService {

  constructor(private http: HttpClient) { }
  
  

  /*addToRent(id: number, idRent: number): Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/api/rentacarovi/${idRent}/dodajURentVozilo/${id}`);
  }*/

  findOne(kompanijaid: number,  garazaid: number, id: number): Observable<Vozilo> {
    return this.http.get<Vozilo>(`/kompanije-vozila/${kompanijaid}/garaze/${garazaid}/vozila/${id}`);
  }

  findAll(kompanijaid: number,  garazaid: number,): Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/kompanije-vozila/${kompanijaid}/garaze/${garazaid}/vozila/`);
  }

  /*findAllVozilaToAdd(): Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/api/rentacarovi/svaVozilaKojaSeMoguDodati`);
  }

  findVozilaForRent(id: number):Observable<Vozilo[]> {
    return this.http.get<Vozilo[]>(`/api/rentacarovi/${id}/prikazVozila`);
  }*/

  deleteVozilo(kompanijaid: number,  garazaid: number, id: number): Observable<{}> {
    return this.http.delete(`/kompanije-vozila/${kompanijaid}/garaze/${garazaid}/vozila/${id}`);
  }

  // deleteVoziloFromRent(id: number): Observable<{}> {
  //   return this.http.delete(`/api/vozila/${id}/deleteFromRent`);
  // }

  updateVozilo(kompanijaid: number,  garazaid: number, id: number, vozilo: Vozilo): Observable<Vozilo> {
    return this.http.put<Vozilo>(`/kompanije-vozila/${kompanijaid}/garaze/${garazaid}/vozila`, vozilo);
  }

  addVozilo(kompanijaid: number,  garazaid: number, vozilo: Vozilo): Observable<Vozilo> {
    return this.http.post<Vozilo>(`/kompanije-vozila/${kompanijaid}/garaze/${garazaid}/vozila`, vozilo);
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
