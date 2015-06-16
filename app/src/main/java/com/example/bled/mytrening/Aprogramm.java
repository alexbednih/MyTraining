package com.example.bled.mytrening;


import java.util.List;

public class Aprogramm {
    public String[] str;
    public String[] str2;
    public String[] menuCreate(){
        List<Programmi> proga = Programmi.listAll(Programmi.class);
        if (proga.size() == 0){
            Programmi progr = new Programmi("GTO");
            progr.save();
            progr = Programmi.findById(Programmi.class, (long) 1);
            DniProgrammi days = new DniProgrammi("Pervii_1", progr);
            days.save();
            days = new DniProgrammi("Vtoroi_1", progr);
            days.save();
            progr = new Programmi("STO");
            progr.save();
            progr = Programmi.findById(Programmi.class, (long) 2);
            days = new DniProgrammi("Pervii_2", progr);
            days.save();
            days = new DniProgrammi("Vtoroi_2", progr);
            days.save();
            days = new DniProgrammi("Tretii_2", progr);
            days.save();
        }
        List<Programmi> progs = Programmi.listAll(Programmi.class);

        str = new String[progs.size()];
        int i=0;
        for (Programmi prog : progs){
            str[i] = prog.nazvanie;
            i++;
        }
        return str;
    }

    public String[] menuDayCreate(Integer i){
        //List<Book> books = Book.find(Book.class, "author = ?", new String{author.getId()});
        List<DniProgrammi> days = DniProgrammi.find(DniProgrammi.class, "programma = ?", String.valueOf(i));
        str2 = new String[days.size()];
        int y = 0;
        for (DniProgrammi day : days){
            str2[y] = day.nazvanie;
            y++;
        }
        return str2;
    }
}
