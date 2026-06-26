class MyTask implements Runnable {
    private String taskName;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " is executing step " + i);
            
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                System.out.println(taskName + " was interrupted.");
            }
        }
        System.out.println(taskName + " has finished!");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread starts.");

        MyTask task1 = new MyTask("Thread-A");
        MyTask task2 = new MyTask("Thread-B");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        System.out.println("Main thread ends, but background tasks continue.");
    }
}
