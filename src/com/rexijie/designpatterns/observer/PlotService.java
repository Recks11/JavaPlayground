package com.rexijie.designpatterns.observer;

public class PlotService implements Observer {

    public PlotService() {
    }

    public void plot(Double data) {
        onChange(data);
    }

    @Override
    public void onChange(Double d) {
        System.out.println(d);
    }
}
