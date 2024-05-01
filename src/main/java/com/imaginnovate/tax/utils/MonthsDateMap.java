package com.imaginnovate.tax.utils;

import java.util.HashMap;
import java.util.Map;

public class MonthsDateMap {

    public static Map<Integer, Integer> mothsMap = new HashMap<>();

    public static Map<Integer, Integer> constructMap(){
        mothsMap.put(1, 31);
        mothsMap.put(2, 28);
        mothsMap.put(3, 31);
        mothsMap.put(4, 30);
        mothsMap.put(5, 31);
        mothsMap.put(6, 30);
        mothsMap.put(7, 31);
        mothsMap.put(8, 31);
        mothsMap.put(9, 30);
        mothsMap.put(10, 31);
        mothsMap.put(11, 30);
        mothsMap.put(12, 31);

        return mothsMap;
    }
}
