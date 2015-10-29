package Easy;

import java.util.Arrays;

class Sample {
	public static void main(String[] args) {
		String[] s1 = "5 3 6 7 8 10 2".split(" ");

		for (int i = 0; i < s1.length; i++) {

			System.out.print(s1[i] + " ");
		}
		System.out.println();
		Arrays.sort(s1);
		for (int i = 0; i < s1.length; i++) {

			System.out.print(s1[i] + " ");
		}
	}

}
