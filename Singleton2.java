package secondChapter.interview2;

/**
 * a bad solution 2: 虽然在多线程环境中能工作，但效率不高
 */
public class Singleton2 {

	/*
	 * 1.私有化构造函数
	 * 2.创建静态成员对象
	 * 3.编写创建方法，加锁获取对象
	 */
	private Singleton2(){}
	
	private static Singleton2 instance;

	private static Object obj = new Object();
	
	public static Singleton2 getInstance(){
		
		synchronized(obj){
			if(instance == null)
				instance = new Singleton2();
		}
		return instance;
	}
	
}
