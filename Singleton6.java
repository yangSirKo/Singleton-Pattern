package secondChapter.interview2;

/**
 * Strongly Recommended Solution: 枚举单例，代码十分简洁。
 */
public enum Singleton6 {
	
	Instance;

	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
}
