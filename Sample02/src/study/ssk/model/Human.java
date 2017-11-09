package study.ssk.model;

public class Human {
	private String name;		//名前
	private int age;			//年齢
	private String job;			//職業
	
	public Human(){
		name = "---";
		age = 0;
	}
	
	/** ゲッターセッター */
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getJob() {
		return job;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * 自身の表示を行う
	 */
	public void print(){
		System.out.println("職業　：　" + job);
		System.out.println("名前　：　" + name);
		System.out.println("年齢　：　" + age);
	}

}
