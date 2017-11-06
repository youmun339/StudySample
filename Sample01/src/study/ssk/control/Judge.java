package study.ssk.control;

import java.util.Scanner;

public class Judge {
	
	/**
	 * Yes、Noの入力を行う
	 * Noが入力された場合にループ
	 * @author korota
	 * @return y:true n:false
	 */
	public static boolean judge() {
		Scanner input = null;
		String  yn    = "";			// 入力された文字列を格納する
		boolean check = true;		// YES/NOで入力された値を返す
		
		// yまたはnが入力された時点で終了
		while(true) {
			// 入力制御用
			input = new Scanner(System.in);
			System.out.println("y/nで入力してください");
			System.out.print(">");
			yn = input.nextLine();
			
			if(yn.equals("y")) {
				check = true;
				break;
			} else if(yn.equals("n")) {
				check = false;
				break;
			}
			
//			if(yn.equals("y") || yn.equals("n")) {
//				if(yn.equals("n")) {
//					check = false;
//				} else {
//					break;
//				}
//			}
		}
		input.close();		// 入力クラスをクローズ
		return check;
	}

}
