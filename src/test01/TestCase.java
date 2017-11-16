package test01;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class TestCase {

	public static void main(String[] args){
		Student s1=new Student();
		Student s2=new Student(12);
		System.out.println(s1.getName());
		System.out.println(s2.getName());
		
	}
	enum Size{L,M,XL,XXL};
}
