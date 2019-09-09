import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Hotel } from 'app/model/hotel/hotel';
import { Observable } from 'rxjs/Observable';
import { Adresa } from 'app/model/opsti/adresa';


@Injectable()
export class HotelService {

  constructor(private http: HttpClient) { }
  
  add(noviRentACar: Hotel): Observable<Hotel> {
    return this.http.post<Hotel>('/hoteli', noviRentACar);
  }

  findOne(id: number): Observable<Hotel> {
    return this.http.get<Hotel>(`/hoteli/${id}`);
  }

  findAll(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>('/hoteli');
  }

  delete(id: number): Observable<{}> {
    return this.http.delete(`/hoteli/${id}`);
  }

  update(id: number, rentacar: Hotel): Observable<Hotel> {
    return this.http.put<Hotel>(`/hoteli`, rentacar);
  }


  vratiSveNazive(): Observable<string[]> {
    return this.http.get<string[]>('/adrese'); //popraviti jos
  } 

  vratiSveAdrese(): Observable<Adresa[]> {
    return this.http.get<Adresa[]>('/adrese'); //popraviti jos
  }

  trazenje(naziv: string, adresa: string): Observable<Hotel[]> { //dopraviti je
    let listaUslova: string[] = []
    listaUslova.push(naziv.toString());
    listaUslova.push(adresa.toString());
    return this.http.post<Hotel[]>(`/hoteli/trazenje`, listaUslova);
  }

  findAllSort(paramSort: string, paramDir: string): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(`/hoteli?sort=${paramSort},${paramDir}`);
  }

  /*vratiListuOcenjivihServisa(): Observable<number[]>{
    return this.http.get<number[]>(`api/rezervacijeVozila/listaOcenjivih`);
  }

  oceniServis(id: number, ocena: OcenaRenta): Observable<OcenaRenta> {
    return this.http.put<OcenaRenta>(`/api/ocene/${id}/postaviOcenuRent`, ocena);
  }

  prihodServisa(odDatuma: string, doDatuma: string, idRenta: number): Observable<number>{  
    let params = new HttpParams();
    params = params.append('odDatuma', odDatuma);
    params = params.append('doDatuma', doDatuma);
    params = params.append('idRenta', idRenta.toString());
    return this.http.get<number>(`api/rezervacijeVozila/prihodiServisa`, {params: params});
  }

  posecenostServisa(id: number, odDatuma: string, doDatuma:string): Observable<String[]>{
    let params = new HttpParams();
    params = params.append('odDatuma', odDatuma);
    params = params.append('doDatuma', doDatuma);
    return this.http.get<String[]>(`/api/rezervacijeVozila/${id}/dnevnaPosecenost`, {params : params});
  }*/

}