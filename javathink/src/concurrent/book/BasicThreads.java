package concurrent.book;
/*
 * ��Runnable�����Ϊ��������Ĵ�ͳ��ʽ�ǰ����ύ��һ��Thread����Ĺ�������
 * ����startΪ���߳�ִ�б���ĳ�ʼ��������
 * ����start�������ǲ���һ���ӳ������з����ĵ��ã����Ǵ�����п��Կ�����starѸ�ٵط����ˣ�
 */
public class BasicThreads {
	public static void main(String[] args) {
		Thread thread = new Thread(new LiftOff());
		thread.start();
		System.out.println("Waiting For Lift Off");
	}
}
