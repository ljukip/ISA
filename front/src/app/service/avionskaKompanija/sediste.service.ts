import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SedisteNaLetu } from 'app/model/avionskakompanija/sedisteNaLetu';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SedisteService {

  constructor(private http: HttpClient) { }

  vratiSedistaLeta(kompanijaId: number, letId: number): Observable<SedisteNaLetu[][]> {
    return this.http.get<SedisteNaLetu[][]>(`/avionske-kompanije/${kompanijaId}/letovi/${letId}/sedista`);
  }

  dodajSediste(kompanijaId: number, letId: number): Observable<SedisteNaLetu[][]> {
    return this.http.post<SedisteNaLetu[][]>(`/avionske-kompanije/${kompanijaId}/letovi/${letId}/sedista`, {});
  }

  obrisiSediste(kompanijaId: number, letId: number, sedisteId: number): Observable<SedisteNaLetu[][]> {
    return this.http.delete<SedisteNaLetu[][]>(`/avionske-kompanije/${kompanijaId}/letovi/${letId}/sedista/${sedisteId}`);
  }

  azurirajSediste(idSediste: number, sediste: SedisteNaLetu): Observable<SedisteNaLetu[][]> {
    return this.http.put<SedisteNaLetu[][]>(`/avionske-kompanije/0/letovi/0/sedista/${idSediste}`, sediste);
  }

}
