package concurrent.book;
/*
 * �������Ļ������ж�����������̵߳�������������Щ������֮��ĬĬ�طַ��̡߳�
 * ��mian����Thread����ʱ������û�в����κζ���Щ��������á�
 * �����������˳�run��������֮ǰ�������������޷��������
 */
public class MoreBasicThreads {
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting For Lift Off");
	}
}
