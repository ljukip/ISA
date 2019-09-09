import { Soba } from "./soba";
import { Opcija } from "./opcija";

export class ZakupSoba{

    public id: number;
	public pocetniDatum: string;
	public krajnjiDatum: string;
	public cenaZakupa: number;
	public dodatniPopust: number;
	public popustNaTip: number;
	public tip: string;
    public sobe: Soba[];
    public brojGostiju: number;
    public opcije: Opcija[];
    public minimalnaCena: number;
    public maksimalnaCena: number;

    constructor(){
        this.id = 0;
        this.pocetniDatum = "";
        this.krajnjiDatum = "";
        this.cenaZakupa = 0;
        this.dodatniPopust = 0;
        this.popustNaTip = 0;
        this.tip = "";
        this.brojGostiju = 0;
        this.sobe= [];
        this.opcije = [];
        this.minimalnaCena = 0;
        this.maksimalnaCena = 0;
    }
}


 