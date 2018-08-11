package secondChapter.interview2;

/**
 * strongly recommended solution: 基于类初始化的解决方案
 *
 */
public class Singleton5 {
	
	private static class Nested{
		public static Singleton5 Instance = new Singleton5(); 
	}
	
	public static Singleton5 getInstance(){
		return Nested.Instance;
	}

}
