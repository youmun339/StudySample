package study.ssk.control;

import java.util.Scanner;

public class Judge {
	
	/**
	 * Yes、Noの入力を行う
	 * Noが入力された場合にループ
	 * @author korota
	 * @return y:true n:false
	 */
	public static boolean judge(Scanner input) {
		String  yn    = "";			// 入力された文字列を格納する
		boolean loop  = true;		// ループ用
		boolean check = true;		// YES/NOで入力された値を返す
		
		// yまたはnが入力された時点で終了
		while(loop) {
			// 入力制御用
			System.out.println("y/nで入力してください");
			System.out.print(">");
			yn = input.nextLine();
			
			switch(yn) {
			case "Y":
			case "y":
				loop = false;	// ループから脱出
				break;
			case "N":
			case "n":
				check = false;	// 入力がNO
				loop  = false;	// ループからの脱出
				break;
				default :
					break;		// 聞きなおし
			}
		}
		return check;
	}

}
