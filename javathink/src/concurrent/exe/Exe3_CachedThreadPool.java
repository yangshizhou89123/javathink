package concurrent.exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe3_CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exService = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exService.execute(new Exe1("¿ªÊ¼", "½áÊø"));
		}
		exService.shutdown();
	}
}
