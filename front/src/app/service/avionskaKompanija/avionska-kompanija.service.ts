import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AvionskaKompanija } from 'app/model/avionskakompanija/avionskaKompanija';
import { Adresa } from 'app/model/opsti/adresa';
import { PretragaKompanijeVozila } from 'app/model/opsti/pretragaKompanijaVozila';

@Injectable()
export class AvionskaKompanijaService {

  constructor(private http: HttpClient) { }
  
  add(noviRentACar: AvionskaKompanija): Observable<AvionskaKompanija> {
    return this.http.post<AvionskaKompanija>('/avionske-kompanije', noviRentACar);
  }

  findOne(id: number): Observable<AvionskaKompanija> {
    return this.http.get<AvionskaKompanija>(`/avionske-kompanije/${id}`);
  }

  findAll(): Observable<AvionskaKompanija[]> {
    return this.http.get<AvionskaKompanija[]>('/avionske-kompanije');
  }

  delete(id: number): Observable<{}> {
    return this.http.delete(`/avionske-kompanije/${id}`);
  }

  update(id: number, rentacar: AvionskaKompanija): Observable<AvionskaKompanija> {
    return this.http.put<AvionskaKompanija>(`/avionske-kompanije`, rentacar);
  }


  vratiSveNazive(): Observable<string[]> {
    return this.http.get<string[]>('/adrese'); //popraviti jos
  } 

  vratiSveAdrese(): Observable<Adresa[]> {
    return this.http.get<Adresa[]>('/adrese'); //popraviti jos
  }

  trazenje(naziv: string, adresa: string): Observable<AvionskaKompanija[]> { //dopraviti je
    let listaUslova: string[] = []
    listaUslova.push(naziv.toString());
    listaUslova.push(adresa.toString());
    return this.http.post<AvionskaKompanija[]>(`/avionske-kompanije/trazenje`, listaUslova);
  }

  findAllSort(paramSort: string, paramDir: string): Observable<AvionskaKompanija[]> {
    return this.http.get<AvionskaKompanija[]>(`/avionske-kompanije?sort=${paramSort},${paramDir}`);
  }

  /*vratiListuOcenjivihServisa(): Observable<number[]>{
    return this.http.get<number[]>(`api/rezervacijeVozila/listaOcenjivih`);
  }

  oceniServis(id: number, ocena: OcenaRenta): Observable<OcenaRenta> {
    return this.http.put<OcenaRenta>(`/api/ocene/${id}/postaviOcenuRent`, ocena);
  }
*/

prihodServisa(odDatuma: string, doDatuma: string, idRenta: number): Observable<number>{  
  let params = new HttpParams();
  params = params.append('pocetak', odDatuma);
  params = params.append('kraj', doDatuma);
  return this.http.get<number>(`/avionske-kompanije/${idRenta}/prihodi`, {params: params});
}

posecenostServisa(id: number, odDatuma: string, doDatuma:string): Observable<String[]>{
  let params = new HttpParams();
  params = params.append('pocetak', odDatuma);
  params = params.append('kraj', doDatuma);
  return this.http.get<String[]>(`/avionske-kompanije/${id}/statistika`, {params : params});
}

trazi(pretraga: PretragaKompanijeVozila): Observable<AvionskaKompanija[]> {
  return this.http.post<AvionskaKompanija[]>(`avionske-kompanije/pretraga`, pretraga);
}

}