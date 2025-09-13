package model;

public class Person {
    private volatile boolean asksToPass = true;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void seyHello(Person person) {
        System.out.println("Привет " + person.getName());
        person.returnAGreeting(this);
    }

    public synchronized void returnAGreeting(Person person) {
        System.out.println("О! Привет "  + person.getName());
    }

    public void walkDownTheHallway (Person person) {
        while (hasPassedHallway()) {
            System.out.println(this.getName() + " ждёт когда можно будет пройти!");

            try {
                Thread.sleep(1000);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (person.asksToPass) {
                System.getLogger(person.getName());
                this.asksToPass = false;
            } else this.asksToPass = true;
        }
    }

    public boolean hasPassedHallway() {
        return this.asksToPass;
    }
}


