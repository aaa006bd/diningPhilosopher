package uni.kiel;

public class Main {

    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        Stick[] sticks = new Stick[numberOfPhilosophers];
        for (int i = 0; i < numberOfPhilosophers; i++) {
            sticks[i]=new Stick();
        }
        for (int i = 0; i < numberOfPhilosophers; i++) {
            philosophers[i] = new Philosopher(i,sticks[i],sticks[(i+1)%numberOfPhilosophers]);
        }
//        philosophers[4]=new Philosopher(4,sticks[0],sticks[4]);
        for (int i = 0; i < numberOfPhilosophers; i++) {
            new Thread(philosophers[i]).start();
        }
    }

}
