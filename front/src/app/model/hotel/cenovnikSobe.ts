export class CenovnikSobe{
    public id: number;
	public pocetniDatum: string;
	public krajnjiDatum: string;
    public cena: number;
    
    constructor(){
        this.id = 0;
        this.pocetniDatum = "";
        this.krajnjiDatum = "";
        this.cena = 0;
    }
}