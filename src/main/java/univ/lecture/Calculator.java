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


		if (isContainRightParenthesis(exp)) {
			Stack cal_stack = new Stack();

			int ref = 0;
			while (exp.length() != ref) {
				String string = new String();
				char tmp;

				while (exp.length() != ref) {
					if((tmp = exp.charAt(ref++)) == ')'){
						break;
					}
					cal_stack.push(tmp);
				}

				while (cal_stack.size() > 0) {
					if((char) cal_stack.peek() == '('){
						cal_stack.pop();
						break;
					}
					string = cal_stack.pop() + string;
				}

				for(int i = 0; i < Integer.toString(calculate(string)).length(); i++){
					cal_stack.push(Integer.toString(calculate(string)).charAt(i));
				}
			}

			String string2 = new String();

            string2 = isCalstackEmpty(cal_stack, string2);

            exp = string2;
		}



		if (isContainSum(exp, sum)) {
			StringTokenizer token = new StringTokenizer(exp, sum);

			int temp = calculate(token.nextToken());

			while (token.hasMoreTokens()) {
				String val = token.nextToken();
				temp = temp + calculate(val);
			}

			num = temp;

		}



		else if (isContainSub(exp, sub)) {
			StringTokenizer st = new StringTokenizer(exp, "-");
			String val = st.nextToken();
			char set = val.charAt(val.length() - 1);
			int temp;
			if (set == '*' || set == '/') {
				temp = calculate(st.nextToken());
				val = val + Integer.toString(temp);
				temp = -calculate(val);
			} else {
				temp = calculate(val);
				if (!st.hasMoreTokens()) {
					temp = -temp;
				}
			}
			while (st.hasMoreTokens()) {
				String n = st.nextToken();
				temp = temp - calculate(n);
			}
			num = temp;
		}





		else if (isContainMul(exp, mul)) {
			StringTokenizer token = new StringTokenizer(exp, mul);
			int temp = calculate(token.nextToken());
			while (token.hasMoreTokens()) {
				String val = token.nextToken();
				temp = temp * calculate(val);
			}
			num = temp;
		}



		else if (isContainDiv(exp, div)) {
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

    private boolean isContainDiv(String exp, String div) {
        return exp.contains(div);
    }

    private boolean isContainMul(String exp, String mul) {
        return exp.contains(mul);
    }

    private boolean isContainSub(String exp, String sub) {
        return exp.contains(sub);
    }

    private boolean isContainSum(String exp, String sum) {
        return exp.contains(sum);
    }

    private boolean isContainRightParenthesis(String exp) {
        return exp.contains(")");
    }

    private String isCalstackEmpty(Stack cal_stack, String string2) {
        while (!cal_stack.empty()) {
            string2 = cal_stack.pop() + string2;
        }
        return string2;
    }
}
