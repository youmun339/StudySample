package study.ssk.control;

import java.util.Scanner;

public class Judge {
	
	// YES/NOの確認を行うだけのメソッド
	public static boolean judge() {
		Scanner input = null;
		String  yn    = "";			// 入力された文字列を格納する
		boolean check = true;		// YES/NOで入力された値を返す
		
		
		// yまたかnが入力された時点で終了
		while(check) {
			// 入力制御用
			input = new Scanner(System.in);
			System.out.println("y/nで入力してください");
			System.out.print(">");
			yn = input.nextLine();
			
			if(yn.equals("y") || yn.equals("n")) {
				if(yn.equals("n")) {
					check = false;
				}else {
					break;
					}
			}
		}
		input.close();		// 入力クラスをクローズ
		return check;
	}

}
