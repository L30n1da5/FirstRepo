package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Matrix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long result[] = new long[t];
		for (int x = 0; x < t; x++) {
			long c = 0;
			int n = Integer.parseInt(br.readLine());
			n = n - 1;
			while (n > 0) {

				for (int i = n; i > 0; i--) {
					c += i;
				}

				n = n - 1;
			}

			result[x] = 2 * c;
		}
		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
	}
}