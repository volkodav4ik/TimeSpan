package com.volkodav4ik;

public class Main {

    public static void main(String[] args) {
	    TimeSpan breakfast = new TimeSpan(8, 45);

        TimeSpan oneAndHalf = new TimeSpan(9,30);
        breakfast.add(oneAndHalf);
        System.out.println(breakfast);

        breakfast.sub(oneAndHalf);
        System.out.println(breakfast);

        breakfast.mult(1.75);
        System.out.println(breakfast);
    }
}
