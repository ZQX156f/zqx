package com.cskaoyan.array.argcall;

import java.util.Arrays;

public class Demo2 {

    public static void main(String[] args) {
        int[] first = {1, 1, 1};
        int[] second = {2, 2, 2};

        //firstTypeSwap(first, second);
        secondTypeSwap(first, second);

        System.out.println(Arrays.toString(first));
        System.out.println(Arrays.toString(second));

    }

    public static void firstTypeSwap(int[] f, int[] s) {

        for (int i = 0; i < f.length; i++) {
            int tmp = f[i];
            f[i] = s[i];
            s[i] = tmp;
        }

    }

    public static void secondTypeSwap(int[] f, int[] s) {
        int[] tmp = f;
        f = s;
        s = tmp;
    }
}
