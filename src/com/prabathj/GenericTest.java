package com.prabathj;

public class GenericTest {
	public static void main(String... args) {
        Test<String> test = new Test<>();
        test.addToList(new String("dfas"));
        test.addToList(new Integer(10));
        test.addToList(new Double(10.0));
        test.print();
    }
}
