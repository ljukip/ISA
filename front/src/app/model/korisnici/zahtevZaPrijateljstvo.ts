import { Korisnik } from "./korisnik";

export class ZahtevZaPrijateljstvo{
    id: number;
    vremeSlanja: string;
    poslao: Korisnik;
    primio: Korisnik;

    constructor(){
        this.id = undefined;
        this.vremeSlanja = undefined;
        this.poslao = new Korisnik();
        this.primio = new Korisnik();
    }
}