package com.example.bled.mytrening;


import com.orm.SugarRecord;

public class DniProgrammi extends SugarRecord<DniProgrammi>{


    String nazvanie;
    Programmi id_programma;

    DniProgrammi(){}

    public DniProgrammi(String nazvanie, Programmi id_programma){
        this.nazvanie = nazvanie;
        this.id_programma = id_programma;
    }

}
