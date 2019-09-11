import { Let } from "./let";
import { SedisteNaLetu } from "./sedisteNaLetu";

export class AvionskaKarta{
    public id: number;
	public cena: number;
	public polazniLetDTO: Let;
	public sedistaNaPolaznomLetuDTO: SedisteNaLetu[];
	public povratniLetDTO: Let;
    public sedistaNaPovratnomLetuDTO: SedisteNaLetu[];
    public mestoPolaska: string;
    public mestoDolaska: string;
    public vremePolaska: string;
    public vremeDolaska: string;
    sedistaDTO: SedisteNaLetu[];
    letDTO: Let;
    public ocena: number;
    tip: string;
    
    constructor(){
        this.id = 0;
        this.cena = 0;
        this.polazniLetDTO = new Let();
        this.sedistaNaPolaznomLetuDTO = [];
        this.povratniLetDTO = new Let();
        this.sedistaNaPovratnomLetuDTO = [];
        this.ocena = 0;
        this.sedistaDTO = [];
        this.letDTO = new Let();
        this.tip = "REDOVAN";
    }
}