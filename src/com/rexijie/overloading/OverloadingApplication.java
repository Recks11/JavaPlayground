package com.rexijie.overloading;

/**
 * NOTE: If the super-class overridden method does not throws an exception,
 * subclass overriding method can only throws the unchecked exception,
 * throwing checked exception will lead to compile-time error.
 *
 * If the super-class overridden method does throws an exception, subclass overriding method can only throw same,
 * subclass exception. Throwing parent exception in Exception hierarchy will lead to compile time error.
 * Also there is no issue if subclass overridden method is not throwing any exception.
 */
interface JoinService {
    int add(int a, int b);
    String add(String a, String b);
}

class StringJoinService  implements JoinService {

    public int add(int a, int b) {
        return a + b;
    }


    public String add(String a, String b) {
        return a + ' ' + b;
    }
}

public class OverloadingApplication {

    public static void main(String[] args) {
    JoinService service = new StringJoinService();
        System.out.println(service.add(1,2));
        System.out.println(service.add("Rex","Ijiekhuamen"));
    }
}
