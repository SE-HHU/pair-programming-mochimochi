package paircoding;

import java.util.Scanner;
import java.io.*;
public class test {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("��Ŀ�е���ֵ��Χ��()����");
        //���ò���n����ȡֵ��Χ
        int n = sc.nextInt();
        //ͨ������yes����no��������Ŀ�Ƿ���Դ�������
        while (true){
            System.out.println("��Ŀ�Ƿ���Ҫ������(yes/no)");
            String choice = sc.next();
            if (choice.equals("yes")) {
                //�����ŵ���Ŀ,�ο��� creatArithmetic01
                new creatExercise01(n);
                break;
            } else if (choice.equals("no")) {
                //�������ŵ���Ŀ,�ο��� creatArithmetic02
                new creatExercise02(n);
                break;
            }else {
                //��������������Ч,��������
                System.out.println("������Ч,����������");
            }
        }
    }
}
