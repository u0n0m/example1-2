package com.silentpeople.ex1_2;

import java.util.Scanner;

public class calculatorMain {
	
	public static String inputValCheck(String inputVal ){
		inputVal = inputVal.replace(" ", "");
		return inputVal;
	}
	
	public static boolean startWithNotNumeric(String inputVal) {
		boolean a1 = inputVal.startsWith("-");
		return a1;
	}
	
	public static String[] splitWithSign(String inputVal) {
		 String[] a1 = inputVal.split("[\\+\\-\\*\\/\\=]");
		 return a1;
	}
	
	public static int[] StringArrToInterArr(String [] splitValues) {
		int [] num = new int[10];
		for(int cnt=0; cnt<splitValues.length;cnt++){
			try{
				num[cnt] = Integer.parseInt(splitValues[cnt]);
			}catch(java.lang.NumberFormatException e){
	               System.out.println("입력범위 초과: -2147483648~2147483647");
			}
		}
		return num;
		
	}
	
	public static char PopSign(String inputVal) {
		String [] signArray = {"+", "-","*","/"};
		char sign = '+';
		for(int cnt=0;cnt<signArray.length;cnt++){
			int signOrder = inputVal.indexOf(signArray[cnt]);
			if(signOrder < 0){
				continue;
			}
			sign = inputVal.charAt(signOrder);
		}
		return sign;
	}
	
	public static boolean blockDivideByZero(int num, char sign) {
		if(num == 0 && sign == '/') {
			System.out.println("0으로 나누기는 불가능합니다. 다시 입력해주세요!!");
			return true; //0으로 나누는 상황: true, 아니면: false
		}
		else{
			return false;
		}
	}
	
	
	public static void main(String [] args ) {
		String inputVal;
		String YesOrNo;
		boolean yesno=true;
		
		do{
			//for(int i=0;i<50;i++) System.out.println(" ");
			System.out.println("Input:");
			Scanner scan = new Scanner(System.in);
			inputVal = scan.nextLine();
			
			inputVal = inputValCheck(inputVal); //곻백제거
			
			if(startWithNotNumeric(inputVal)){ // 숫자를 제외한 기호로 시작하면 true를 반환하는 메소드
				// 첫번째 입력되는 수는 음수를 지원하지 않는다.
				System.out.println("음수는 입력되지 않습니다.");
				continue;
			}
			
			String [] splitValues = splitWithSign(inputVal); // 문자열을 지정된 패턴으로 잘라서 배열로 반환하는 메소드
			
			//int [] num = new int[splitValues.length];
			int [] num = StringArrToInterArr(splitValues);//문자열 배열을 정수 배열로 바꾸는 코드 블럭
			
			//연산기호를 추출하는 코드 블럭
			char sign = PopSign(inputVal);
			
			//0으로 나누기를 방지하기 위한 코드 블록
			if(blockDivideByZero(num[1], sign) ) {
				continue;
			}
			
			long result=0;
			double result2=0.0;
			switch(sign){
			case '+':
				result = (long)num[0]+(long)num[1];
				System.out.println(result);
				break;
			case '-':
				result = (long)num[0]-(long)num[1];
				System.out.println(result);
				break;
			case '*':
				result = (long)num[0]*(long)num[1];
				System.out.println(result);
			case '/':
				result2 = (double)num[0] / (double)num[1];
				System.out.println(result2);
				break; 
			default:
				break;
			}
			System.out.println("yes(y) or no(n)");
			YesOrNo = scan.nextLine();
			
			switch(inputVal){
			case "y": case "Y":
				yesno=true;
				continue;
			case "n": case "N":
				yesno=false;
				break;
			default:
				break;
			}
			
		}while( yesno );	
		System.out.println("종료되었습니다.");	
		System.out.println("종료되었습니다.");	
		System.out.println("종료되었습니다.");	
	}	
	
	
}
