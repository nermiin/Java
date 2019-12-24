class producer extends Thread {
    data d;

    public producer(data d) {
        this.d = d;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (d) {
                d.deger++;
                System.out.println("uretici: " + d.deger);
            }
        }
    }
}

class consumer implements Runnable {
    data d;

    public consumer(data d) {
        this.d = d;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (d) {
                d.deger--;
                System.out.println("tuketici: " + d.deger);
            }
        }
    }
}

class thread {

    public static void main(String args[]) {
        data d = new data();
        d.deger = 0;
        producer p = new producer(d);
        consumer c = new consumer(d);
        Thread t = new Thread(c);
        p.start();
        t.start();
    }
}

class data {
    int deger;
}