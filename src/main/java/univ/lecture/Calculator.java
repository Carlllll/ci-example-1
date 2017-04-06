package univ.lecture;
//team_15

//namhyung
//dongwan

import java.util.Stack;
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

		if (exp.contains(")")) {
			Stack cal_stack = new Stack();

			int ref = 0;

			while (exp.length() != ref) {
				char tmp;
				String string = new String();
				

				for (; ref < exp.length(); ref++) {
					if ((tmp = exp.charAt(ref)) == ')')
						break;
					cal_stack.push(tmp);
				}

				while (cal_stack.size() >= 0) {
					if ((char) cal_stack.peek() == '(') {
						cal_stack.pop();
						break;
					}
					string = cal_stack.pop() + string;
				}

				for (int i = 0; i < Integer.toString(calculate(string)).length(); i++)
					cal_stack.push(Integer.toString(calculate(string)).charAt(i));
			}

			String string2 = new String();

			while (cal_stack.size() > 0) {
				string2 = cal_stack.pop() + string2;
			}
			exp = string2;
		}

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
				temp = temp - calculate(val);
			}
			num = temp;
		}

		else if (exp.contains(mul)) {
			StringTokenizer token = new StringTokenizer(exp, mul);
			int temp = calculate(token.nextToken());
			while (token.hasMoreTokens()) {
				String val = token.nextToken();
				temp = temp * calculate(val);
			}
			num = temp;
		}

		else if (exp.contains(div)) {
			StringTokenizer token = new StringTokenizer(exp, div);
			int temp = calculate(token.nextToken());
			while (token.hasMoreTokens()) {
				String val = token.nextToken();
				temp = temp / calculate(val);
			}
			num = temp;
		}

		else {
			num = Integer.parseInt(exp);
		}
		return num;
	}
}