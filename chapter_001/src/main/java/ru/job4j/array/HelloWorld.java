package ru.job4j.array;

/*public class HelloWorld {
    static void changeIt(String value) {
        value = new String("Hello!");
    }
    public static void main(String[] argvc)
    {
        String test = new String("Hello World!");
        changeIt(test);
        System.out.println("After changing : " +
                test);
    }
}*/

public class HelloWorld {
    private int iValue;
    static void changeIt(HelloWorld value) {
        value.iValue = 10;
    }
    public static void main(String[] argvc) {
        HelloWorld hw = new HelloWorld();
        hw.iValue = 20;
        changeIt(hw);
        System.out.println("After changing : "
                +
                hw.iValue);
    }
}