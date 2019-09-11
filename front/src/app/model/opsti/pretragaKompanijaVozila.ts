import { Destinacija } from "./destinacija";

export class PretragaKompanijeVozila{
    naziv: string;
	destinacija: Destinacija;
	pocetak: string;
    kraj: string;
    
    constructor(){
        this.naziv = "";
        this.destinacija = new Destinacija();
        this.pocetak  = "1900-01-01";
        this.kraj = "1900-01-02";
    }
}