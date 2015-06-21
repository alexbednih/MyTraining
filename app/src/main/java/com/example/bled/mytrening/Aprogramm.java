package com.example.bled.mytrening;


import android.text.Editable;

import java.util.List;

public class Aprogramm {
    public String[] str;
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













}
