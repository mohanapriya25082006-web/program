class MyWorkerThread extends Thread {
    
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " is processing item " + i);
            
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Main thread starts.");

        MyWorkerThread thread1 = new MyWorkerThread();
        MyWorkerThread thread2 = new MyWorkerThread();

        thread1.setName("Thread-A");
        thread2.setName("Thread-B");

        thread1.start();
        thread2.start();

        System.out.println("Main thread ends, but child threads continue to run.");
    }
}
