package com.example.bled.mytrening;


import java.util.List;

public class ApokazStat {
    String[] str2;
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
