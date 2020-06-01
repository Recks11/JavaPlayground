package com.rexijie.generics;

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

    public static void main(String[] args) {
        UserBuilder ub = new UserBuilder();
        var user = ub
                .withName("Rex")
                .build();

        WorkerBuilder wb = new WorkerBuilder();
        var user2 = wb
                .withName("Rex")
                .worksAt("Baeldung")
                .build();

        System.out.println(user);
        System.out.println(user2);
    }
}
