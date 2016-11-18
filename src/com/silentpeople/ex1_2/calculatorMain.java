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
	               System.out.println("�Է¹��� �ʰ�: -2147483648~2147483647");
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
			System.out.println("0���� ������� �Ұ����մϴ�. �ٽ� �Է����ּ���!!");
			return true; //0���� ������ ��Ȳ: true, �ƴϸ�: false
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
			
			inputVal = inputValCheck(inputVal); //�������
			
			if(startWithNotNumeric(inputVal)){ // ���ڸ� ������ ��ȣ�� �����ϸ� true�� ��ȯ�ϴ� �޼ҵ�
				// ù��° �ԷµǴ� ���� ������ �������� �ʴ´�.
				System.out.println("������ �Էµ��� �ʽ��ϴ�.");
				continue;
			}
			
			String [] splitValues = splitWithSign(inputVal); // ���ڿ��� ������ �������� �߶� �迭�� ��ȯ�ϴ� �޼ҵ�
			
			//int [] num = new int[splitValues.length];
			int [] num = StringArrToInterArr(splitValues);//���ڿ� �迭�� ���� �迭�� �ٲٴ� �ڵ� ��
			
			//�����ȣ�� �����ϴ� �ڵ� ��
			char sign = PopSign(inputVal);
			
			//0���� �����⸦ �����ϱ� ���� �ڵ� ���
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
		System.out.println("����Ǿ����ϴ�.");	
		System.out.println("����Ǿ����ϴ�.");	
		System.out.println("����Ǿ����ϴ�.");	
	}	
	
	
}
