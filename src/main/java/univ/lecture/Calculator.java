package univ.lecture;
//team_15
//namhyung
//dongwan

import java.util.StringTokenizer;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {
	public int calculate(String exp) {

		int num;

		String sum = "+";
		String sub = "-";
		String mul = "*";
		String div = "/";

		if (exp.contains(sum)) {
			StringTokenizer token = new StringTokenizer(exp, sum);

			int temp = calculate(token.nextToken());

			while (token.hasMoreTokens()) {
				String val = token.nextToken();
				temp = temp + calculate(val);
			}

			num = temp;

		}

		else if (exp.contains(sub)) {
			StringTokenizer token = new StringTokenizer(exp, sub);
			int temp = calculate(token.nextToken());
			while (token.hasMoreTokens()) {
				String val = token.nextToken();
				temp = temp * calculate(val);
			}
			num = temp;
		}
		
		else if (exp.contains(mul)) { 
			StringTokenizer token = new StringTokenizer(exp, mul); 
			int temp = calculate(token.nextToken()); 
			while (token.hasMoreTokens()) { 
				String val = token.nextToken(); 
				temp= temp * calculate(val); 
			} 
			num = temp;
		}


		else {
			num = Integer.parseInt(exp);
		}
		return num;
	}
}