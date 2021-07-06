package org.jiang.algorithms.backtrackingalgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {

    int n;
    List<String> res;

    GenerateParentheses gp = new GenerateParentheses();

    @Test
    public void generateParenthesis() {
        n = 3;
        res = gp.generateParenthesis(n);
        System.out.println(res);// [((())), (()()), (())(), ()(()), ()()()]

        n = 1;
        res = gp.generateParenthesis(n);
        System.out.println(res);// [()]
    }
}