package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CoinBox {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		String[] _lr = new String[m];

		for (int i = 0; i < m; i++) {
			_lr[i] = br.readLine();
		}
		
		String[] []lr = new String[m][2];
		for (int i = 0; i < m; i++) {
			
			lr[i] = _lr[i].split(" ");
		}
		

		int q = Integer.parseInt(br.readLine());

		int[] qrs = new int[q];
		for (int i = 0; i < q; i++) {
			qrs[i] = Integer.parseInt(br.readLine());
		}

		int[] box = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = Integer.parseInt(lr[i][0]) - 1; j <= Integer.parseInt(lr[i][1]) - 1; j++) {
				box[j] = box[j] + 1;
			}
		}

		int[] res = new int[q];

		for (int i = 0; i < q; i++) {
			for (int j = 0; j < n; j++) {
				if (box[j] >= qrs[i]) {
					res[i]++;
				}
			}
		}
		for (int i = 0; i < q; i++) {
			System.out.println(res[i]);
		}

	}

}
