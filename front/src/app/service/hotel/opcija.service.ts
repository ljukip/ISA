import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Opcija } from 'app/model/hotel/opcija';

@Injectable()
export class OpcijaService {

  constructor(private http: HttpClient) { }
  
  add(novaFilijala: Opcija, idKompanije: number): Observable<Opcija> {
    return this.http.post<Opcija>(`/hoteli/${idKompanije}/opcije`, novaFilijala);
  }

  findOne(kompanijaId: number, id: number): Observable<Opcija> {
    return this.http.get<Opcija>(`/hoteli/${kompanijaId}/opcije/${id}`);
  }

  findAll(kompanijaId: number): Observable<Opcija[]> {
    return this.http.get<Opcija[]>('/hoteli/' + kompanijaId + '/opcije');
  }

  delete(kompanijaId: number, id: number): Observable<{}> {
    return this.http.delete(`/hoteli/${kompanijaId}/opcije/${id}`);
  }

  update(hotelId: number, opcija: Opcija): Observable<Opcija> {
    return this.http.put<Opcija>(`/hoteli/${hotelId}/opcije`, opcija);
  }
}