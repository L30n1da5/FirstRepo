package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NumberOfRs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int[] maxx = new int[10];
		for (int i = 0; i < t; i++) {
			maxx[i] = maxRs(br.readLine());
		}
		for (int i = 0; i < t; i++) {
			System.out.println(maxx[i]);
		}
	}

	static int[] maxSubArraySum(int a[], int size) {
		int max_so_far = 0, max_ending_here = 0;
		int[] calc = new int[3];
		int[] temp = new int[size];
		int alpha = 0;
		temp[0] = 0;
		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0) {
				max_ending_here = 0;
				temp[++alpha] = i + 1;
			}
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				calc[1] = i;
			}
		}
		calc[2] = max_so_far;

		for (int i = alpha; i >= 0; i--) {
			if (temp[i] < calc[1]) {
				calc[0] = temp[i];
				break;
			}
		}
		return calc;
	}

	static int maxRs(String str) {
		int len = str.length();
		int[] occur = new int[len];

		int k = 0;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'K')
				k++;
		}

		if (k == 0)
			return len - 1;
		if (k == 1 || k == len)
			return len;

		int s = 0;

		occur[s] = 1;
		if (len > 1) {
			for (int i = 1; i < len - 1; i++) {

				if (str.charAt(i) == str.charAt(i - 1))
					occur[s]++;

				else
					occur[++s]++;
			}
		}

		if (len == 2) {
			if (str.charAt(0) == str.charAt(1))
				occur[s]++;
			else
				occur[++s]++;
		}

		if (len > 2) {

			if (str.charAt(len - 1) == str.charAt(len - 2))
				occur[s]++;

			else
				occur[++s]++;
		}
		s++;
		if (str.charAt(0) == 'R')
			for (int i = 0; i < s; i += 2)
				occur[i] *= -1;

		else
			for (int i = 1; i < s; i += 2)
				occur[i] *= -1;
		int maxk = 0;
		for (int i = 0; i < s; i++) {
			if (occur[i] > maxk)
				maxk = occur[i];
		}
		int Rs = len - k + maxk;

		int[] res = maxSubArraySum(occur, s);

		for (int i = res[0]; i <= res[1]; i++) {
			occur[i] *= -1;
		}
		int finalR = 0;
		for (int i = 0; i < s; i++) {
			if (occur[i] < 0)
				finalR += occur[i];

		}
		finalR = Math.abs(finalR);
		if (finalR > Rs)
			return finalR;
		else
			return Rs;
	}
}