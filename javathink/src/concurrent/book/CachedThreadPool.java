package concurrent.book;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * ִ������Ϊ�����Thread����
 * Executor����������첽�����ִ�У���������ʾ�ع����̵߳���������
 * shutdown()��ֹ�������ύ
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
