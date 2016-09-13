package concurrent.book;

public class LiftOff implements Runnable{
	protected int countDown = 10;
	private static int count = 0;
    final int id = count++;
	
	public LiftOff(){}
	public LiftOff(int countDown){this.countDown = countDown;}
	
	public String status(){
		return "#"+id+"("+(countDown>0?countDown:"Lift OFF")+")";
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(countDown-->0){
			System.out.println(status());
			Thread.yield();
		}
	}

}
