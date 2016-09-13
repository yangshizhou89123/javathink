package concurrent.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DaemonThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(r);
		thread.setDaemon(true);
		return thread;
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<3;i++){
			executorService.execute(new SimpleDaemons());
		}
		executorService.shutdown();
		TimeUnit.SECONDS.sleep(3);
		System.out.println("主线程退出");
	}

}
