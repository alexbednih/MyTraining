package com.example.bled.mytrening;


import java.text.SimpleDateFormat;
import java.util.List;
import java.text.DateFormat;
import java.util.Date;

public class Atraining {
    String[] str;
    String[] str2;
    String[] str3;

    public String[] spisokTrenirovok(){

        List<Trenirovki> trens = Trenirovki.listAll(Trenirovki.class);
        int y=0;
        if (trens.size()!=0) {
            str = new String[trens.size()];
            for (Trenirovki tren : trens) {
                str[y] =(y+1) + " - " + tren.data_trenirovki.toString();
                y++;
            }

        }
        else
        {
            str = new String[1];
            str[y] = "";
        }
        return str;
    }


    public void addTrenirovka(Integer i, Integer j){
        AuprDay auprDay = new AuprDay();
        Long idDnja = auprDay.getIdDnja(i, j);
        Programmi progr = Programmi.findById(Programmi.class, (long) j);
        DniProgrammi den = DniProgrammi.findById(DniProgrammi.class,idDnja);
        String data = getDate();
        long vremja = 0;
        Trenirovki tren = new Trenirovki(progr, den, data, vremja);
        tren.save();
    }



    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return dateFormat.format(new Date());
    }











}
