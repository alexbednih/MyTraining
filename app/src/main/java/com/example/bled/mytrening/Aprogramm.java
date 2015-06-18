package com.example.bled.mytrening;


import android.text.Editable;

import java.util.List;

public class Aprogramm {
    public String[] str;
    public String[] str2;
    public String[] str3;
    public String[] str4;
    public void sozdanieBazi(){
        List<Programmi> proga = Programmi.listAll(Programmi.class);
        if (proga.size() == 0){
            Upragnenija upr = new Upragnenija("Подтягивания");
            upr.save();
            upr = new Upragnenija("Отжимания");
            upr.save();
            upr = new Upragnenija("Отжимания на брусьях");
            upr.save();
            upr = new Upragnenija("Приседания");
            upr.save();
            upr = new Upragnenija("Жим лежа");
            upr.save();
            upr = new Upragnenija("Пресс");
            upr.save();
            upr = new Upragnenija("Подтягивания обратным хватом");
            upr.save();
            Programmi progr = new Programmi("ГТО");
            progr.save();
            progr = Programmi.findById(Programmi.class, (long) 1);
            DniProgrammi days = new DniProgrammi("Первый_1", progr);
            days.save();
            progr = new Programmi("Общая подготовка");
            progr.save();
            progr = Programmi.findById(Programmi.class, (long) 2);
            days = new DniProgrammi("Первый_2", progr);
            days.save();
            days = new DniProgrammi("Второй_2", progr);
            days.save();
            days = new DniProgrammi("Третий_2", progr);
            days.save();
            progr = new Programmi("Разнообразная");
            progr.save();
        }
    }
    public String[] menuCreate(){

        List<Programmi> progs = Programmi.listAll(Programmi.class);

        str = new String[progs.size()];
        int i=0;
        for (Programmi prog : progs){
            str[i] = prog.nazvanie;
            i++;
        }
        return str;
    }

    public void addNewProgramm(String stroka){
        Programmi progr = new Programmi(stroka);
        progr.save();
    }

    public void addNewDayProgramm(String stroka, Integer i){
        Programmi progr = Programmi.findById(Programmi.class, (long) i);
        DniProgrammi days = new DniProgrammi(stroka, progr);
        days.save();
    }

    public void addNewUprDnja(String stroka, Integer i, Integer j){
        Long idDnja = getIdDnja(i,j);
        Upragnenija upr = new Upragnenija(stroka);
        upr.save();
        DniProgrammi den = DniProgrammi.findById(DniProgrammi.class,idDnja);
        UpragnenijaDnja uprDnja = new UpragnenijaDnja(upr,den);
        uprDnja.save();
    }

    public void addUprDnja(Integer i, Integer j, Integer k){
        Long idDnja = getIdDnja(i,j);
        Upragnenija upr = Upragnenija.findById(Upragnenija.class, Long.valueOf(k));
        DniProgrammi den = DniProgrammi.findById(DniProgrammi.class,idDnja);
        UpragnenijaDnja uprDnja = new UpragnenijaDnja(upr,den);
        uprDnja.save();
    }

    public String[] menuDayCreate(Integer i){
        //List<Book> books = Book.find(Book.class, "author = ?", new String{author.getId()});
        List<DniProgrammi> days = DniProgrammi.find(DniProgrammi.class, "programma = ?", String.valueOf(i));
        int y = 0;

        if (days.size()!=0) {
            str2 = new String[days.size()];
            for (DniProgrammi day : days) {
                str2[y] = day.nazvanie;

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

    public String[] spisokUpragneniy(){
        //List<Book> books = Book.find(Book.class, "author = ?", new String{author.getId()});
        //List<DniProgrammi> days = DniProgrammi.find(DniProgrammi.class, "programma = ?", String.valueOf(i));
        List<Upragnenija> uprs = Upragnenija.listAll(Upragnenija.class);
        int y = 0;

        if (uprs.size()!=0) {
            str4 = new String[uprs.size()];
            for (Upragnenija upr : uprs) {
                str4[y] = upr.nazvanie;
                y++;
            }

        }
        else
        {
            str4 = new String[1];
            str4[y] = "";
        }
        return str4;
    }

    public String[] spisokUprDayCreate(Integer i, Integer j){
        //List<Book> books = Book.find(Book.class, "author = ?", new String{author.getId()});

        Long idDnja = getIdDnja(i,j);
        List<UpragnenijaDnja> uprDays = UpragnenijaDnja.find(UpragnenijaDnja.class, "denprogrammi = ?", String.valueOf(idDnja));
        //str3 = new String[1];
        int y = 0;
        //str3[y]=i.toString();

        if (uprDays.size()!=0) {
            str3 = new String[uprDays.size()];
            for (UpragnenijaDnja uprDay : uprDays) {
                str3[y] = uprDay.upragnenie.nazvanie;
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
    public Long getIdDnja(Integer i, Integer j){
        List<DniProgrammi> days = DniProgrammi.find(DniProgrammi.class, "programma = ?", String.valueOf(j));
        int x=1;
        Long idDnja = null;
        for (DniProgrammi day : days) {
            if(i==x){
                idDnja=day.getId();
            }
            x++;
        }
        return idDnja;
    }
}
