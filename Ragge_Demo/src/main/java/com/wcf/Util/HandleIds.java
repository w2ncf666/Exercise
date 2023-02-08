package com.wcf.Util;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HandleIds {

    public static final List<Long> handleIds(String ids) {
        String[] split = ids.split(",");
        List<Long> list = new ArrayList<>();
        for (String s : split) {
            long parseLong = Long.parseLong(s);
            list.add(parseLong);
        }
        return list;
    }


}
