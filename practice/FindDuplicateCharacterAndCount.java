import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class FindDuplicateCharacterAndCount{
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a string");
		String str=scanner.next();
		characterCount(str).forEach((k,v)->System.out.println(k+","+v));
	}
	
	private static Map<Character,Integer> characterCount(String str){
		char[] charArray=str.toCharArray();
		Map<Character,Integer> map=new HashMap<>();
		for(Character ch:charArray){
			if(map.containsKey(ch))
				map.put(ch,map.get(ch)+1);
			else
				map.put(ch,1);
		}
		return map;
	}
}