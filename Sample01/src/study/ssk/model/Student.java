package study.ssk.model;
/**
 * 生徒のモデルクラス
 * @author Irk-006
 *
 */
public class Student {
	private String name;		//名前
	private int age;			//年齢
	private String schoolYear;	//学年
	/* フィールドの可視性（アクセス修飾子）はすべてprivateとし、専用のメソッドでやり取りをする。 */
	
	//ゲッター（習得に使うメソッド）
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getSchoolYear() {
		return schoolYear;
	}
	
	//セッター（フィールドへの変更をするメソッド）
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean setSchoolYear(String schoolYear) {
		boolean check = false;
		int errorCount = 0;
		//正式な学年を格納するためのロジック
		if(schoolYear.length() == 3){
			char temp = schoolYear.charAt(0);	//一文字目
			if(!(temp >= '0' && temp <= '9')){	//文字コード上での0～9以内を判定
				errorCount++;	//エラー計上
			}
			
			temp = schoolYear.charAt(1);		//二文字目
			if(!(temp == '-')){
				errorCount++;	//エラー計上
			}
			
			temp = schoolYear.charAt(2);		//三文字目
			if(!((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z'))){	//文字コード上でのa～z、A～Z以内を判定
				errorCount++;	//エラー計上
			}
			
			if(errorCount == 0){	//最終判定
				this.schoolYear = schoolYear.toUpperCase();	//念の為小文字を大文字にして格納する
				check = true;
			} else {
				//ダメだった場合
				this.schoolYear = "unknown";
			}
		} else {	//そもそも３文字でない場合
			this.schoolYear = "unknown";
		}
		
		return check;
	}

	//自身の情報を出力する
	public void printStudent(){
		System.out.println("名前　：　" + this.name);
		System.out.println("年齢　：　" + this.age);
		System.out.println("学年　：　" + this.schoolYear);
	}
}
