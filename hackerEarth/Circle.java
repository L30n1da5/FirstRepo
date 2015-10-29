package Easy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

class Circle {
	int h, k, r;
	double area;
	double intersection_area;

	Circle(int a, int b, int c) {
		h = a;
		k = b;
		r = c;
		area = Math.PI * r * r;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// no. of test cases
		int t = Integer.parseInt(br.readLine());
		String[] buffer = new String[100];
		buffer=null;
			
		// for storing intersection area
		double[] area = new double[101];

		for (int i = 0; i < t; ++i) {

			String[] hk_pk_pj;

			// read line 1 (n x1 y1 x2 y2),n=no. of circles drawn by both PK and
			// PJ using center x1,y1 and x2,y2 respectively.
			if (buffer == null) {
				hk_pk_pj = br.readLine().split(" ");
			}

			else {
				hk_pk_pj = buffer;
			}

			int n = Integer.parseInt(hk_pk_pj[0]);

			String r_pk[] = br.readLine().split(" ");
			String r_pj[] = br.readLine().split(" ");
			//int len1 = r_pk.length;
			int len2 = r_pj.length;
			int r1 = min(r_pk, n);
			int r2 = min(r_pj, n);

			if ((len2+1)/2 > n) {
				for (int j = 0; j < 5; j++)
				{
					buffer[i] = r_pj[n+1+j];
				}
			} else
				buffer = null;

			/*
			 * // reading all radius for PK and storing the minimum int r1 =
			 * min(br.readLine().split(" "));
			 * 
			 * // reading all radius for PJ and storing the minimum int r2 =
			 * min(br.readLine().split(" "));
			 */

			int x1 = Integer.parseInt(hk_pk_pj[1]);
			int y1 = Integer.parseInt(hk_pk_pj[2]);
			int x2 = Integer.parseInt(hk_pk_pj[3]);
			int y2 = Integer.parseInt(hk_pk_pj[4]);

			Circle c1 = new Circle(x1, y1, r1), c2 = new Circle(x2, y2, r2);

			area[i] = c2.areaOfIntersection(c1);
		}
		printArea(area, t);
	}

	static int min(String[] s, int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; ++i)
			a[i] = Integer.parseInt(s[i]);
		Arrays.sort(a);
		return a[0];

	}

	// #print area in the required format
	static void printArea(double[] a, int len) {
		DecimalFormat f = new DecimalFormat("0.00");
		for (int i = 0; i < len; i++)
			System.out.println(f.format(a[i]));
	}

	// finding area of interaction of the circles
	public double areaOfIntersection(Circle obj) {
		double rr0 = r * r, rr1 = obj.r * obj.r;
		double d = Math.sqrt(Math.abs((obj.h - h) * (obj.h - h) + (obj.k - k)
				* (obj.k - k)));
		if (d > obj.r + r) {
			intersection_area = 0;
		} else if (d <= Math.abs(r - obj.r) && r >= obj.r) {
			intersection_area = obj.area;
		} else if (d <= Math.abs(r - obj.r) && r < obj.r) {
			intersection_area = area;
		} else {
			double phi = (Math.acos((rr0 + (d * d) - rr1) / (2 * r * d))) * 2;
			double theta = (Math.acos((rr1 + (d * d) - rr0) / (2 * obj.r * d))) * 2;
			double area1 = 0.5 * theta * rr1 - 0.5 * rr1 * Math.sin(theta);
			double area2 = 0.5 * phi * rr0 - 0.5 * rr0 * Math.sin(phi);
			intersection_area = area1 + area2;
		}
		return intersection_area;
	}
}