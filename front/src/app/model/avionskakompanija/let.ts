import { Destinacija } from "../opsti/destinacija";

export class Let{

    public id: number;
    public duzina: number; //u kolimetrima
	public vremePoletanja: string;
	public vremeSletanja: string;
	public polazisteDTO: Destinacija;
	public odredisteDTO: Destinacija;
	public presedanja: string;
    public cena: number;
    public vreme: number; //u satima
    public prosecnaOcena: number;
    public tip: string;
    public vremePutovanja: number;
    
    constructor(){
        this.id = 0;
        this.duzina = 0;
        this.vremePoletanja = "";
        this.vremeSletanja = "";
        this.polazisteDTO = new Destinacija();
        this.odredisteDTO = new Destinacija();
        this.presedanja = "";
        this.cena = 0;
        this.vreme = 0;
        this.prosecnaOcena = 0;
        this.tip = "JEDNOSMERNI";
        this.vremePutovanja = 0;
    }
}