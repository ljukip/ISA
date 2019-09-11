import { Adresa } from "../opsti/adresa";

export class AvionskaKompanija{

    public id: number;
	public naziv: string;
	public opis: string;
    public adresaDTO: Adresa;
    public longitude: number;
    public latitude: number;
    public prosecnaOcena: number;
    
    constructor(){
        this.id = 0;
        this.naziv = "";
        this.opis = "";
        this.adresaDTO = new Adresa();
        this.longitude = 0;
        this.latitude = 0;
        this.prosecnaOcena = 0;
    }
}