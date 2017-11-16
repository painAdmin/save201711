package test02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static  void main(String[] args){
		testSemaphore();
	}
	
	public static void testSemaphore(){
		ExecutorService exec=Executors.newCachedThreadPool();
		//设置信号量 同时执行的线程为5,::当初始化数值为1时就是二进制信号量，互斥锁
		final Semaphore sema=new Semaphore(1);
		// 模拟20个客户端访问
		for(int index=0;index<20;index++){
			final int NO=index;
			Runnable run=new Runnable(){

				@Override
				public void run() {
					try {
						//获取信号量许可
						//sema.acquire();
						System.out.println("Accessing :"+NO);
						System.out.println(Thread.currentThread().getName());
						//等待1秒
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally{
						//使用完释放信号量
					//	sema.release();
					}
					
				}
				
			};
			exec.execute(run);
		}
		exec.shutdown();
	}

}
