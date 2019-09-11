import { Korisnik } from "./korisnik";

export class Prijateljstvo{
    id: number;
    vremeKreiranja: string;
    prijatelj1DTO: Korisnik;
    prijatelj2DTO: Korisnik;

    constructor(){
        this.id = undefined;
        this.vremeKreiranja = undefined;
        this.prijatelj1DTO = new Korisnik();
        this.prijatelj2DTO = new Korisnik();
    }
}