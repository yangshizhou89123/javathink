package concurrent.book;
/*
 * 如果在你的机器上有多个处理器，线程调度器将会在这些处理器之间默默地分发线程。
 * 当mian创建Thread对象时，他并没有捕获任何对这些对象的引用。
 * 在他的任务退出run并且死亡之前，垃圾回收器无法清除它，
 */
public class MoreBasicThreads {
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting For Lift Off");
	}
}
