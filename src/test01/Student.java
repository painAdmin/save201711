package test01;

public class Student {

	private String name;
	private int age;
	private double sal;
	
	{
		name="ceshi";
		age=123;
		sal=234;
	}
	
	public Student(){
		
	}
	public Student(int age){
		name="t";
		age=12;
		sal=34343;
		
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sal=" + sal + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
}
