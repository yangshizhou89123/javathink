package concurrent.exe;

public class Exe1 implements Runnable{
	private static int count = 0;
	private final int id = ++count;
	private String start;
	private String end;
	public Exe1(String start,String end){
		System.out.println("#"+id+"("+start+")");
		this.end = end;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++){
			System.out.println("#"+id+"("+i+")");
			Thread.yield();
		}
		System.out.println("#"+id+"("+end+")");
	}
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new Thread(new Exe1("¿ªÊ¼", "½áÊø")).start();
		}
	}
}
