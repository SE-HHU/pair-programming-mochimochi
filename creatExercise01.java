package paircoding;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//生成带括号的题目
public class creatExercise01 {
    //产生题目和答案并放入对应文件中
    public creatExercise01(int n) throws IOException{
    	int wrongNumber=0;
    	int trueNumber=0;
    	StringBuffer correct = new StringBuffer();
    	StringBuffer wrong = new StringBuffer();
        Random r = new Random();
     
        File exerciseFile = new File("Exercises.txt");
		try {
			exerciseFile.createNewFile();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		File answerFile = new File("Answers.txt");
		try {
			exerciseFile.createNewFile();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		File gradeFile = new File("Grade.txt");
		try {
			gradeFile.createNewFile();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		//生成exercise,answers,grades三个文件
		FileWriter f1 = new FileWriter("Exercises.txt");
		FileWriter f2 = new FileWriter("Answers.txt");
        //用来统计产生过的总题目数量,这个可以不要,就是用来统计一下确保确实可以产生不重复题目
        int count = 0;

        //用一个参数来决定生成题目的数量
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你想生成的题目数量:");
        int number = sc.nextInt();
        sc.nextLine();

        //定义一个数组存放未重复的题目
        String[] arr = new String[number + 1];
        for (int i = 1; i < number + 1; i++) {
            int random = r.nextInt(3);//产生一个随机数用来决定生成几个运算符的算式
            //调用类creatArithmetic01中生成算式的方法
            creatArithmetic01 ca = new creatArithmetic01(n);
            if (random == 0) {//random为0产生一个运算符的
                if (!judgment(arr, ca.process1)) {//判断是否重复,如果不重复,写入对应文件
                   f1.write(i + ". " + ca.process1+"\r\n");
                   f1.flush();
                   f2.write(i + ". " +ca.answer1+"\r\n");
                   f2.flush();
                    System.out.println("请计算:" + ca.process1);
                    System.out.println("你的答案：");
                    Scanner input = new Scanner(System.in);
                    if(input.nextLine().equals(ca.answer1)) {
                    	trueNumber+=1;
            			correct.append(String.valueOf(i)+",");
                    }else {
                    	wrongNumber+=1;
            			wrong.append(String.valueOf(i)+",");
                    }
                    arr[i] = ca.process1;//将没有重复的算式放入数组当中
                   //此时已经生成一个式子,所以i+1
                    
                }else {
                	i-=1;
                	continue;
                }
            }else {//产生两个运算符的
                if (!judgment(arr, ca.process2)) {//判断是否重复,如果不重复,写入对应文件
                    f1.write(i + ". " +ca.process2+"\r\n");
                    f1.flush();
                    f2.write(i + ". " +ca.answer2+"\r\n");
                    f2.flush();
                    System.out.println("请计算:" + ca.process2);
                    System.out.println("你的答案：");
                    Scanner input = new Scanner(System.in);
                    if(input.nextLine().equals(ca.answer2)) {
                    	trueNumber+=1;
            			correct.append(String.valueOf(i)+",");
                    }else {
                    	wrongNumber+=1;
            			wrong.append(String.valueOf(i)+",");
                    }
                    arr[i] = ca.process2;//将没有重复的算式放入数组当中
                    //此时已经生成一个式子,所以i+1
                }else {
                	i-=1;
                	continue;
                }
            }
            //没进行一次循环,count+1,用于统计总共产生过多少道题目
            count++;
        }
        if(correct.length()>=1)
        	correct.deleteCharAt(correct.length() - 1);
        if(wrong.length()>=1) {
        	wrong.deleteCharAt(wrong.length() - 1);
        }
        StringBuffer correctGrades = new StringBuffer("Correct:");
        correctGrades.append(String.valueOf(trueNumber));
        correctGrades.append(" (");
        correctGrades.append(correct);
        correctGrades.append(")");
        StringBuffer wrongGrades = new StringBuffer("Wrong:");
        wrongGrades.append(String.valueOf(wrongNumber));
        wrongGrades.append(" (");
        wrongGrades.append(wrong);
        wrongGrades.append(")");
        writegrades(correctGrades,wrongGrades,count,count-number);
        
    }

    //定义一个带参方法用来判断数组是否包含该元素,返回true或false
    public static boolean judgment(String[] arr,String containValue) {
    	if(arr[0]==null)
    		return false;
    	else {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(containValue)) {
                return true;
            }
        }
        return false;
    }
    }


    //定义一个带参方法将生成的题目放入文件Exercises.txt
    public void writeExercises(String exercises){
        try {
        	FileWriter f1 = new FileWriter("Exercises.txt");
        	f1.write(exercises);
        	f1.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //定义一个带参方法将生成的答案放入文件Answers.txt
    public void writeAnswers(String answers){
        try {
        	 FileWriter f2 = new FileWriter("Answers.txt");
        	 f2.write(answers);
        	 f2.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //定义一个带参方法将成绩情况写入Grade.txt
	public void writegrades(StringBuffer grades1,StringBuffer grades2,int count1,int count2) {
		try {

			 FileWriter f3 = new FileWriter("Grade.txt");
			 f3.write(grades1.toString()+"\r\n");
			 f3.write(grades2.toString()+"\r\n");
			 f3.write("Repeat:"+String.valueOf(count2)+"\r\n");
			 //f3.write("重复了"+String.valueOf(count2)+"道题目");
			 f3.flush();
			 
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}