package secondChapter.interview2;

/**
 * a bad solution 1：只适用于单线程环境
 */
public class Singleton1 {

	/* 1.私有化构造函数
	 * 2.声明静态单例对象
	 * 3.编写创建单例的方法
	 */
	private Singleton1(){}
	
	private static Singleton1 instance;

	public static Singleton1 getInstance(){
		if(instance == null)
			instance = new Singleton1();
		return instance;
	}
}
