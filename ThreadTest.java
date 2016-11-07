/**
 * Created by devin on 2016/11/7.
 */
public class ThreadTest1 implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    public ThreadTest1(String name, Object prev, Object self){
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int i = 10;
        while (i>0){
            synchronized (prev){
                synchronized (self){
                    System.out.print(name);
                    i--;
                    self.notify();
                }
                try {
                    prev.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        ThreadTest1 th1 = new ThreadTest1("A", c, a);
        ThreadTest1 th2 = new ThreadTest1("B", a, b);
        ThreadTest1 th3 = new ThreadTest1("C", b, c);

        new Thread(th1).start();
        Thread.sleep(100);
        new Thread(th2).start();
        Thread.sleep(100);
        new Thread(th3).start();
        Thread.sleep(100);
    }
}
