package hashmap;

import java.util.HashSet;
import java.util.Set;

public class phoneNumber {
	public static void main(String[] args) {

		String[] phone_book = new String[]{"12", "143", "1432324252"};
		solution(phone_book);
	}

	static boolean solution(String[] phone_book){
		Set<String> set = new HashSet<>();

		for(int i =0; i<phone_book.length; i++){
			set.add(phone_book[i]);
		}


		for ( String number : phone_book){
			for(int i = 1; i < number.length(); i++){
				String prefix = number.substring(0,i);

					if(set.contains(prefix)){
						return false;
					}
 			}
		}

		return true;
	}
}
