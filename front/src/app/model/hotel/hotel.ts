import { Adresa } from "../opsti/adresa";

export class Hotel{

    public id: number;
    public naziv: string;
    public opis: string;
    public adresaDTO: Adresa;
    public prosecnaOcena: number;

    constructor(){
        this.id = 0;
        this.naziv = "";
        this.opis = "";
        this.adresaDTO = new Adresa();
        this.prosecnaOcena = 0;
    }
}
