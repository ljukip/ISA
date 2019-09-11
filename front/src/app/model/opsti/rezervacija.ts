import { ZakupSoba } from "../hotel/zakupSoba";
import { ZakupVozila } from "../vozila/zakupVozila";
import { AvionskaKarta } from "../avionskakompanija/avionskaKarta";

export class Rezervacija{

    public id: number;
    public zakupSobe: ZakupSoba;
    public zakupVozila: ZakupVozila;
    public karta: AvionskaKarta;


    constructor(){
        this.id = 0;
        this.zakupSobe = undefined;
        this.zakupVozila = undefined;
        this.karta = new AvionskaKarta();
    }
}


 