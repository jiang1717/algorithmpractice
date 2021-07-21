package org.jiang.nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class NC52Test {

    @Test
    public void isValid() {
        NC52 nc52 = new NC52();
        boolean result = nc52.isValid("[]");
        System.out.println(result);
    }
}