public class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;
    public  Caller(Callme targ,String s){
        target =  targ;
        msg = s;
        t = new Thread(this);//
        t.start();//线程开始
    }
    public void run() {//实现接口Runnable的run方法
        target.call(msg);
    }
}
