package concurrent.exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exe3_FixThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			executorService.execute(new Exe1("¿ªÊ¼", "½áÊø"));
		}
		executorService.shutdown();
	}
}	
