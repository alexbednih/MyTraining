package com.example.bled.mytrening;


import java.util.List;

public class Astatistics {
    String[] str;
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


}
