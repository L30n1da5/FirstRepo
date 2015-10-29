package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class PromNight {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int result[] = new int[t];
		for (int x = 0; x < t; x++) {

			// no. of boys n girls e.g. 8 10
			String[] no = br.readLine().split(" ");

			// heights of boys e.g. 5 6 3 9 1 3 9 12
			// heights of girls e.g. 8 7 9 12 13 10 7 5 2 3
			String[] s1 = br.readLine().split(" ");
			String[] s2 = br.readLine().split(" ");

			// storing no. of boys and girls
			int no_boys = Integer.parseInt(no[0]);
			int no_girls = Integer.parseInt(no[1]);

			if (no_boys > no_girls)
				result[x] = 0;
			else {
				// Arrays to store heights of boys and girls as these have to be
				// sorted
				int boys[] = new int[no_boys];
				int girls[] = new int[no_girls];

				// Storing heights in int arrays
				for (int i = 0; i < no_boys; i++) {
					boys[i] = Integer.parseInt(s1[i]);
				}
				for (int i = 0; i < no_girls; i++) {
					girls[i] = Integer.parseInt(s2[i]);
				}

				// sorting arrays in ascending order
				Arrays.sort(boys);
				Arrays.sort(girls);

				int p, q;
				for (p = no_boys - 1, q = no_girls - 1; p >= 0 || q >= 0; p--, q--) {

					// if condition meets meaning girl is not with boy
					// so we have to search again for the boy
					if (p < 0 || q < 0)
						break;
					if (!((boys[p] > girls[q]) && (boys[p] - girls[q] <= 199)))
						p++;
				}

				if (p > -1)
					result[x] = 0;
				else
					result[x] = 1;
			}
		}

		for (int i = 0; i < t; i++) {
			if (result[i] == 0)
				System.out.println("NO");
			else
				System.out.println("YES");
		}

	}
}