public class Callme {
      synchronized void call (String msg){//同步，call方法可能被多个线程调用，希望每个线程在某一时刻锁定并执行完call方法后，其他线程再调用它
        System.out.print("["+msg);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e ){
            System.out.println("Interrupted");
        }
        System.out.print("]");
        System.out.println();
    }
}
