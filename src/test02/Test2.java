package test02;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Test2 {

	public static void main(String[] args) {
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("id", 0);
//		map.put("name", "test");
//		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
//		list.add(map);
//		for(Map<String,Object> m:list){
//			String id=m.get("id").toString();
//			System.out.println(id);
//		}
//		Integer id=(Integer)map.get("id");
//		System.out.println(id);
		
//		String str="192";
//		int a=(byte)Integer.parseInt(str);
//		//BigInteger num=BigInteger.valueOf(2130706433);
//		BigInteger num=BigInteger.ONE;
//		String os=System.getProperty("os.name");
//		System.out.println(a);
//		System.out.println(num);
//		String regex="^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])((\\\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])){3}|(\\\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])){5})$";
//		String ip="10.0.0.1";
		String salt="c647bdfcbdd94a8781de8d8760a65e06";
		System.out.println("admin123!"+salt);
	}

}
