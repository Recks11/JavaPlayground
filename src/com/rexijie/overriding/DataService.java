package com.rexijie.overriding;

interface DataMap {
    String getData();
}
class SpeechService implements DataMap {

    public String getData() {
        return "speech";
    }

    protected String getLanguage() {
        return "english";
    }

    static void recordType() {
        System.out.println("Speech");
    }
}
class DataService extends SpeechService {

    @Override
    public String getData() { // method overloading
        return "Data";
    }

    @Override
    public String getLanguage() { // access level overloading
        return "Spanglish";
    }

    static void recordType() { // Method Hiding
        System.out.println("Data");
    }
}

class Start {
    public static void main(String[] args) {
        DataService ds = new DataService();

        System.out.println(ds.getData());
        System.out.println(ds.getLanguage());
    }
}