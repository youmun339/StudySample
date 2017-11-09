package study.ssk.model;

import study.ssk.utility.ApplicationValues;
import study.ssk.utility.Filter;

/**
 * 先生モデルクラス
 * @author Irk-006
 *
 */
public class Teacher extends Human {
	String classInCharge = "";		//担当クラス
	
	public Teacher(){
		super();
		super.setJob(ApplicationValues.Num_002);
		this.classInCharge = "未担当";
	}

	/** ゲッターセッター */
	public String getClassInCharge() {
		return classInCharge;
	}

	public boolean setClassInCharge(String classInCharge) {
		boolean check = Filter.checkSchoolYear(classInCharge);
		if(check){
			this.classInCharge = classInCharge.toUpperCase();	//全て大文字に
		} else {
			this.classInCharge = "未担当";
		}
		return check;
	}
	
	/**
	 * 講師情報の表示を行う
	 */
	public void print(){	//オーバーライド
		super.print();
		System.out.println("担当学年　：　" + this.classInCharge);
	}
}
