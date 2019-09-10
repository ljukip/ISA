import { Garaza } from "./garaza";

export class Vozilo{

    public id: number;
    public marka: string;
    public model: string;
    public naziv: string;
    public godinaProizvodnje: number;
    public brojPutnika: number;
    public cenaPoDanu: number;
    public tip: string;
    public garazaDTO: Garaza;

    constructor(){
        this.id = 0;
        this.brojPutnika = 0;
        this.cenaPoDanu = 0;
        this.godinaProizvodnje = 0;
        this.marka = "";
        this.model = "";
        this.naziv = "";
        this.tip = "";
        this.garazaDTO = new Garaza();
    }
}


 