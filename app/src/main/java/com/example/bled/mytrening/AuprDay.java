package com.example.bled.mytrening;


import java.util.List;

public class AuprDay {
    String[] str3;
    String[] str4;

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

    public void addUprDnja(Integer i, Integer j, Integer k){
        Long idDnja = getIdDnja(i,j);
        Upragnenija upr = Upragnenija.findById(Upragnenija.class, Long.valueOf(k));
        DniProgrammi den = DniProgrammi.findById(DniProgrammi.class,idDnja);
        UpragnenijaDnja uprDnja = new UpragnenijaDnja(upr,den);
        uprDnja.save();
    }

    public void addNewUprDnja(String stroka, Integer i, Integer j){
        Long idDnja = getIdDnja(i,j);
        Upragnenija upr = new Upragnenija(stroka);
        upr.save();
        DniProgrammi den = DniProgrammi.findById(DniProgrammi.class,idDnja);
        UpragnenijaDnja uprDnja = new UpragnenijaDnja(upr,den);
        uprDnja.save();
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
}
