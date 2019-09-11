import { AvionskaKompanija } from "./avionskaKompanija";

export class KategorijaPrtljaga{
    public id: number;
	public naziv: string;
	public cena: number;
	public kolicina: number;
    public avionskaKompanijaDTO: AvionskaKompanija;
    
    constructor(){
        this.id = 0;
        this.naziv = "";
        this.cena = 0;
        this.kolicina = 0;
        this.avionskaKompanijaDTO = new AvionskaKompanija();
    }
}