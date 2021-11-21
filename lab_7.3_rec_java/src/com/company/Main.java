package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void  create(int[][] a, int col, int row, int l, int h, int i, int j) {
        Random rn = new Random();
        a[i][j] =  rn.nextInt(h - l) + l;
        if (j < col-1) {
            create(a, col, row, l, h, i, j + 1);
        }
        else if (i < row-1) {
            create(a, col, row, l, h, i + 1, 0);
        }
    }

    public static void print(int[][] a, int row, int col, int i, int j ) {

        if (j == 0) {
            System.out.print("|");
        }

        System.out.printf("%4d" ,a[i][j]);

        if (j == col-1) {
            System.out.print( "|");
            System.out.println();
        }

        if (j < col-1) {
            print(a, row, col, i, j + 1);
        }
        else if (i < row-1) {
            print(a, row, col, i + 1, 0);
        }
        else {
            System.out.println();
        }
    }

    public static int count(int[][] a, int col, int row, int i, int j, int u, int p) {
//        if (a[i][j] == 0 && j < row - 1 && i < col - 1) {
//            return count(a, col, row, i, row, u + 1);
//        }
//        else if (a[i][j] != 0 && j < row - 1) {
//            return count(a, col, row, i , j+1, u);
//        }
//        else if (i < col - 1) {
//            return count(a, col, row, i+1, 0, u);
//        }
//        else
//            return u+1;
        if(a[i][j] == 0){
            p += 1;
        }

        if(j < row-1 && p == 0){
            return count(a, col, row, i , j+1, u, 0);
        }
        else if (i < col - 1) {
            u+=1;
            return count(a, col, row, i+1, 0, u, 0);
        }
        else
            return u+1;
    }

    public static int num(int[][] a, int row, int col, int i, int j, int j_max, int a_same, int max, int mp) {
        if (a[i][j] == a_same) {
            mp += 1;

            if (mp > max) {
                max = mp;
                j_max = j;
            }
        }
        else {
            a_same = a[i][j];
            mp = 0;
        }

        if (i < row - 1) {
            return num(a, row, col, i + 1, j, j_max, a_same, max, mp);
        }
        else if (j < col - 1) {
            return num(a, row, col, 0, j + 1, j_max, a[0][j + 1] + 1, max, 0);
        }
        else{
            return j_max;
        }
    }



    public static void main(String[] args) {
            int k;
            int n;

            Scanner scan = new Scanner(System.in);
            k = scan.nextInt();
            n = scan.nextInt();

            int l = 0;
            int h = 2;

            int j_max;
            int q ;

            int[][] a = new int [k][n];

            create(a, n, k, l, h, 0, 0);

            print(a, k, n, 0, 0);

            q = count(a, k, n, 0, 0, 0, 0);
            System.out.println("num = "+ q);

            j_max = num(a, k, n, 0, 0, 0, a[0][0], 0, 0);
            System.out.println("j_max = "+ (j_max+1));

    }
}
