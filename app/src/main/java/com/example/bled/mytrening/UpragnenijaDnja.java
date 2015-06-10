package com.example.bled.mytrening;


public class UpragnenijaDnja {

    private Integer id_upragnenie;
    private Integer id_den_programmi;

    UpragnenijaDnja(){}

    public UpragnenijaDnja(Integer id_upragnenie, Integer id_den_programmi){
        this.id_upragnenie = id_upragnenie;
        this.id_den_programmi = id_den_programmi;
    }

    public Integer getId_upragnenie(){
        return id_upragnenie;
    }

    public void setId_upragnenie(Integer id_upragnenie){
        this.id_upragnenie = id_upragnenie;
    }

    public Integer getId_den_programmi() {
        return id_den_programmi;
    }

    public void setId_den_programmi(Integer id_den_programmi) {
        this.id_den_programmi = id_den_programmi;
    }

}
