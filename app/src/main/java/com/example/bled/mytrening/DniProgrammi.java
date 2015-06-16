package com.example.bled.mytrening;


import com.orm.SugarRecord;

public class DniProgrammi extends SugarRecord<DniProgrammi>{


    String nazvanie;
    Programmi programma;

    public DniProgrammi(){}

    public DniProgrammi(String nazvanie, Programmi programma){
        this.nazvanie = nazvanie;
        this.programma = programma;
    }

}
