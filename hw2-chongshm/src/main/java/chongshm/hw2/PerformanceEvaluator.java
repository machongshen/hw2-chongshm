package chongshm.hw2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PerformanceEvaluator {
	
    public static int correct_num = 0;
    public static int answer_num = 0;
    public int supposed_num = 0;
   // public String AnswerText = "";
    private HashMap<String, Integer> dict;
    public void setAnswerText(String pathname) throws IOException
    { 
      dict = new HashMap<String, Integer>();
      File filename = new File(pathname);
      InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); 
      BufferedReader br = new BufferedReader(reader); 
      StringBuffer sb = new StringBuffer();
      String line = "";  
      line = br.readLine();
    
      while ((line = br.readLine()) != null) {  
           
         
          String tokens[] = line.split("\\|");
          //System.out.println(tokens[tokens.length - 1]);
          dict.put(tokens[tokens.length - 1], 1);
          supposed_num++;
      }
      br.close();
      reader.close();
      
    }
    public double getPrecision()
    {
      return (double)correct_num / answer_num;
    }
    public double getRecall()
    {
      return (double)correct_num / supposed_num;
    }
    public void judgeAnswer(String ans)
    { 
      if(ans == "") return;
      if(dict.containsKey(ans))
      { //System.out.println("good");
        correct_num++;
      }
    }
    public void setAnswernum(int num)
    {
      answer_num = num;
    }
    public double getfScore()
    {
      double precision = getPrecision();
      double recall = getRecall();
      return 2.0*precision*recall / (precision + recall);
    }
    public void printReport()
    {
      System.out.println();
      System.out.println("Correct Num:" + correct_num);
      System.out.println("Total Returned Answer:" + answer_num);
      System.out.println("Supposed Answer Num:" + supposed_num);
      System.out.println("Precision:" + getPrecision());
      System.out.println("Recall:" + getRecall());
      System.out.println("F-socre:" + getfScore());
    }
} 