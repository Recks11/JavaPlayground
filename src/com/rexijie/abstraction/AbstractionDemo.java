package com.rexijie.abstraction;

abstract class Family {
    private String familyName;

    public Family(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    abstract void logFamily();
}

class Simpson extends Family {
    private String midName;

    Simpson() {
        super("Simpson");
        this.midName = "Simpson-middle";
    }

    public String getMidName() {
        return this.midName;
    }

    public void logFamily() {
        System.out.println(this.getFamilyName()  + ' '  + this.midName);
    }
}

public class AbstractionDemo {
    final static public void main(String[] args) {
        var simpson = new Simpson();
        simpson.logFamily();
    }
}
