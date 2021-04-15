package amazon;

import java.util.Scanner;

public class RunLengthEncoding {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		System.out.println(encodeString(string));
		scanner.close();
	}
	
	private static String encodeString(String string) {
		StringBuilder sb = new StringBuilder();
		if (string != null && string.length() > 0) {
			char[] charArray = string.toCharArray();
			int count = 1;
			for (int i = 1; i < charArray.length; i++) {
				
				char current = charArray[i];
				char prev = charArray[i-1];
				
				if (current == prev) {
					count++;
				}
				if (current != prev || i == charArray.length-1) {
					sb.append(count);
					sb.append(prev);
					count = 1;
				}
			}
		}
		return String.valueOf(sb);
	}
}
