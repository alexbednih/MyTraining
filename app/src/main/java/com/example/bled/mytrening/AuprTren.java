package com.example.bled.mytrening;


import java.util.List;

public class AuprTren {
    String[] str2;
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
