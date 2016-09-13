package concurrent.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
 * 让步，
 * 如果知道已经完成了run方法的循环的一次迭代过程中需要的工作，就可以给线程调度机制一个桉树
 * 你的工作已经做到差不多了，可以让别的线程使用CPU了。这个暗示将通过调研yield()方法来做出，
 * 当调用yield()
 */
public class SleepingTask  extends LiftOff{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(countDown-->0){
				System.out.println(status());
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("#"+id+"中断");
		}
		
	}
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			executorService.execute(new SleepingTask());
		}
		Thread.yield();
		executorService.shutdown();
		
	}
}
