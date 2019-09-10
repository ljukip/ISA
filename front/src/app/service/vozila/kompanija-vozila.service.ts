import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { KompanijaVozila } from 'app/model/vozila/kompanijaVozila';
import { Adresa } from 'app/model/opsti/adresa';

@Injectable()
export class KompanijaVozilaService {

  constructor(private http: HttpClient) { }
  
  addRentACar(noviRentACar: KompanijaVozila): Observable<KompanijaVozila> {
    return this.http.post<KompanijaVozila>('/kompanije-vozila', noviRentACar);
  }

  findOne(id: number): Observable<KompanijaVozila> {
    return this.http.get<KompanijaVozila>(`/kompanije-vozila/${id}`);
  }

  findAll(): Observable<KompanijaVozila[]> {
    return this.http.get<KompanijaVozila[]>('/kompanije-vozila');
  }

  deleteRentACar(id: number): Observable<{}> {
    return this.http.delete(`/kompanije-vozila/${id}`);
  }

  updateRentACar(id: number, rentacar: KompanijaVozila): Observable<KompanijaVozila> {
    return this.http.put<KompanijaVozila>(`/kompanije-vozila`, rentacar);
  }


  vratiSveNazive(): Observable<string[]> {
    return this.http.get<string[]>('/adrese'); //popraviti jos
  } 

  vratiSveAdrese(): Observable<Adresa[]> {
    return this.http.get<Adresa[]>('/adrese'); //popraviti jos
  }

  trazenjeRentacarova(naziv: string, adresa: string): Observable<KompanijaVozila[]> { //dopraviti je
    let listaUslova: string[] = []
    listaUslova.push(naziv.toString());
    listaUslova.push(adresa.toString());
    return this.http.post<KompanijaVozila[]>(`/kompanije-vozila/trazenjeRentacarovi`, listaUslova);
  }

  findAllSort(paramSort: string, paramDir: string): Observable<KompanijaVozila[]> {
    return this.http.get<KompanijaVozila[]>(`/kompanije-vozila?sort=${paramSort},${paramDir}`);
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
