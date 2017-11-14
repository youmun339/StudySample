package study.ssk.application;

import java.util.ArrayList;
import java.util.Scanner;

import study.ssk.model.Student;
import study.ssk.control.Judge;

public class StudyManagement {
	public static ArrayList<Student> studentList;		//生徒リスト　（javaではコレクションと言う）

	public void start() {
    	studentList = new ArrayList<>();	//空リストのインスタンスを生成
    	Scanner scan = null;				//キーボードの入力を受け取るのに使うクラス（標準クラス）
    	
    	while(true){
    		//画面表示
            System.out.println("生徒管理システム");
            System.out.println("1.生徒登録");
            System.out.println("2.生徒編集");
            System.out.println("3.生徒一覧");
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
            	Student newStudent = new Student();	//生徒のインスタンス生成
            	boolean retry = false;
            	while(!retry) {
            	
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
            	boolean checkinfo = true;	// 生徒の学年の設定の成功失敗を受け取る
            	// 設定に失敗かつ再設定を行う選択中
            	while(checkinfo) {
            	System.out.println("*学年は？　入力例：) 1-A、2-B等");
            	System.out.print(">");
            	buff = scan.nextLine();			//入力受け取り
            	checkinfo = newStudent.setSchoolYear(buff);	//生徒の学年を設定
            	
            	// 再設定ルート
            	if(!checkinfo) {
            		System.out.println("学年の設定に失敗しました。再設定しますか？");
            		//再設定の意思確認
            		checkinfo = Judge.judge(scan);
            	}
            	else {
            		// 正常に設定を行った場合は脱出
            		checkinfo = false;;
            	}
            	}
            	// TODO 真偽値を返す設計にしたので、本来は正常な学年の設定ができるまで繰り返すのが好ましい。
            	
            	System.out.println("以下の情報で登録します。\n");
            	newStudent.printStudent();
            	System.out.println("よろしいですか？");
            	retry = Judge.judge(scan);
            	}
            	//　TODO 確認させて、入力のし直しができると好ましい。
            	
            	studentList.add(newStudent);	//リストへ追加
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
            	if(num < 1 || num > studentList.size()){
            		System.out.println("入力された番号は存在しません");
            	} else {
                	System.out.println("入力を確認しました。");

                	Student changeStudent = studentList.get(num-1);	//取得
                	
                	System.out.println("生徒の変更を行います。");
                	System.out.println("");
                	
                	System.out.println("*名前は？");
                	System.out.print(">");
                	buff = scan.nextLine();		//入力受け取り
                	changeStudent.setName(buff);	//生徒の名前を設定
                	
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
                	changeStudent.setAge(newage);	//生徒の年齢を設定
                								//実質的にエラー時は0歳の生徒となる。

                	System.out.println("*学年は？　入力例：) 1-A、2-B等");
                	System.out.print(">");
                	buff = scan.nextLine();			//入力受け取り
                	changeStudent.setSchoolYear(buff);	//生徒の学年を設定

                	studentList.remove(num-1);
                	studentList.add(num-1, changeStudent);
                	System.out.println("変更が完了しました。");
            	}
            }
            
            /** 生徒一覧 */
            if(buff.equals("3")){
            	System.out.println("*** 生徒情報の一覧 ***\n");
            	
            	for (int i = 0; i < studentList.size(); i++){
            		System.out.println("No."+ (i+1));
            		Student temp = studentList.get(i);
            		temp.printStudent();
            		System.out.println("**********");
            	}
            	// TODO 登録されていない場合、登録されていない旨を表示したい。
            	
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
}