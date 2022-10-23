package paircoding;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//���ɲ������ŵ���Ŀ
public class creatExercise02{                 //��������н���ֱ�Ӳ���creatExercise01
    //������Ŀ�ʹ𰸲������Ӧ�ļ���
    public creatExercise02(int n) throws IOException{
        //���Exercises.txt��Answers.txt�ļ����е�����
    	int wrongNumber=0;
    	int trueNumber=0;
    	StringBuffer correct = new StringBuffer();
    	StringBuffer wrong = new StringBuffer();
        Random r = new Random();
        //����ͳ�Ʋ�����������Ŀ����
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
      		FileWriter f1 = new FileWriter("Exercises.txt");
    		FileWriter f2 = new FileWriter("Answers.txt");
        int count = 0;
        //�������ظ�����Ŀ
        Scanner sc = new Scanner(System.in);
        System.out.println("�������������ɵ���Ŀ����:");
        int number = sc.nextInt();
        sc.nextLine();
        //��һ��������δ�ظ�����Ŀ
        String[] arr = new String[number + 1];
        //���������������
        for (int i = 1; i < number + 1;i++) {
            int random = r.nextInt(3);
            //randomΪ0����һ���������,random��Ϊ0���������������
            creatArithmetic02 ca = new creatArithmetic02(n);
            if (random == 0) {
                //�ж��Ƿ��ظ�
                if (!judgment(arr, ca.process1)) {
                	 f1.write(i + ". " + ca.process1+"\r\n");
                     f1.flush();
                     f2.write(i + ". " +ca.answer1+"\r\n");
                     f2.flush();
                    System.out.println("�����:" + ca.process1);
                    System.out.println("��Ĵ𰸣�");
                    Scanner input = new Scanner(System.in);
                    if(input.nextLine().equals(ca.answer1)) {
                    	trueNumber+=1;
            			correct.append(String.valueOf(i)+",");
                    }else {
                    	wrongNumber+=1;
            			wrong.append(String.valueOf(i)+",");
                    }

                    arr[i] = ca.process1;
                }else {
                	i-=1;
                	continue;
                }
            }else {
                if (!judgment(arr, ca.process2)) {
                	 f1.write(i + ". " +ca.process2+"\r\n");
                     f1.flush();
                     f2.write(i + ". " +ca.answer2+"\r\n");
                     f2.flush();
                     System.out.println("�����:" + ca.process2);
                     System.out.println("��Ĵ𰸣�");
                     Scanner input = new Scanner(System.in);
                     if(input.nextLine().equals(ca.answer2)) {
                     	trueNumber+=1;
             			correct.append(String.valueOf(i)+",");
                     }else {
                     	wrongNumber+=1;
             			wrong.append(String.valueOf(i)+",");
                     }
                     arr[i] = ca.process2;
                }else {
                     	i-=1;
                    	continue;
                     }
            }
            //��ͳ�Ƴ�ȥ�ظ��ܹ����������ٵ���
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

    //�ж������Ƿ������Ԫ��
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

    //�����ɵ���Ŀ�����ļ�Exercises.txt
    public void writeExercises(String exercises){
        try {
        	FileWriter f1 = new FileWriter("Exercises.txt");
        	f1.write(exercises);
        	f1.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //�����ɵĴ𰸷����ļ�Answers.txt
    public void writeAnswers(String answers){
        try {

       	 FileWriter f2 = new FileWriter("Answers.txt");
       	 f2.write(answers);
       	 f2.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void writegrades(StringBuffer grades1,StringBuffer grades2,int count1,int count2) {
		try {

			 FileWriter f3 = new FileWriter("Grade.txt");
			 f3.write(grades1.toString()+"\r\n");
			 f3.write(grades2.toString()+"\r\n");
			 f3.write("Repeat:"+String.valueOf(count2)+"\r\n");
			 //f3.write("�ظ���"+String.valueOf(count2)+"����Ŀ");
			 f3.flush();
			 
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
