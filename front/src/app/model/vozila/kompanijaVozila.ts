import { Adresa } from "../opsti/adresa";
import { Vozilo } from "./vozilo";

export class KompanijaVozila{

    public id: number;
    public naziv: string;
    public opis: string;
    public adresa: Adresa;
    public vozila: Vozilo[];
    public longitude: number;
    public latitude: number;
    public prosecnaOcena: number;

    constructor(){
        this.id = 0;
        this.naziv = "";
        this.opis = "";
        this.adresa = new Adresa();
        this.vozila = [];
        this.longitude = 0;
        this.latitude = 0;
        this.prosecnaOcena = 0;
    }
}

