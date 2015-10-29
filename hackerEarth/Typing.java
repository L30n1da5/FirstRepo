package Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Typing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int result[] = new int[t];
		for (int x = 0; x < t; x++) {

			String msg = br.readLine();
			int len = msg.length();
			int count = 0;
			int sym[] = new int[len];

			for (int i = 0; i < len; i++) {

				if (msg.charAt(i) == '.' || msg.charAt(i) == ','
						|| msg.charAt(i) == '?' || msg.charAt(i) == '!'
						|| msg.charAt(i) == '1')
					sym[i] = 1;

				if (msg.charAt(i) == 'a' || msg.charAt(i) == 'b'
						|| msg.charAt(i) == 'c' || msg.charAt(i) == '2')
					sym[i] = 2;

				if (msg.charAt(i) == 'd' || msg.charAt(i) == 'e'
						|| msg.charAt(i) == 'f' || msg.charAt(i) == '3')
					sym[i] = 3;
				if (msg.charAt(i) == 'g' || msg.charAt(i) == 'h'
						|| msg.charAt(i) == 'i' || msg.charAt(i) == '4')
					sym[i] = 4;
				
				if (msg.charAt(i) == 'j' || msg.charAt(i) == 'k'
						|| msg.charAt(i) == 'l' || msg.charAt(i) == '5')
					sym[i] = 5;

				if (msg.charAt(i) == 'm' || msg.charAt(i) == 'n'
						|| msg.charAt(i) == 'o' || msg.charAt(i) == '6')
					sym[i] = 6;

				if (msg.charAt(i) == 'p' || msg.charAt(i) == 'q'
						|| msg.charAt(i) == 'r' || msg.charAt(i) == 's'
						|| msg.charAt(i) == '7')
					sym[i] = 7;

				if (msg.charAt(i) == 't' || msg.charAt(i) == 'u'
						|| msg.charAt(i) == 'v' || msg.charAt(i) == '8')
					sym[i] = 8;

				if (msg.charAt(i) == 'w' || msg.charAt(i) == 'x'
						|| msg.charAt(i) == 'y' || msg.charAt(i) == 'z'
						|| msg.charAt(i) == '9')
					sym[i] = 9;

				if (msg.charAt(i) == '_' || msg.charAt(i) == '0')
					sym[i] = 10;

				if (msg.charAt(i) == '.' || msg.charAt(i) == 'a'
						|| msg.charAt(i) == 'd' || msg.charAt(i) == 'g'
						|| msg.charAt(i) == 'j' || msg.charAt(i) == 'm'
						|| msg.charAt(i) == 'p' || msg.charAt(i) == 't'
						|| msg.charAt(i) == 'w' || msg.charAt(i) == '_')
					count += 1;

				if (msg.charAt(i) == ',' || msg.charAt(i) == 'b'
						|| msg.charAt(i) == 'e' || msg.charAt(i) == 'h'
						|| msg.charAt(i) == 'k' || msg.charAt(i) == 'n'
						|| msg.charAt(i) == 'q' || msg.charAt(i) == 'u'
						|| msg.charAt(i) == 'x' || msg.charAt(i) == '0')
					count += 2;

				if (msg.charAt(i) == '?' || msg.charAt(i) == 'c'
						|| msg.charAt(i) == 'f' || msg.charAt(i) == 'i'
						|| msg.charAt(i) == 'l' || msg.charAt(i) == 'o'
						|| msg.charAt(i) == 'r' || msg.charAt(i) == 'v'
						|| msg.charAt(i) == 'y')
					count += 3;

				if (msg.charAt(i) == '!' || msg.charAt(i) == '2'
						|| msg.charAt(i) == '3' || msg.charAt(i) == '4'
						|| msg.charAt(i) == '5' || msg.charAt(i) == '6'
						|| msg.charAt(i) == 's' || msg.charAt(i) == '8'
						|| msg.charAt(i) == 'z')
					count += 4;

				if (msg.charAt(i) == '1' || msg.charAt(i) == '7'
						|| msg.charAt(i) == '9')
					count += 5;
			}

			for (int i = 1; i < len; i++) {
				if (sym[i] != sym[i - 1])
					count += 1;
			}

			if (msg.charAt(0) == '.' || msg.charAt(0) == ','
					|| msg.charAt(0) == '?' || msg.charAt(0) == '!'
					|| msg.charAt(0) == '1')
				result[x] = count;
			else
				result[x] = count + 1;

		}
		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
	}
}