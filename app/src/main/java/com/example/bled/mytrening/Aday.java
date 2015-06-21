package com.example.bled.mytrening;


import java.util.List;

public class Aday {
    String[] str2;

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

    public void addNewDayProgramm(String stroka, Integer i){
        Programmi progr = Programmi.findById(Programmi.class, (long) i);
        DniProgrammi days = new DniProgrammi(stroka, progr);
        days.save();
    }
}
