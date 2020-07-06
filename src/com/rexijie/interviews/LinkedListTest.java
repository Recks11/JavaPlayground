package com.rexijie.interviews;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest<T> {
    private LinkedList<T> removeDuplicates(LinkedList<T> list) {
        var it = list.iterator();
        T last = it.next();
        T next;
        while (it.hasNext()) {
            next = it.next();
            if (last.equals(next)) {
                it.remove();
            }
            last = next;
        }
        return list;
    }

    public static void main(String[] args) {
        var list = new LinkedList<>(List.of("Rex", "Rex", "Rex", "Rupa", "Rupa", "Samantha", "Samantha", "Andie", "Andie", "Andie"));
        LinkedListTest<String> sL = new LinkedListTest<>();
        System.out.println(sL.removeDuplicates(list));
        int i = 0;
    }
}

class HashTag {
    public static void main(String[] args) {
        int n = 500;

        var space = " ";
        var hash = "#";

        for (int i = 1; i <= n; i++) {
            var str = space.repeat(n - i)
                    .concat(hash.repeat(i));
            System.out.println(str);

        }
    }
}