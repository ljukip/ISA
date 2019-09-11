import { ZakupSoba } from "../hotel/zakupSoba";
import { ZakupVozila } from "../vozila/zakupVozila";
<<<<<<< HEAD
import { AvionskaKarta } from "../avionskakompanija/avionskaKarta";

export class Rezervacija{

    public id: number;
    public zakupSobe: ZakupSoba;
    public zakupVozila: ZakupVozila;
    public karta: AvionskaKarta;
=======

export class Adresa{

    public id: number;
    public zakupSoba: ZakupSoba;
    public zakupVozila: ZakupVozila;
>>>>>>> 140683db2bbb6ea77680a34d1f63e826f890d2bb


    constructor(){
        this.id = 0;
<<<<<<< HEAD
        this.zakupSobe = undefined;
        this.zakupVozila = undefined;
        this.karta = new AvionskaKarta();
=======
        this.zakupSoba = new ZakupSoba();
        this.zakupVozila = new ZakupVozila();
>>>>>>> 140683db2bbb6ea77680a34d1f63e826f890d2bb
    }
}


 