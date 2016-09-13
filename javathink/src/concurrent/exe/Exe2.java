package concurrent.exe;

import java.util.Arrays;

import Generic.book.Generator;

public class Exe2 implements Runnable,Generator<Integer>{
	private static int count = 0;
	private final int id = ++count;
	private int n;
	private int num;
	public Exe2(int n){
		this.n = n;
	}
	public int fib(int n){
		if(n<2) return 1;
		else return fib(n-2)+fib(n-1);
	}
	@Override
	public void run() {
		int[] seq = new int[n];
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++){
			seq[i] = get();
		}
		System.out.println("#"+id+"("+Arrays.toString(seq)+")");
	}
	public static void main(String[] args) {
		for(int i=5;i<10;i++){
			new Thread(new Exe2(i)).start();
		}
	}
	@Override
	public Integer get() {
		// TODO Auto-generated method stub
		return fib(num++);
	}

}
