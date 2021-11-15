package com.example.erp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String[] recode = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Map<String, List<String>> map = new HashMap<>();

        for(String str : recode) {
            int firstIndex = str.indexOf(" ");
            int middleIndex = str.lastIndexOf(" ");
            List<String> list = new ArrayList<>();
            list.add(str.substring(0, firstIndex));

            if(str.contains("Leave")) {
                List<String> l = map.get(str.substring(firstIndex + 1, str.length()));
                list.add(1, l.get(1));
                map.put(str.substring(firstIndex + 1, str.length() - 1), list);
                continue;
            }

            list.add(str.substring(str.lastIndexOf(" ") + 1, str.length() - 1));
            map.put(str.substring(firstIndex + 1, middleIndex), list);
        }

        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

    }
}
