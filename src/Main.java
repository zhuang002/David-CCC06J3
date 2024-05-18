import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static String[] keyPad = {" ", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	static HashMap<Character, Integer> keyPressMap = new HashMap<>();
	static HashMap<Character, Integer> keyIdMap = new HashMap<>();
	
	public static void main(String[] args) {
		buildDictionaries(); // build 2 hashmaps.
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		// while loop: new learning. 
		while (!s.equals("halt")) {
			int time = getPressTime(s);
			System.out.println(time);
			s = sc.nextLine();
		}
	}

	private static void buildDictionaries() {
		for (int i=0;i<keyPad.length;i++) {
			// i is actually the key ID;
			String chars = keyPad[i];
			for (int j=0;j<chars.length();j++) {
				// j is the position of the c, which+1 equals to the presses of the key.
				char c = chars.charAt(j);
				keyPressMap.put(c, j+1);
				keyIdMap.put(c, i);
			}
		}
		
	}

	private static int getPressTime(String s) {
		int iRet = 0;
		int previousKey = -1; // set the first previous key to an impossible value.
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			iRet += getPresses(c); 
			int key = getKeypadKey(c);
			if (key == previousKey) {
				iRet += 2;
			}
			previousKey = key; // current key is the previous key for next round.
		}
		
		return iRet;
	}

	private static int getKeypadKey(char c) {
		// TODO Auto-generated method stub
		return keyIdMap.get(c);
	}

	private static int getPresses(char c) {
		return keyPressMap.get(c);
	}
	
	

}
