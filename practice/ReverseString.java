import java.util.Scanner;

class ReverseString{
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a string");
		String str=scanner.next();
		System.out.println(reverseStr(str));
	}
	
	private static String reverseStr(String str){
		String tempStr="";
		for(int i=str.length()-1;i>=0;i--){
			tempStr=tempStr+str.charAt(i);
		}
		return tempStr;
	}
}