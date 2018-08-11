package secondChapter.interview2;

/**
 * Recommended solution： 利用静态构造函数 
 */
public class Singleton4 {
	
	private Singleton4(){}
	
	private static Singleton4 instance = new Singleton4();
	
	public static Singleton4 getInstance(){
		return instance;
	}
}
