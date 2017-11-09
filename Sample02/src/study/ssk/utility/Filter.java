package study.ssk.utility;

public class Filter {
	
	/**
	 * 学年の記述をチェックする
	 * 1-A、2-B等を想定
	 * @param schoolYear
	 * @return　正true 誤false
	 */
	public static boolean checkSchoolYear(String schoolYear){
		boolean check = false;
		int errorCount = 0;
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
				check = true;
			}
		}
		return check;
	}

	/**
	 * 職業名から職業コードを返す
	 * @return エラー:-1 , 一致無し:0 , 正常:1~
	 */
	public static int getJobTypeCode(String jobName){
		int jobCode = 0;
		if(jobName != null){
			try {
				if(ApplicationValues.Num_001.equals(jobName)){	//生徒パターン
					jobCode = ApplicationValues.Code_Student;
				}
				if(ApplicationValues.Num_002.equals(jobName)){	//講師パターン
					jobCode = ApplicationValues.Code_Teacher;
				}
			} catch (Exception e) {
				jobCode = -1;
			}
		}
		return jobCode;
	}
}
