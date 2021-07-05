package org.jiang.algorithms.backtrackingalgorithm;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NQueensTest {

    int n;
    List<List<String>> result;
    NQueens nq = new NQueens();

    @Test
    public void solveNQueens() {
        n = 4;
        result = nq.solveNQueens(n);
        System.out.println(result);

        n = 1;
        result = nq.solveNQueens(n);
        System.out.println(result);

        n = 6;
        result = nq.solveNQueens(n);
        System.out.println(result);
    }
}