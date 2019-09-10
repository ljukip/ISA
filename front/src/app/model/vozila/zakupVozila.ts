import { Vozilo } from "./vozilo";

export class ZakupVozila{

    public id: number;
	public pocetniDatum: string;
    public krajnjiDatum: string;
    public brojPutnika: number;
    public mestoPreuzimanja: string;
    public mestoVracanja: string;
	public cenaZakupa: number;
	public dodatniPopust: number;
	public popustNaTip: number;
	public tip: string;
    public voziloDTO: Vozilo;
    public minimalnaCena: number;
    public maksimalnaCena: number;

    constructor(){
        this.id = 0;
        this.pocetniDatum = "";
        this.krajnjiDatum = "";
        this.brojPutnika = 0;
        this.mestoPreuzimanja = "";
        this.mestoVracanja = "";
        this.cenaZakupa = 0;
        this.dodatniPopust = 0;
        this.popustNaTip = 0;
        this.tip = "";
        this.voziloDTO = new Vozilo();
        this.maksimalnaCena = 0;
        this.minimalnaCena = 0;
    }
}