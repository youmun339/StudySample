package study.ssk.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import study.ssk.model.Human;
import study.ssk.model.Student;
import study.ssk.model.Teacher;
import study.ssk.utility.ApplicationValues;

public class StudyManagement {
	public static List<Human> userList;		//名簿リスト　（javaではコレクションと言う）
	public static Scanner scan;				//キーボードの入力を受け取るのに使うクラス（標準クラス）

	public void start() {
    	userList = new ArrayList<>();		//空リストのインスタンスを生成
    	
    	while(true){
    		//画面表示
            System.out.println("名簿管理システム");
            System.out.println("1.名簿登録");
            System.out.println("2.情報編集");
            System.out.println("3.名簿一覧");
            System.out.println("4.終了");
            
            //入力制御
            scan = new Scanner(System.in);
        	String buff = "";					//入力を受け取る変数（一時的領域）
            boolean loop = true;
            while(loop){
            	System.out.print(">");
                buff = scan.nextLine();	//キーボード入力を受け取る
                switch (buff) {
                case "1" :
                case "2" :
                case "3" :
                case "4" :
                	loop = false;	//抜ける
                	break;
                default :
                	System.out.println("1～4 を入力してください。");
                	break;
                }
            }
            
            /** 生徒登録 */
            if(buff.equals("1")){
            	System.out.println("名簿登録を行います。");
            	Human newUser = userInput();
            	userList.add(newUser);
            	System.out.println("登録が完了しました。");
            }
            
            /** 生徒変更 */
            if(buff.equals("2")){
            	int num = 0;						//変更対象
            	System.out.println("生徒情報を変更します。");
            	while(true){
                	System.out.println("変更したい生徒の番号を入力して下さい。");
                	System.out.print(">");
                	buff = scan.nextLine();
                	
                	//入力チェック
                	try {
                		num = Integer.parseInt(buff);	//Stringの数値をintに変更
                		break;
                	} catch (Exception e) {
                		//入力されたのが数値以外でエラーしても特に何もしない。
                	}
                	//エラーメッセージ
            		System.out.println("不正な値です。");
            		System.out.println("入力のやり直しをお願いします。");
            	}
            	
            	if(num < 0 || num > userList.size()){
            		System.out.println("入力された番号は存在しません");
            	} else {
                	System.out.println("入力を確認しました。");
                	buff = "";

                	Human changeUser = userInput();

                	userList.remove(num-1);
                	userList.add(num-1, changeUser);
                	System.out.println("変更が完了しました。");
            	}
        		buff = "";	//初期化
            }
            
            /** 生徒一覧 */
            if(buff.equals("3")){
            	System.out.println("*** 生徒情報の一覧 ***\n");
            	if(userList.size() > 0){
                	for (int i = 0; i < userList.size(); i++){
                		System.out.println("No."+ (i+1));
                		Human temp = userList.get(i);
                		temp.print();
                		System.out.println("**********");
                	}
            	} else {
            		System.out.println("登録されていません。");
            	}
        		buff = "";	//初期化
            }
            
        	System.out.println("");	//表示調整

            /** 終了 */
            if(buff.equals("4")){
            	System.out.println("終了します。");
            	System.gc();	//ガーベッジコレクション（Javaでは気持ち程度）
            	break;
            }
    	}
        scan.close();		//入力クラスをクローズ（絶対やろう）
        System.exit(0);		//ここで終了させる
    }
	
	/**
	 * ユーザー登録を行う
	 * @param type
	 * @return 登録データ
	 */
	public Human userInput(){
		String buff = "";		//入力用
		int jobcode = 0;
		Human newUser = null;	//返却用データ
		
    	while(true){
        	System.out.println("*************************");
        	System.out.println("* 選択可能な職業");
        	System.out.println("*************************");
        	System.out.println("* " + ApplicationValues.Code_Student + " : " + ApplicationValues.Num_001 );
        	System.out.println("* " + ApplicationValues.Code_Teacher + " : " + ApplicationValues.Num_002 );
        	System.out.println("*************************");
        	System.out.println("入力対象の職業を選択して下さい。");
        	System.out.print(">");
        	buff = scan.nextLine();
        	
        	//入力チェック
        	try {
        		jobcode = Integer.parseInt(buff);
        		if(jobcode == ApplicationValues.Code_Student || jobcode == ApplicationValues.Code_Teacher){
        			break;
        		}
        	} catch (Exception e) {}			//入力されたのが数値以外でエラーしても特に何もしない。
        	//エラーメッセージ
    		System.out.println("不正な値です。正しい数値を入力して下さい。");
    	}

		
		if(jobcode == ApplicationValues.Code_Student){
			//生徒情報登録
			Student newStudent = new Student();
	    	while(true){
	        	System.out.println("生徒の登録を行います。");
	        	System.out.println("");
	        	
	        	System.out.println("*名前は？");
	        	System.out.print(">");
	        	buff = scan.nextLine();		//入力受け取り
	        	newStudent.setName(buff);	//生徒の名前を設定
	        	
	        	System.out.println("*年齢は？");
	        	System.out.print(">");
	        	buff = scan.nextLine();		//入力受け取り
	        	
	        	//数値変換
	        	int newage = 0;
	        	try {
	        		newage = Integer.parseInt(buff);	//文字型から数値型に変更
	        	} catch (Exception e){
	        		//入力されたのが数値以外でエラーしても特に何もしない。
	        	}
	        	newStudent.setAge(newage);	//生徒の年齢を設定
	        								//実質的にエラー時は0歳の生徒となる。

	        	while(true){
	            	System.out.println("*学年は？　入力例：) 1-A、2-B等");
	            	System.out.print(">");
	            	buff = scan.nextLine();			//入力受け取り
	            	if(newStudent.setSchoolYear(buff)){//生徒の学年を設定
	            		break;
	            	}
	        		System.out.println("正しい学年を設定して下さい。（半角英数字、ハイフンで 1-A、2-B 等）");
	        	}
	        	
	        	System.out.println("以下の情報で登録します。\n");
	        	newStudent.print();
	        	
	        	//　最終確認、再入力判定
	        	System.out.println("本当によろしいですか？ y/n");
	        	System.out.print(">");
	        	buff = scan.nextLine();			//入力受け取り
	        	
	        	if("y".equals(buff) || "Y".equals(buff)){
	            	break;
	        	}
	        	System.out.println("再度入力します。");
	    	}
	    	newUser = newStudent;
		} else if (jobcode == ApplicationValues.Code_Teacher) {
			//講師情報登録
			Teacher newTeacher = new Teacher();
	    	while(true){
	        	System.out.println("講師の登録を行います。");
	        	System.out.println("");
	        	
	        	System.out.println("*名前は？");
	        	System.out.print(">");
	        	buff = scan.nextLine();		//入力受け取り
	        	newTeacher.setName(buff);	//生徒の名前を設定
	        	
	        	System.out.println("*年齢は？");
	        	System.out.print(">");
	        	buff = scan.nextLine();		//入力受け取り
	        	
	        	//数値変換
	        	int newage = 0;
	        	try {
	        		newage = Integer.parseInt(buff);	//文字型から数値型に変更
	        	} catch (Exception e){
	        		//入力されたのが数値以外でエラーしても特に何もしない。
	        	}
	        	newTeacher.setAge(newage);	//生徒の年齢を設定
	        								//実質的にエラー時は0歳の生徒となる。

	        	while(true){
	            	System.out.println("*担当クラスは？　入力例：) 1-A、2-B等");
	            	System.out.print(">");
	            	buff = scan.nextLine();			//入力受け取り
	            	if(newTeacher.setClassInCharge(buff)){//生徒の学年を設定
	            		break;
	            	}
	        		System.out.println("正しい学年を設定して下さい。（半角英数字、ハイフンで 1-A、2-B 等）");
	        	}
	        	
	        	System.out.println("以下の情報で登録します。\n");
	        	newTeacher.print();
	        	
	        	//　最終確認、再入力判定
	        	System.out.println("本当によろしいですか？ y/n");
	        	System.out.print(">");
	        	buff = scan.nextLine();			//入力受け取り
	        	
	        	if("y".equals(buff) || "Y".equals(buff)){
	            	break;
	        	}
	    	}
	    	newUser = newTeacher;
		}
		return newUser;
	}
}