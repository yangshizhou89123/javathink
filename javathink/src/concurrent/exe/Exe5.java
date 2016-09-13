package concurrent.exe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import Generic.book.Generator;

public class Exe5 implements Callable<int[]>,Generator<Integer> {

	private static int count = 1;
	private final int id = count++;
	private int n;
	private int num = 1;
	public Exe5(int n) {
		// TODO Auto-generated constructor stub
		this.n = n;
	}
	public int fib(int n){
		if(n<2) return 1;
		else return fib(n-1)+fib(n-2);
	}
	@Override
	public int[] call() throws Exception {
		// TODO Auto-generated method stub
		int[] seq = new int[n];
		for(int i=0;i<n;i++){
			seq[i] = get();
		}
		System.out.println("#"+id+"完成任务");
		return seq;
	}
	@Override
	public Integer get() {
		// TODO Auto-generated method stub
		return fib(num++);
	}
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<int[]>> list = new ArrayList<Future<int[]>>();
		for(int i=5;i<10;i++){
			list.add(executorService.submit(new Exe5(i)));
		}
		Thread.yield();
		executorService.shutdown();
		for(Future<int[]> future: list){
			try {
				System.out.println(Arrays.toString(future.get()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
