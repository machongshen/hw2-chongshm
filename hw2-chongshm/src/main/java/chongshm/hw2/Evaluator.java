package chongshm.hw2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Evaluator {

	public static int hit = 0;
	public static int answer_num = 0;
	public int expected_ans = 0;
	// public String AnswerText = "";
	private HashMap<String, Integer> dictionary;

	public void setAnswerText(String pathname) throws IOException {
		dictionary = new HashMap<String, Integer>();
		File filename = new File(pathname);
		InputStreamReader reader = new InputStreamReader(new FileInputStream(
				filename));
		BufferedReader br = new BufferedReader(reader);
		StringBuffer sb = new StringBuffer();
		String line = "";
		line = br.readLine();

		while ((line = br.readLine()) != null) {

			String tokens[] = line.split("\\|");
			// System.out.println(tokens[tokens.length - 1]);
			dictionary.put(tokens[tokens.length - 1], 1);
			expected_ans++;
		}
		br.close();
		reader.close();

	}

	public double getPrecision() {
		return (double) hit / answer_num;
	}

	public double getRecall() {
		return (double) hit / expected_ans;
	}

	public void judgeAnswer(String answer) {
		if (answer == "")
			return;
		if (dictionary.containsKey(answer)) { // System.out.println("good");
			hit++;
		}
	}

	public void setAnswernum(int num) {
		answer_num = num;
	}

	public double getfScore() {
		double precision = getPrecision();
		double recall = getRecall();
		return 2.0 * precision * recall / (precision + recall);
	}

	public void printReport() {
		System.out.println();
		System.out.println("Total Hit Num:" + hit);
		System.out.println("Total Returned Answer:" + answer_num);
		System.out.println("Total Expected Answer Num:" + expected_ans);
		System.out.println("Precision:" + getPrecision());
		System.out.println("Recall:" + getRecall());
		System.out.println("F-Socre:" + getfScore());
	}
}