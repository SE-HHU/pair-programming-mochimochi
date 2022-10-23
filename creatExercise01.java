package paircoding;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//���ɴ����ŵ���Ŀ
public class creatExercise01 {
    //������Ŀ�ʹ𰸲������Ӧ�ļ���
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
		//����exercise,answers,grades�����ļ�
		FileWriter f1 = new FileWriter("Exercises.txt");
		FileWriter f2 = new FileWriter("Answers.txt");
        //����ͳ�Ʋ�����������Ŀ����,������Բ�Ҫ,��������ͳ��һ��ȷ��ȷʵ���Բ������ظ���Ŀ
        int count = 0;

        //��һ������������������Ŀ������
        Scanner sc = new Scanner(System.in);
        System.out.println("�������������ɵ���Ŀ����:");
        int number = sc.nextInt();
        sc.nextLine();

        //����һ��������δ�ظ�����Ŀ
        String[] arr = new String[number + 1];
        for (int i = 1; i < number + 1; i++) {
            int random = r.nextInt(3);//����һ������������������ɼ������������ʽ
            //������creatArithmetic01��������ʽ�ķ���
            creatArithmetic01 ca = new creatArithmetic01(n);
            if (random == 0) {//randomΪ0����һ���������
                if (!judgment(arr, ca.process1)) {//�ж��Ƿ��ظ�,������ظ�,д���Ӧ�ļ�
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
                    arr[i] = ca.process1;//��û���ظ�����ʽ�������鵱��
                   //��ʱ�Ѿ�����һ��ʽ��,����i+1
                    
                }else {
                	i-=1;
                	continue;
                }
            }else {//���������������
                if (!judgment(arr, ca.process2)) {//�ж��Ƿ��ظ�,������ظ�,д���Ӧ�ļ�
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
                    arr[i] = ca.process2;//��û���ظ�����ʽ�������鵱��
                    //��ʱ�Ѿ�����һ��ʽ��,����i+1
                }else {
                	i-=1;
                	continue;
                }
            }
            //û����һ��ѭ��,count+1,����ͳ���ܹ����������ٵ���Ŀ
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

    //����һ�����η��������ж������Ƿ������Ԫ��,����true��false
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


    //����һ�����η��������ɵ���Ŀ�����ļ�Exercises.txt
    public void writeExercises(String exercises){
        try {
        	FileWriter f1 = new FileWriter("Exercises.txt");
        	f1.write(exercises);
        	f1.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //����һ�����η��������ɵĴ𰸷����ļ�Answers.txt
    public void writeAnswers(String answers){
        try {
        	 FileWriter f2 = new FileWriter("Answers.txt");
        	 f2.write(answers);
        	 f2.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //����һ�����η������ɼ����д��Grade.txt
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