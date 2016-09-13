package concurrent.book;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
 * submit���������FUTURE��������Callable���ؽ�����ض����ͽ����˲�������
 * �������isDone������future�Ƿ��Ѿ���ɡ�
 * ���������ʱ��������һ�����������Ե���get()��������ȡ�ý����
 * get��������֪�����׼���������㻹������ͼ����get����ȡ���
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
