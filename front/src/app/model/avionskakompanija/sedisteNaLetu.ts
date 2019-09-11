import { KategorijaPrtljaga } from "./kategorijaPrtljaga";

export class SedisteNaLetu{
    public id: number;
    public red: number;
    public kolona: number;
	public klasa: string;
    public cena: number;
    public kategorijaPrtljagaDTO: KategorijaPrtljaga;
    public imePutnika: string;
    public prezimePutnika   : string;
    public brojPasosa: string;
    public email: string;

    constructor(){
        this.id = 0;
        this.red = 0;
        this.kolona = 0;
        this.klasa = "";
        this.cena = 0;
        this.kategorijaPrtljagaDTO = new KategorijaPrtljaga();
        this.id = 0;
        this.imePutnika = undefined;
        this.prezimePutnika = undefined;
        this.brojPasosa = undefined;
        this.email = "";
    }
}