package test01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
     

	public static void main(String[] args){
		Object[] params=new Object[1000];
		for(int i=0;i<params.length;i++){
			Integer value=i+1;
			InvocationHandler handler=new TraceHandler(value);
			Object proxy=Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
			params[i]=proxy;
			
		}
		Integer key=new Random().nextInt(params.length)+1;
		int result=Arrays.binarySearch(params, key);
		if(result>=0){
			System.out.println(params[result]);
		}
		
	}
	
}

class TraceHandler implements InvocationHandler{

	private Object target;//被代理的类
	public TraceHandler(Object t){
		target=t;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.print(target);
		System.out.print("."+method.getName()+"(");
		if(args!=null){
			for(Object a:args){
				System.out.print(a+",");
			}
			System.out.println(")");
		}
		return method.invoke(target, args);
	}
	
}
