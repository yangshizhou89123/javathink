package concurrent.exe;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
 * 
 */
public class Exe6 implements Runnable{
	private static int count = 1;
	final int id = count++;
	private static Random rand = new Random();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int time = rand.nextInt(300); 
		try {
			TimeUnit.MILLISECONDS.sleep(time);
			System.out.println("#"+id+"ÀØ√ﬂ"+time+"∫¡√Î");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			executorService.execute(new Exe6());
		}
		Thread.yield();
		executorService.shutdown();
	}

}
