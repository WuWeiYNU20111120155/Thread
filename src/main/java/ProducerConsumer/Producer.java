package ProducerConsumer;

public class Producer extends Thread{
    private Q q;
    private int n;
    Producer(Q q,int n){
        this.q = q;
        this.n = n;
        start();
    }

    @Override
    public void run() {
        q.put(n);
    }
}
