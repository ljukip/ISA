import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Garaza } from 'app/model/vozila/garaza';

@Injectable()
export class GarazaService {

  constructor(private http: HttpClient) { }
  
  addFilijala(novaFilijala: Garaza, idKompanije: number): Observable<Garaza> {
    return this.http.post<Garaza>(`/kompanije-vozila/${idKompanije}/garaze`, novaFilijala);
  }

  /*addToRent(id: number, idRent: number): Observable<Garaza[]> {
    return this.http.get<Garaza[]>(`/api/rentacarovi/${idRent}/dodajURentFilijalu/${id}`);
  }*/

  findOne(kompanijaId: number, id: number): Observable<Garaza> {
    return this.http.get<Garaza>(`/kompanije-vozila/${kompanijaId}/garaze/${id}`);
  }

  findAll(kompanijaId: number): Observable<Garaza[]> {
    return this.http.get<Garaza[]>('/kompanije-vozila/' + kompanijaId + '/garaze');
  }

  delete(kompanijaId: number, id: number): Observable<{}> {
    return this.http.delete(`/kompanije-vozila/${kompanijaId}/garaze/${id}`);
  }

  update(kompanijaId: number, filijala: Garaza): Observable<Garaza> {
    return this.http.put<Garaza>(`/kompanije-vozila/${kompanijaId}/garaze`, filijala);
  }
}