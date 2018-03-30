package test03;
/**
 * 死锁 案例
 * @author pain
 *
 */
public class Test {
    
	private static Object lockA=new Object();

	public static void main(String[] args) {
	
		Runnable task=new Runnable(){

			@Override
			public void run() {
				synchronized(lockA){
					System.out.println("线程"+Thread.currentThread()+" 正在运行 ");
				
				
					long start=System.currentTimeMillis();
				    long end=System.currentTimeMillis();
				
					
					
					while((end-start)<=60*5*1000){
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						end=System.currentTimeMillis();
					}
				}
			}
			
		};
		Thread t1=new Thread(task);
		Thread t2=new Thread(task);
		t1.start();
		t2.start();
		
	}

}
