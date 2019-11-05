package uni.kiel;

import java.util.concurrent.Semaphore;

public class Stick {
    boolean isTaken;
    Semaphore s;
    Stick()
    {
        this.s = new Semaphore(1);
        this.isTaken = false;
    }

    public  void getStick() throws InterruptedException {
        this.s.acquire();
        this.isTaken = true;
    }

    public  void putStick(){
        this.isTaken = false;
        this.s.release();
    }
}
