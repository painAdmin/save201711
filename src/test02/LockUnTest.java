package test02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁和非公平锁ReentrantLock(isFair)(true 公平， false 非公平)
 * @author pain
 *
 */
public class LockUnTest {

	public static void main(String[] args){
		final Service service=new Service(true);
		Runnable runnable=new Runnable(){

			@Override
			public void run() {
			System.out.println("**线程："+Thread.currentThread().getName()+"运行了");
				service.ServiceMethod();
			}
			
		};
		Thread[] threadArray=new Thread[10];
		for(int i=0;i<10;i++){
			threadArray[i]=new Thread(runnable);
		}
		for(int i=0;i<10;i++){
			threadArray[i].start();
		}
	}
}
class Service{
	private ReentrantLock lock;
	public Service(boolean isFair){
		lock=new ReentrantLock(isFair);
	}
	public void ServiceMethod(){
		try{
			lock.lock();
    		System.out.println("ThreadName="+Thread.currentThread().getName()+"获取锁定");
		}finally{
			lock.unlock();
		}
		
	}
}