package com.rexijie.generics;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class shows the use case of Recursive Generics in Java
 */
class User {
    private String name;
    private String employer;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(String emp) {
        this.employer = emp;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                "employer='" + employer + '\'' +
                '}';
    }
}

class UserBuilder<T extends UserBuilder<T>> {
    protected User user = new User();

    public T withName(String name) {
        user.setName(name);
        return self();
    }

    public User build() {
        return user;
    }

    protected T self() {
        return (T) this;
    }
}

class WorkerBuilder extends UserBuilder<WorkerBuilder> {
    public WorkerBuilder worksAt(String employer) {
        user.setEmployer(employer);
        return self();
    }
}


public class RecursiveGenerics {
    private static final Logger log = Logger.getLogger("Recursive Generics");

    public static void main(String[] args) {
        var ub = new UserBuilder();
        var user = ub
                .withName("Rex")
                .build();

        WorkerBuilder wb = new WorkerBuilder();
        var user2 = wb
                .withName("Rex")
                .worksAt("Baeldung")
                .build();

        log.log(Level.INFO, "{0}", user);
        log.log(Level.INFO, "{0}", user2);
    }
}
