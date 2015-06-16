package com.example.bled.mytrening;


import com.orm.SugarRecord;

public class UpragnenijaDnja extends SugarRecord<UpragnenijaDnja>{

    Upragnenija upragnenie;
    DniProgrammi den_programmi;

    public UpragnenijaDnja(){}

    public UpragnenijaDnja(Upragnenija upragnenie, DniProgrammi den_programmi){
        this.upragnenie = upragnenie;
        this.den_programmi = den_programmi;
    }


}
