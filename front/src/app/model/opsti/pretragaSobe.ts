export class PretragaSobe{
    pocetniDatum: string;
	krajnjiDatum: string;
	brojGostiju: number;
	tip: string;
	pocetnaCena: number;
    krajnjaCena: number;
    
    constructor(){
        this.pocetniDatum = "";
        this.krajnjiDatum = "";
        this.brojGostiju = 0;
        this.tip = "JEDNOKREVETNA";
        this.pocetnaCena = 100;
        this.krajnjaCena = 400;
    }
}