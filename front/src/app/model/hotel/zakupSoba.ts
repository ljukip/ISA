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
    public soba: Soba;// vidi
    public brojGostiju: number;
    public opcije: Opcija[];
    public minimalnaCena: number;
    public maksimalnaCena: number;
    public ocena: number;

    constructor(){
        this.id = 0;
        this.pocetniDatum = "";
        this.krajnjiDatum = "";
        this.cenaZakupa = 0;
        this.dodatniPopust = 0;
        this.popustNaTip = 0;
        this.tip = "REDOVAN";
        this.brojGostiju = 0;
        this.soba= new Soba();//[];
        this.opcije = [];
        this.minimalnaCena = 0;
        this.maksimalnaCena = 0;
        this.ocena = 0;
    }
}


 