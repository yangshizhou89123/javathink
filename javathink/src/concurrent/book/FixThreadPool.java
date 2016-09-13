package concurrent.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * fixedThreadPool
 * 优点：一次性预先执行代价高昂的线程分配，因而也就可以跟限制线程的数量。这可以节省时间
 * 在事件驱动的系统中，需要线程的事件处理器，通过直接从池中获取线程，也可以如你所愿地尽快得到服务。你不会滥用可获得的资源。
 * 在任何线程池中，现有线程在可能的情况下，都会被自动复用
 */
public class FixThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i=0;i<5;i++){
			executorService.execute(new LiftOff());
		}
		executorService.shutdown();
	}
}
