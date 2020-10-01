package com.rexijie.designpatterns.observer;

public class Main {

    public static void main(String[] args) {
        DataPublisher publisher = new DataPublisher(); // creating the Publisher

        // creating subscribers
        PlotService ps = new PlotService(); // prnt data
        PlotService ps2 = new PlotService(); // print data
        Doubler bd = new Doubler(); // prints 100 multiplied by data

        publisher.subscribe(ps); // subsctibing to the publisher
        publisher.subscribe(ps2);
        publisher.subscribe(bd);

        publisher.computeNumber(); // generating number
    }
}

class Doubler implements Observer {

    @Override
    public void onChange(Double d) {
        System.out.println(d * 100);
    }
}
