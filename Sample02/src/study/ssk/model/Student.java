package study.ssk.model;

import study.ssk.utility.ApplicationValues;
import study.ssk.utility.Filter;

/**
 * 生徒のモデルクラス
 * @author Irk-006
 *
 */
public class Student extends Human{
	private String classIn;	//学年
	
	public Student(){
		super();
		super.setJob(ApplicationValues.Num_001);
		this.classIn = "---";
	}

	/** ゲッターセッター */
	public String getSchoolYear() {
		return classIn;
	}
	public boolean setSchoolYear(String schoolYear) {
		boolean check = Filter.checkSchoolYear(schoolYear);
		if(check){
			this.classIn = schoolYear.toUpperCase();	//全て大文字に
		} else {
			this.classIn = "unknown";
		}
		return check;
	}

	/**
	 * 生徒情報の表示を行う
	 */
	public void print(){	//オーバーライド
		super.print();
		System.out.println("学年　：　" + this.classIn);
	}

}
