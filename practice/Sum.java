import java.util.Scanner;

class Sum{
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter two number to swap");
		int num1=scanner.nextInt();
		int num2=scanner.nextInt();
		System.out.println("Original Value : num1= "+num1+", num2= "+num2);
		
		// swap logic
		num1=num1+num2;
		num2=num1-num2;
		num1=num1-num2;
		
		System.out.println("Value after Swap w/o 3rd Variable : num1= "+num1+", num2= "+num2);
		
		// swap using temp variable
		int temp=num1;
		num1=num2;
		num2=temp;
		System.out.println("Value after Swap with 3rd Variable : num1= "+num1+", num2= "+num2);
	}
}