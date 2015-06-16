package com.example.bled.mytrening;


import com.orm.SugarRecord;

import java.sql.Time;

public class Podhodi extends SugarRecord<Podhodi>{

    Upragnenija upragnenie;
    Trenirovki trenirovka;
    Integer kol_povtoren;
    Integer vremja_vipolnenija;

    public Podhodi(){}

    public Podhodi(Upragnenija upragnenie, Trenirovki trenirovka, Integer kol_povtoren, int vremja_vipolnenija){

        this.upragnenie = upragnenie;
        this.trenirovka = trenirovka;
        this.kol_povtoren = kol_povtoren;
        this.vremja_vipolnenija = vremja_vipolnenija;
    }

}
