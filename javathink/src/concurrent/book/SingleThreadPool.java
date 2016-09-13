package concurrent.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 这对于你希望在另一个线程中连续运行的任何事物来说，都是很有用的。
 * 例如监听进入的套接字连接的任务
 * 对于希望在线程中运行的短任务也同样很方便
 * 更新本地或远程日志的小人物
 * 
 * 作为另一个实例，假设你有大量的线程，那他们运行的任务将使用文件系统
 */
public class SingleThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			executorService.execute(new LiftOff());
		}
		executorService.shutdown();
	}
}
