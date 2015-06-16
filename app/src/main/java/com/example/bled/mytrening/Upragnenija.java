package com.example.bled.mytrening;

import com.orm.SugarRecord;

public class Upragnenija extends SugarRecord<Upragnenija>{

    String nazvanie;

    public Upragnenija(){}

    public Upragnenija(String nazvanie){

        this.nazvanie = nazvanie;
    }

}
