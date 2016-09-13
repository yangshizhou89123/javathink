package concurrent.book;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
 * submit方法会产生FUTURE对象，他用Callable返回结果的特定类型进行了参数化。
 * 你可以用isDone来插叙future是否已经完成。
 * 当任务完成时，他具有一个结果，你可以调用get()方法来获取该结果。
 * get将阻塞，知道结果准备就绪。你还可以试图调用get来获取结果
 */
class TaskWithResult implements Callable<String>{
	private static int count = 0;
	private final int id = ++count;
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "#"+id+"(result)";
	}
	
}

public class CallableDemo  {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<String>> futures = new ArrayList<Future<String>>();
		for(int i=0;i<5;i++){
			futures.add(executorService.submit(new TaskWithResult()));
		}
		
		for(Future<String> future:futures){
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				executorService.shutdown();
			}
		}

	}
}
