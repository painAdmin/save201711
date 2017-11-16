package test01;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 * 优先级队列---堆（heap）  每次的从堆中移除的元素一定是优先级数量最小的的
 * @author pain
 *
 */
public class PriorityQueueDemo {

	public static void main(String[] args) {
		
//        SortedSet<String> sorter=new TreeSet<String>();
//        sorter.add("aa");
//        sorter.add("bb");
//        sorter.add("cc");
//        System.out.println(sorter);
		
		PriorityQueue<GregorianCalendar> pq=new PriorityQueue<>();
		pq.add(new GregorianCalendar(1960,Calendar.DECEMBER,9));
		pq.add(new GregorianCalendar(1815,Calendar.DECEMBER,10));
		pq.add(new GregorianCalendar(1903,Calendar.DECEMBER,3));
		pq.add(new GregorianCalendar(1910,Calendar.JUNE,22));
		
		System.out.println("Iterator over elements.....");
		for(GregorianCalendar date:pq){
			System.out.println(date.get(Calendar.YEAR));
		}
		System.out.println("Removing elements....");
		while(!pq.isEmpty()){
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
	}
/**
 * 链接映射表和链接散列集
 * LinkedHashMap  和 LinkedHashSet
 * 
 * LinkedHahsMap:用户访问顺序，而不是插入顺序，每次调用get和put 方法受影响的条目将从 当前的位置删除，并将条目放到链表的尾部
 * 作用：一般用于高速缓存，“最近最少使用”原则
 * 例如：访问高频率的可以放到内存 中，低频率的放到数据库中读取，当在表中找不到元素项且表又被沾满的时候，
 *     可以用迭代器枚举前几个元素，这几个元素就是近期最少使用的几个元素
 * 
 */
	public static void LinkedHashMapDemo(){
	
	}
}
