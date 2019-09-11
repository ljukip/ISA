export class PretragaVozila{
    pocetniDatum: string;
	krajnjiDatum: string;
	tip: string;
	pocetnaCena: number;
	krajnjaCena: number;
    brojPutnika: number;
    
    constructor(){
        this.pocetniDatum = "";
        this.krajnjiDatum = "";
        this.tip = "SEDAN";
        this.pocetnaCena = 0;
        this.krajnjaCena = 0;
        this.brojPutnika = 0;
    }
}