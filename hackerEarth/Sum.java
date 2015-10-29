package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Finding the the sum of a series
class Sum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int result[] = new int[t];
		for (int x = 0; x < t; x++) {
			String[] nos = br.readLine().split(" ");
			int len = nos.length;
			for (int i = 0; i < len; i++) {
				result[x] += Integer.parseInt(nos[i]);
			}

		}
		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
	}
}
