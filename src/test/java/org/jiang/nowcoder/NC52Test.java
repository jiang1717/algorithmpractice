package org.jiang.nowcoder;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class NC52Test {

    @Test
    public void isValid() {
        NC52 nc52 = new NC52();
        boolean result = nc52.isValid("[]");
        System.out.println(result);
    }

    @Test
    public void test(){
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map.get(null));
        map.put("qqq", "111");
        map.put("qqq", "222");
        System.out.println(map.get("qqq"));

        Set<String> set = new HashSet<>();
        set.add(null);
        System.out.println(set.toString());
    }
}