package ProducerConsumer;

public class Consumer extends Thread{
    private Q q;
    private int n;
    Consumer(Q q){
        this.q = q;
        start();
}

    public int getN() {
        return n;
    }

    @Override
    public void run() {
        this.n = q.get();
    }

}