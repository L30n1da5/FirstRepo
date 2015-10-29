package Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;

class ProfilePic {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		int[] res = new int[n];
		
		//#Storing 2 3 4 5 as s[i][0]="2" s[i][1]="3" s[i][2]="4" s[i][3]="5"
		String[][] s = new String[n][2];

		for (int i = 0; i < n; i++) {
			s[i] = br.readLine().split(" ");
		}
		//
		
				for (int i = 0; i < n; i++) {
			if (Integer.parseInt(s[i][0]) < l || Integer.parseInt(s[i][1]) < l)
				res[i] = -1;
			else if ((Integer.parseInt(s[i][0]) >= l && Integer
					.parseInt(s[i][1]) >= l) && s[i][0].equals(s[i][1]))
				res[i] = 0;
			else
				res[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			if (res[i] < 0)
				System.out.println("UPLOAD ANOTHER");
			else if (res[i] == 0)
				System.out.println("ACCEPTED");
			else
				System.out.println("CROP IT");
		}

	}

}
