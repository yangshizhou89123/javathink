package concurrent.book;

import java.util.concurrent.TimeUnit;

/*
 * ��ν��̨�̣߳���ָ�ڳ������е�ʱ���ں�̨�ṩһ��ͨ�÷�����̡߳�
 * ���������̲߳������ڲ��ɻ�ȱ�Ĳ��֣���ˣ������еķǺ�̨�߳̽���ʱ������Ҳ�ͽ���
 * ͬʱɱ�������е����к�̨�̡߳�������˵��ֻҪ���κηǺ�̨�̻߳������У�����Ͳ�����ֹ
          �������߳�����֮ǰ����setD���������ܰ������ó�Ϊ��̨�߳�
    
 */
public class SimpleDaemons implements Runnable{
	private static int count = 0;
	final int id = ++count;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("#"+id+"(��̨����)");
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
		System.out.println("���߳��˳�");
	}

}
