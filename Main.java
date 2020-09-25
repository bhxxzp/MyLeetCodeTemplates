package template;
import java.util.*;
public class Main{
    private String[] set = {"A", "B", "C"};
    private int current = 0;
    private int times;
    public Main(int n) {
        this.times = n;
    }
    
    public class output implements Runnable{
        private int index;
        
        public output(int i) {
            this.index = i;
        }
        
        @Override
        public void run() {
            try{
                for (int i = 0; i < times; i++) {
                    synchronized (set) {
                        Thread.sleep(1000);
                        System.out.print(set[this.index]);
                        current = (current + 1) % set.length;
                        set.notifyAll();
                    }
                }
            } catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    public static void main(String[] args) {
        System.out.println("输入您想输出“ABC”几次");
        Scanner in = new Scanner(System.in);
        int times = Integer.parseInt(in.nextLine());
        
        Main sol = new Main(times);
        for (int i = 0; i < 3; i++) {
            new Thread(sol.new output(i)).start();
        }
    }
}