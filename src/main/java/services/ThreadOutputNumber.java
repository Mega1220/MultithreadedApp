package services;

public class ThreadOutputNumber extends Thread {
    public static final int NUMBER_ONE = 1;
    public static final int NUMBER_TWO = 2;
    public static final Object MONITOR = new Object();

    private int number;

    public ThreadOutputNumber(int number) {
        this.number = number;
    }

    public void run() {
        while (true) {
            synchronized (MONITOR) {
                System.out.println(this.number);
                try {
                    Thread.sleep(500);
                    MONITOR.notify();
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
