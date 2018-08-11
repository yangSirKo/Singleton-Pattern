package secondChapter.interview2;

/**
 * feasible solution: 双重检查锁定 + volatile 
 */
public class Singleton3 {

	/*
	 * 1.私有化构造函数
	 * 2.声明静态对象 ,需要用 volatile修饰，具体解释看解析文件
	 * 3.编写创建对象方法
	 */
	private Singleton3(){};
	
	private static volatile Singleton3 instance;
	private static Object obj = new Object();
	
	public static Singleton3 getInstance(){
		if(instance == null)
			synchronized(obj){
				if(instance == null)
					instance = new Singleton3();
			}
		return instance;
	}
}
