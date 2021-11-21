package com.company;
import org.junit.Assert;

import static com.company.Main.num;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void TestNum() {
        int[][] a = new int [2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = 0;
            }
        }

        int max;

        max = num(a, 2, 2, 0, 0,  0, a[0][0], 0, 0);
        Assert.assertEquals(max, 0);
    }
}