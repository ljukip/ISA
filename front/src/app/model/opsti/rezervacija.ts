import { ZakupSoba } from "../hotel/zakupSoba";
import { ZakupVozila } from "../vozila/zakupVozila";

export class Adresa{

    public id: number;
    public zakupSoba: ZakupSoba;
    public zakupVozila: ZakupVozila;


    constructor(){
        this.id = 0;
        this.zakupSoba = new ZakupSoba();
        this.zakupVozila = new ZakupVozila();
    }
}


 