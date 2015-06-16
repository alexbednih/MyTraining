package com.example.bled.mytrening;


import com.orm.SugarRecord;

public class Programmi extends SugarRecord<Programmi> {


    String nazvanie;

    public Programmi(){}

    public Programmi(String nazvanie){

        this.nazvanie = nazvanie;
    }

}
