package org.example;

import model.Person;

public class Main {
    public static void main(String[] args) {
        Person egor = new Person("Egor");
        Person john = new Person("John");

//        new Thread(() -> egor.seyHello(john)).start();
//        new Thread(() -> john.seyHello(egor)).start();

        Runnable lockerEgor = () -> {
            egor.walkDownTheHallway(john);
        };

        Runnable lockerJohn = () -> {
            john.walkDownTheHallway(egor);
        };


        new Thread(() -> egor.walkDownTheHallway(john)).start();
        new Thread(() -> john.walkDownTheHallway(egor)).start();

        new Thread(lockerEgor).start();
        new Thread(lockerJohn).start();

    }
}