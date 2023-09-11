package com.LWY.TestExample;

import java.util.ArrayList;
import java.util.List;

public class test02 {

    int calculateDaysBetweenDates(String date1, String date2) {
        int year1 = Integer.parseInt(date1.substring(0, 4));
        int month1 = Integer.parseInt(date1.substring(5, 7));
        int day1 = Integer.parseInt(date1.substring(8, 10));
        int year2 = Integer.parseInt(date2.substring(0, 4));
        int month2 = Integer.parseInt(date2.substring(5, 7));
        int day2 = Integer.parseInt(date2.substring(8, 10));
        int days = 0;
        if (year1 == year2) {
            if (month1 == month2) {
                days = day2 - day1;
            } else {
                days = day2 + (30 - day1);
            }
        } else {
            days = day2 + (30 - day1) + (year2 - year1 - 1) * 365;
        }
        return days;
    }

    public int cuttingRope(int n) {
        final int MOD = 1000000007;

        if (n <= 3) {
            return n - 1;
        }
        //求商
        int quotient = n / 3 - 1;
        int remainder = n % 3;
        long res = 1, x = 3;
        while (quotient > 0) {
            if ((quotient & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = x * x % MOD;
            quotient >>= 1;
        }
        if (remainder == 0) {
            return (int) (res * 3 % MOD);
        } else if (remainder == 1) {
            return (int) (res * 4 % MOD);
        } else {
            return (int) (res * 6 % MOD);
        }
    }

    public static void main(String[] args) {

        test02 test = new test02();
        int a = test.calculateDaysBetweenDates("2019-01-01", "2019-01-05");
        int num = 32;
        int b = test.cuttingRope(num);
        System.out.println(b);
        System.out.println(test.calculateDaysBetweenDates("2019-01-01", "2019-01-05"));
        System.out.println(a);

        List<List<Integer>> res = new ArrayList<>();
//        res = [[3],[20,9],[15,7]];
        
    }



}

