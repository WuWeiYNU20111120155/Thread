package ProducerConsumer;

public class Q {
    //仓库
   int n;
   boolean valueSet = false;

   //Consumer
    synchronized int get(){
        //value 还没有被设置好！
        if(!valueSet){
            try{
                wait();//暂停，等待着put()来设置好这个值之后再来读取
            }catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got: "+n);
        valueSet = false;//标记已经取走了值
        notify();//通知put()可以设置另外一个值
        return n;
    }
    synchronized void put(int n){
        //如果这个值已经设置好了
        if(valueSet){
            try{
                wait();//等待消费者把值取走了
            }catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }
        }
        this.n = n;//设置一个新的值
        valueSet = true;//标记已经设置好了
        System.out.println("Put: "+n);
        notify();//通知线程get()这个最新值
    }

    public static void main(String args[]){
        Q q = new Q();//建一个仓库
        Producer producer = new Producer(q,5);//往仓库加一个值
        Producer producer1 = new Producer(q,8);//等消费者取出来后，往仓库加一个值
        Consumer consumer = new Consumer(q);
        Consumer consumer1 = new Consumer(q);
        try {
            producer.join();
            producer1.join();
            consumer1.join();
            consumer.join();

        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }

        System.out.println(consumer.getN());
        System.out.println(consumer1.getN());
    }
}
