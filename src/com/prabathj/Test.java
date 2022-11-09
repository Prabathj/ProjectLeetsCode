package com.prabathj;

import java.util.ArrayList;
import java.util.List;

public class Test<T> {
	List<? super Object> list = new ArrayList<>();
	//List<? extends Object> list = new ArrayList<>();
	 
    public <E> void addToList(E e) {
        list.add(e);
    }

    public void print() {
        for (Object o : list) {
            System.out.println(o.getClass());
        }
    }
}

