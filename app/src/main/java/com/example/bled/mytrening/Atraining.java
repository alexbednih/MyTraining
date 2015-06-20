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
        Aprogramm aprog = new Aprogramm();
        Long idDnja = aprog.getIdDnja(i, j);
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

    public void addPodhod(Long tren, Long den, Integer viborUpr, Integer kolPovtor, Long vremja){
        Trenirovki trenirovki = Trenirovki.findById(Trenirovki.class,tren);
        Long idUpr = getIdUpr(den, viborUpr);
        Upragnenija upragnenija = Upragnenija.findById(Upragnenija.class, idUpr);
        Podhodi podhodi = new Podhodi(upragnenija,trenirovki,kolPovtor, vremja);
        podhodi.save();
    }

    public String[] spisokPodhodov(Long tren, Long den, Integer viborUpr){
        Long idUpr=getIdUpr(den, viborUpr);
        String[] uslovia = {String.valueOf(tren), String.valueOf(idUpr)};
        List<Podhodi> podhodis = Podhodi.find(Podhodi.class,"trenirovka = ? and upragnenie = ?",uslovia);
        int y = 0;
        if (podhodis.size()!=0) {
            str3 = new String[podhodis.size()];
            for (Podhodi podhodi : podhodis) {
                str3[y] =(y+1) + " подход - " + podhodi.kol_povtoren.toString();
                y++;
            }
        }
        else
        {
            str3 = new String[1];
            str3[y] = "";
        }

        return str3;
    }

    public Long getIdUpr(Long den, Integer viborUpr){
        List<UpragnenijaDnja> upragnenijaDnjas = UpragnenijaDnja.find(UpragnenijaDnja.class, "denprogrammi = ?", String.valueOf(den));
        int y=0;
        Long id = null;

        for (UpragnenijaDnja uprDnja : upragnenijaDnjas) {
            if(viborUpr==y){
                id=uprDnja.upragnenie.getId();
            }
            y++;
        }
        return id;
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
