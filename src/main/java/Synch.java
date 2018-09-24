public class Synch {
    public static void main(String args[]){
        Callme target = new Callme();
        Caller ob1 = new Caller(target,"Hello");//创建新线程共享target对象
        Caller ob2 = new Caller(target,"Synchronized");//创建新线程共享target对象
        Caller ob3 = new Caller(target,"Word");//创建新线程共享target对象
        try{
            ob1.t.join();//等待线程调用结束
            ob2.t.join();//
            ob3.t.join();//
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
}