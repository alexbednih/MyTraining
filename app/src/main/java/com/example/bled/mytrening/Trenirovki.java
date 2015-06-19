package com.example.bled.mytrening;

import com.orm.SugarRecord;

import java.sql.Time;
import java.util.Date;

public class Trenirovki extends SugarRecord<Trenirovki>{


    Programmi programma;
    DniProgrammi den_programmi;
    String data_trenirovki;
    Integer vremja_vipolnenija;

    public Trenirovki(){}

    public Trenirovki(Programmi programma, DniProgrammi den_programmi, String data_trenirovki, int vremja_vipolnenija){

        this.programma = programma;
        this.den_programmi = den_programmi;
        this.data_trenirovki = data_trenirovki;
        this.vremja_vipolnenija = vremja_vipolnenija;
    }

}
