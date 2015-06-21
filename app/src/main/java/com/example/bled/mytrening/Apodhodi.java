package com.example.bled.mytrening;


import java.util.List;

public class Apodhodi {
    String[] str3;

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

    public void addPodhod(Long tren, Long den, Integer viborUpr, Integer kolPovtor, Long vremja){
        Trenirovki trenirovki = Trenirovki.findById(Trenirovki.class,tren);
        Long idUpr = getIdUpr(den, viborUpr);
        Upragnenija upragnenija = Upragnenija.findById(Upragnenija.class, idUpr);
        Podhodi podhodi = new Podhodi(upragnenija,trenirovki,kolPovtor, vremja);
        podhodi.save();
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
}
