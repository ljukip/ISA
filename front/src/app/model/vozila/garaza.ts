import { KompanijaVozila } from "./kompanijaVozila";
import { Adresa } from "../opsti/adresa";

export class Garaza{

    public id: number;
    public kompanijaDTO: KompanijaVozila;
    public adresaDTO: Adresa;

    constructor(){
        this.id = 0;
        this.kompanijaDTO = new KompanijaVozila();
        this.adresaDTO = new Adresa();
    }
}