package test01;

import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyT {

	public static void main(String[] args){
		Object[] params=new Object[100];
		for(int i=0;i<params.length;i++){
			Integer in=i+1;
			InvocationHandler handler=new TraceHandler01(in);
			Object proxyIn=Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
			assert (int)proxyIn < 0:proxyIn;//断言
			params[i]=proxyIn;
		}
		Integer key=new Random().nextInt(100)+1;
		int index=Arrays.binarySearch(params, key);
		System.out.println(index);
	}
	
}

 class TraceHandler01 implements InvocationHandler{
	 Object target;
	 public TraceHandler01(Object t){
		 this.target=t;
	 }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(target, args);
	}

	
	 
 }
