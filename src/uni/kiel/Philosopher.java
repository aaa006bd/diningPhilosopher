package uni.kiel;

public class Philosopher implements Runnable {
    boolean isEating = false;
    boolean isThinking = true;
    int index = 0;
    Stick leftStick;
    Stick rightStick;

    public Philosopher(int index, Stick leftStick, Stick rightStick) {
        this.index = index;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
    }

    public void eating() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Trying to get left " + index);
        this.leftStick.getStick();
        System.out.println("Trying to get right " + index);
        this.rightStick.getStick();
        System.out.printf("Philosopher %d is eating\n",index);
        this.leftStick.putStick();
        this.rightStick.putStick();

    }

    public void thinking(){
        System.out.printf("Philosopher %d is thinking\n",index);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void run() {
        while (true){
            this.thinking();
            try {
                this.eating();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
