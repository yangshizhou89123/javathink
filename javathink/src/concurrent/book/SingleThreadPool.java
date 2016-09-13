package concurrent.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * �������ϣ������һ���߳����������е��κ�������˵�����Ǻ����õġ�
 * �������������׽������ӵ�����
 * ����ϣ�����߳������еĶ�����Ҳͬ���ܷ���
 * ���±��ػ�Զ����־��С����
 * 
 * ��Ϊ��һ��ʵ�����������д������̣߳����������е�����ʹ���ļ�ϵͳ
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
