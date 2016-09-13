package concurrent.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
 * �ò���
 * ���֪���Ѿ������run������ѭ����һ�ε�����������Ҫ�Ĺ������Ϳ��Ը��̵߳��Ȼ���һ������
 * ��Ĺ����Ѿ���������ˣ������ñ���߳�ʹ��CPU�ˡ������ʾ��ͨ������yield()������������
 * ������yield()
 */
public class SleepingTask  extends LiftOff{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(countDown-->0){
				System.out.println(status());
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("#"+id+"�ж�");
		}
		
	}
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			executorService.execute(new SleepingTask());
		}
		Thread.yield();
		executorService.shutdown();
		
	}
}
