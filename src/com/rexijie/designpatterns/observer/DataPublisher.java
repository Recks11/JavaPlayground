package com.rexijie.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class DataPublisher implements Observable, Publisher {
    List<Double> state; // state = []
    List<Observer> observerList; // observerList = []

    public DataPublisher() { // __init__(self)
        // self.state = []
        this.state = new ArrayList<>();
        this.observerList = new ArrayList<>();
    }

    public void computeNumber() { // def compureNumer():
        var nums = Math.random(); // nums = 0.0213
        state.add(Math.random());
        observerList.forEach(obs -> { // for obs in observerList
            obs.onChange(nums);
        });
    }

    @Override
    public void subscribe(Observer observer) { // def subscribe(obs: Observer):
        this.observerList.add(observer);
    }
}
