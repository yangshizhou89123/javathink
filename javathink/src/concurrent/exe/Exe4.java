package concurrent.exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe4 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i=5;i<10;i++){
			executorService.execute(new Exe2(i));
		}
		Thread.yield();
		executorService.shutdown();
		
		System.out.println("===============");
		
		executorService = Executors.newFixedThreadPool(5);
		for(int i=5;i<10;i++){
			executorService.execute(new Exe2(i));
		}
		Thread.yield();
		executorService.shutdown();
		System.out.println("===============");
		
		executorService = Executors.newSingleThreadExecutor();
		for(int i=5;i<10;i++){
			executorService.execute(new Exe2(i));
		}
		Thread.yield();
		executorService.shutdown();
		System.out.println("===============");
		
	}
}
