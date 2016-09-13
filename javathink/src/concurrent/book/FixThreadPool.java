package concurrent.book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * fixedThreadPool
 * �ŵ㣺һ����Ԥ��ִ�д��۸߰����̷߳��䣬���Ҳ�Ϳ��Ը������̵߳�����������Խ�ʡʱ��
 * ���¼�������ϵͳ�У���Ҫ�̵߳��¼���������ͨ��ֱ�Ӵӳ��л�ȡ�̣߳�Ҳ����������Ը�ؾ���õ������㲻�����ÿɻ�õ���Դ��
 * ���κ��̳߳��У������߳��ڿ��ܵ�����£����ᱻ�Զ�����
 */
public class FixThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i=0;i<5;i++){
			executorService.execute(new LiftOff());
		}
		executorService.shutdown();
	}
}
