package concurrent.book;

import java.util.concurrent.TimeUnit;

/*
 * 所谓后台线程，是指在程序运行的时候在后台提供一种通用服务的线程。
 * 并且这种线程并不属于不可或缺的部分，因此，当所有的非后台线程结束时，程序也就结束
 * 同时杀死进程中的所有后台线程。反过来说，只要有任何非后台线程还在运行，程序就不会终止
          必须在线程启动之前调用setD方法，才能把它设置成为后台线程
    
 */
public class SimpleDaemons implements Runnable{
	private static int count = 0;
	final int id = ++count;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("#"+id+"(后台运行)");
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<3;i++){
			Thread thread = new Thread(new SimpleDaemons());
			thread.setDaemon(true);
			thread.start();
		}
		TimeUnit.SECONDS.sleep(2);
		System.out.println("主线程退出");
	}

}
