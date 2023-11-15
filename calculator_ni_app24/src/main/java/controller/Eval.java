package controller;

import java.util.ArrayList;

public class Eval {
	private static ArrayList<Double> num_list = new ArrayList<Double>();
	private static ArrayList<Character> ope_list = new ArrayList<Character>();

	// リスト初期化
	private static void _list_init() {
		num_list.clear();
		ope_list.clear();
	}

	// 文字列で渡された式を、数値と演算子に分割する。
	private static void _lexical_analysis(String formula) {
		char[] sequenceList = formula.toCharArray();

		double set_num = 0;
		for (char token : sequenceList) {
			if ("+-*/".indexOf(token) > -1) {
				ope_list.add(token);
				num_list.add(set_num);
				set_num = 0;
			} else if ("0123456789".indexOf(token) > -1) {
				set_num *= 10;
				set_num += (double) (token - '0');
			}
		}
		num_list.add(set_num);

		// System.out.println("num:" + num_list + " / ope:" + ope_list);
	}

	// 演算子の優先順位を考慮して計算する。
	static double _calculation() {
		// 足し算、引き算、掛け算、割り算を行う際に使用する共通の変数
		double num1_num, num2_num, set_num;
		int num1_id, num2_id;

		// 掛け算、割り算を行う
		int hit_id, hit_count = 0;
		for (Character token : ope_list) {
			hit_id = -1;
			if ((token == '*') || (token == '/')) {
				hit_id = ope_list.indexOf((token == '*') ? ('*') : ('/'));
				ope_list.set(hit_id, '@');

				num1_id = hit_id - hit_count;
				num2_id = hit_id - hit_count + 1;
				num1_num = num_list.get(num1_id);
				num2_num = num_list.get(num2_id);

				set_num = ((token == '*') ? (num1_num * num2_num) : (num1_num / num2_num));
				num_list.set(num1_id, set_num);

				num_list.remove(num2_id);
				hit_count++;
			}
		}
		// for文内では'*'と'/'削除できないため、for文内では'@'に置換しここでまとめて削除している。
		while (ope_list.remove((Character) '@')) {
			/* ループ内では何もしない */}

		// 足し算、割り算を行う
		for (Character token : ope_list) {
			num1_id = 0;
			num2_id = 1;
			num1_num = num_list.get(num1_id);
			num2_num = num_list.get(num2_id);

			set_num = ((token == '+') ? (num1_num + num2_num) : (num1_num - num2_num));

			num_list.set(num1_id, set_num);
			num_list.remove(num2_id);
		}

		// System.out.println("num:" + num_list + " / ope:" + ope_list);
		return num_list.get(0);
	}

	static double eval(String formula) {
		double anser = 0.0;

		_list_init();
		_lexical_analysis(formula);
		anser = _calculation();

		return anser;
	}
}
