package concurrent.book;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 执行器将为你管理Thread对象
 * Executor允许你管理异步任务的执行，而无须显示地管理线程的生命周期
 * shutdown()防止新任务提交
 */
public class CachedThreadPool  {
	public static void main(String[] args) {
		ExecutorService exService = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exService.execute(new LiftOff());
		}
		exService.shutdown();
	}
}
