import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CenovnikSobe } from 'app/model/hotel/cenovnikSobe';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CenovnikService {

  constructor(private http: HttpClient) { }
  
  add(novaFilijala: CenovnikSobe, idKompanije: number, sobaId: number): Observable<CenovnikSobe> { 
    return this.http.post<CenovnikSobe>(`/hoteli/${idKompanije}/sobe/${sobaId}/cenovnici`, novaFilijala);
  }

  findOne(hotelId: number, sobaId: number, id: number): Observable<CenovnikSobe> {
    return this.http.get<CenovnikSobe>(`/hoteli/${hotelId}/sobe/${sobaId}/cenovnici/${id}`);
  }

  findAll(hotelId: number, sobaId: number): Observable<CenovnikSobe[]> {
    return this.http.get<CenovnikSobe[]>(`/hoteli/${hotelId}/sobe/${sobaId}/cenovnici`);
  }

  delete(hotelId: number, sobaId: number, id: number): Observable<{}> {
    return this.http.delete(`/hoteli/${hotelId}/sobe/${sobaId}/cenovnici/${id}`);
  }

  update(hotelId: number, sobaId: number, opcija: CenovnikSobe): Observable<CenovnikSobe> {
    return this.http.put<CenovnikSobe>(`/hoteli/${hotelId}/sobe/${sobaId}/cenovnici`, opcija);
  }
}
