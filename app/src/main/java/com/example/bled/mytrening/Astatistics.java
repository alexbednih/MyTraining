package com.example.bled.mytrening;


import java.util.List;

public class Astatistics {
    String[] str;
    String[] str2;
    public String[] spisokUpr(){
        List<Upragnenija> upragnenijas = Upragnenija.listAll(Upragnenija.class);
        int y=0;
        if (upragnenijas.size()!=0) {
            str = new String[upragnenijas.size()];
            for (Upragnenija upragnenija : upragnenijas) {
                str[y] =upragnenija.nazvanie;
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

    public String[] spisokZnachPodhodov(Integer vibor){
        List<Upragnenija> upragnenijas = Upragnenija.listAll(Upragnenija.class);
        int x=1;
        Long idUpr = null;
        for (Upragnenija upragnenija : upragnenijas) {
            if(vibor==x){
                idUpr=upragnenija.getId();
            }
            x++;
        }
        //List<Note> notes = Note.findWithQuery(Note.class, "Select * from Note where name = ?", "satya");
        List<Podhodi> podhodis = Podhodi.findWithQuery(Podhodi.class,"SELECT SUM(KOLPOVTOREN) FROM PODHODI;");
        return str2;
    }
}
