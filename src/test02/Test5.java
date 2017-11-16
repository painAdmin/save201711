package test02;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test5 {

	public static void main(String[] args) throws InterruptedException{
//		List<String> list=new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		//list.forEach((String e) ->System.out.println(e));
//		list.sort((e1,e2)->e1.compareTo(e2));
		final Clock clock=Clock.systemUTC();
		System.out.println(clock.instant());
		System.out.println(clock.millis());
		
	}

	public static void test(){
		ExecutorService threadPool=Executors.newCachedThreadPool();
		//ExecutorService threadPool=Executors.newFixedThreadPool(2);
		for(int i=0;i<20;i++){
			Task t=new Task();
			threadPool.execute(t);
		}
		System.out.println();
		
		
	}
}
class Task implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在运行!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
	}
	
}