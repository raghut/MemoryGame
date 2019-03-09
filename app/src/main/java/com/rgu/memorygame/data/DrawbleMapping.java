package com.rgu.memorygame.data;

import com.rgu.memorygame.R;

import java.util.HashMap;
import java.util.Map;

public class DrawbleMapping {

    public static final Map<Integer, Integer> iconMap;

    static {
        iconMap = new HashMap<>();

        iconMap.put(1, R.drawable.ic_1);
        iconMap.put(2, R.drawable.ic_2);
        iconMap.put(3, R.drawable.ic_3);
        iconMap.put(4, R.drawable.ic_4);
        iconMap.put(5, R.drawable.ic_5);
        iconMap.put(6, R.drawable.ic_6);
        iconMap.put(7, R.drawable.ic_7);
        iconMap.put(8, R.drawable.ic_8);
    }
}
