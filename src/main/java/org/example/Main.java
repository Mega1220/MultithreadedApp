package org.example;

import model.Person;
import services.ThreadOutputNumber;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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



        new Thread(lockerEgor).start();
        new Thread(lockerJohn).start();

        Thread printOne = new ThreadOutputNumber(ThreadOutputNumber.NUMBER_ONE);
        Thread printTwo = new ThreadOutputNumber(ThreadOutputNumber.NUMBER_TWO);

        printOne.start();
        printTwo.start();
    }
}