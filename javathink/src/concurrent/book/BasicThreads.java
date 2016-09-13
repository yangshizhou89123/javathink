package concurrent.book;
/*
 * 将Runnable对象变为工作任务的传统方式是把他提交给一个Thread对象的构造器。
 * 调用start为该线程执行必须的初始化操作。
 * 尽管start看起来是产生一个队长期运行方法的调用，但是从输出中可以看到，star迅速地返回了，
 */
public class BasicThreads {
	public static void main(String[] args) {
		Thread thread = new Thread(new LiftOff());
		thread.start();
		System.out.println("Waiting For Lift Off");
	}
}
