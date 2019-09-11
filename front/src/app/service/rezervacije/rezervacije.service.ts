import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Vozilo } from 'app/model/vozila/vozilo';
import { ZakupVozila } from 'app/model/vozila/zakupVozila';
import { Rezervacija } from 'app/model/opsti/rezervacija';
import { ZakupSoba } from 'app/model/hotel/zakupSoba';
import { AvionskaKarta } from 'app/model/avionskakompanija/avionskaKarta';

@Injectable()
export class RezervacijeService {

  constructor(private http: HttpClient) { }

  zakupVozila(id: number, zakupVozila: ZakupVozila): Observable<Rezervacija> {
    return this.http.post<Rezervacija>(`/rezervacije/${id}/zakup-vozila`, zakupVozila);
  }

  zakupSobe(id: number, zakupSobe: ZakupSoba): Observable<Rezervacija> {
    return this.http.post<Rezervacija>(`/rezervacije/${id}/zakup-sobe`, zakupSobe);
  }

  rezervisiSedista(idKompanija: number, idLet: number, korisnik: number, avionskaKarta: AvionskaKarta): Observable<Rezervacija> {
    return this.http.post<Rezervacija>(` /avionske-kompanije/${idKompanija}/letovi/${idLet}/karte?korisnik=${korisnik}`, avionskaKarta);
  }

  vratiBrzeRezervacijeSobe(hotelId: number): Observable<ZakupSoba[]>{
    return this.http.get<ZakupSoba[]>(`/hoteli/${hotelId}/brze`);
  }

  vratiBrzeRezervacijeVozila(voziloId: number): Observable<ZakupVozila[]>{
    return this.http.get<ZakupVozila[]>(`/kompanije-vozila/${voziloId}/brze`);
  }

  zavrsiRezervaciju(id: number){
    return this.http.put<Rezervacija[]>(`/rezervacije/${id}/potvrdi`, {});
  }

  istorijaZakupaVozila(voziloId: number): Observable<ZakupVozila[]>{
    return this.http.get<ZakupVozila[]>(`/korisnici/obicni/${voziloId}/vozila`);
  }

  istorijaZakupaSoba(voziloId: number): Observable<ZakupSoba[]>{
    return this.http.get<ZakupSoba[]>(`/korisnici/obicni/${voziloId}/sobe`);
  }

  istorijaZakupaKarata(voziloId: number): Observable<AvionskaKarta[]>{
    return this.http.get<AvionskaKarta[]>(`/korisnici/obicni/${voziloId}/karte`);
  }

  korisnikoveRezervacije(voziloId: number): Observable<Rezervacija[]>{
    return this.http.get<Rezervacija[]>(`/korisnici/obicni/${voziloId}/rezervacije`);
  }

  oceniAvionskuKartu(kartaId: number, ocena: number): Observable<AvionskaKarta>{
    return this.http.put<AvionskaKarta>(`/avionske-kompanije/1/letovi/3/karte/${kartaId}?ocena=${ocena}`, {});
  }

  oceniSobu(kartaId: number, ocena: number): Observable<ZakupSoba>{
    return this.http.put<ZakupSoba>(`/hoteli/3/sobe/2/zakupi/${kartaId}?ocena=${ocena}`, {});
  }

  oceniVozilo(kartaId: number, ocena: number): Observable<AvionskaKarta>{
    return this.http.put<AvionskaKarta>(`/kompanije-vozila/1/garaze/3/vozila/2/zakupi/${kartaId}?ocena=${ocena}`, {});
  }

  //rezervacije/{id}/brz-zakup-vozila/{zakup-id}
  brzoRezervisiVozilo(idRezervacije: number, idBrze: number): Observable<Rezervacija>{
    return this.http.put<Rezervacija>(`/rezervacije/${idRezervacije}/brz-zakup-vozila/${idBrze}`, {});
  }

  brzoRezervisiSobu(idRezervacije: number, idBrze: number): Observable<Rezervacija>{
    return this.http.put<Rezervacija>(`/rezervacije/${idRezervacije}/brz-zakup-sobe/${idBrze}`, {});
  }


  
}
