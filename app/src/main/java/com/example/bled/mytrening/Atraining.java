package com.example.bled.mytrening;


import java.text.SimpleDateFormat;
import java.util.List;
import java.text.DateFormat;
import java.util.Date;

public class Atraining {
    String[] str;
    String[] str2;
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
        Aprogramm aprog = new Aprogramm();
        Long idDnja = aprog.getIdDnja(i, j);
        Programmi progr = Programmi.findById(Programmi.class, (long) j);
        DniProgrammi den = DniProgrammi.findById(DniProgrammi.class,idDnja);
        String data = getDate();
        Integer vremja = 0;
        Trenirovki tren = new Trenirovki(progr, den, data, vremja);
        tren.save();
    }

    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH.mm");
        return dateFormat.format(new Date());
    }

    public String[] spisokUprDayCreate(Long i, Long j){
        List<UpragnenijaDnja> uprDays = UpragnenijaDnja.find(UpragnenijaDnja.class, "denprogrammi = ?", String.valueOf(i));
        int y = 0;
        if (uprDays.size()!=0) {
            str2 = new String[uprDays.size()];
            for (UpragnenijaDnja uprDay : uprDays) {
                str2[y] = uprDay.upragnenie.nazvanie;
                y++;
            }
        }
        else
        {
            str2 = new String[1];
            str2[y] = "";
        }
        return str2;
    }

}
