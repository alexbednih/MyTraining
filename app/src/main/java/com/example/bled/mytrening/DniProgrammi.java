package com.example.bled.mytrening;


public class DniProgrammi {

    private Integer id_den_programmi;
    private String nazvanie;
    private Integer id_programma;

    DniProgrammi(){}

    public DniProgrammi(Integer id_den_programmi, String nazvanie, Integer id_programma){
        this.id_den_programmi = id_den_programmi;
        this.nazvanie = nazvanie;
        this.id_programma = id_programma;
    }

    public Integer getId_den_programmi() {
        return id_den_programmi;
    }

    public void setId_den_programmi(Integer id_den_programmi) {
        this.id_den_programmi = id_den_programmi;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public Integer getId_programma() {
        return id_programma;
    }

    public void setId_programma(Integer id_programma) {
        this.id_programma = id_programma;
    }
}
