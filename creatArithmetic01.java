package paircoding;

import java.util.Random;

//���ɴ����ŵ���Ŀ
public class creatArithmetic01 {

  String process;//��ʾ����һ��������Ҳ���=��ʽ��,��"1 �� 1"������ʽ
  String process1;//��ʾ����һ��������Һ�=��ʽ��,��"1 �� 1 ="������ʽ
  String process2;//��ʾ����������������Һ�=��ʽ��,��"1 �� 1 �� 1 ="������ʽ
  String[] operationSymbol1 = new String[1];//���峤��Ϊ1������������ź�һ�������ʽ���е������,���������"��"
  String[] operationSymbol2 = new String[1];//���峤��Ϊ1������������ź����������ʽ���еĵڶ��������
  int number1;//��������ʽ�ĵ�һ������
  int number2;//��������ʽ�ĵڶ�������
  int number3;//��������ʽ�ĵ���������
  String answer1;//����ֻ����һ���������ʽ�ӵĴ�
  String answer2;//���庬�������������ʽ�ӵĴ�
  Random r = new Random();
  //����һ�����η���(����Ĳ���n��������test����Ŀ���ȡֵ��Χ��n),�������ɶ�Ӧ����Ŀ����
  public creatArithmetic01(int n) {
      oneArithmeticResult(n);////����һ���������ʽ��
      twoArithmeticResult(n);////���������������ʽ��
  }

  //�������������(�ȿ�����һ��������ķ���,������)
  private void twoArithmeticResult(int n) { //�����nҲ�ǿ���ȡֵ��Χ��n
      //��������һ�������ʽ�ӷ���,�����ڴ˻�������չ�����������(��Ϊ�տ�ʼû�п��ǵ������ŵ����,��Ū������)
      oneArithmeticResult(n);
      //������һ��whileѭ���������ɷ�����������Ŀ
      while (true) {
          number3 = r.nextInt(n - 2) + 2; //������ɵ���������
          int choice2 = r.nextInt(3);//ͬ������һ��choice2����������������ĸ��������ʾ�ڶ��������
          if (choice2 == 0) {
              operationSymbol2[0] = "��";//�ڶ��������Ϊ��
              //�жϵ�һ���������ʲô
              if(operationSymbol1[0].equals("��")){
                  //�����һ��������ǡ�,����ֱ�Ӹ��ڶ������ֺ͵��������ֵ�����������Ž��м���
                  //����������������Ϊ�����һ��������ǡ�,�Ǻ����٣����ߣ�һ�������һ����Ϊ�����,���ԾͶԺ������������ȼ���
                  if((number2 + number3) > number1 &&
                          (number2 + number3 )< n){//��������������Ҫ������������ڵ�һ�����ֲ���С��ȡֵ��Χ����������
                      answer2 = simplestFraction(number1 ,(number2 + number3));//�����ǵ��÷���ֱ��������������ʾ��
                      //���ɺ��������������ʽ��
                      process2 = number1 + operationSymbol1[0] + "(" + number2 + operationSymbol2[0] + number3 + ")" + "=";
                  }
              }else if (operationSymbol1[0].equals("��") || operationSymbol1[0].equals("��")) {//����һ����������ǡ�ʱ,����������˳�����
                  if (Integer.parseInt(answer1) + number3 < n) {//�����Ҫ����С��ȡֵ��Χ
                      answer2 = String.valueOf(Integer.parseInt(answer1) + number3);
                      process2 = process + operationSymbol2[0] + number3 + "=";
                      break;
                  }
              }
          } else if (choice2 == 1) {
              operationSymbol2[0] = "��";//�ڶ��������Ϊ��
              if(operationSymbol1[0].equals("��")){//�����һ�������Ϊ��
                  //��ʱ����ȼ�����ټ��㣭�����Ϊ�����,�������ǰѺ����������ȼ���
                  if(number2 - number3 > number1){//���������ֵĲ���Ҫ������ڵ�һ������
                      answer2 = simplestFraction(number1 ,(number2 - number3));
                      process2 = number1 + operationSymbol1[0] + "(" + number2 + operationSymbol2[0] + number3 + ")" + "=";
                      break;
                  }
              }else if (operationSymbol1[0].equals("��") || operationSymbol1[0].equals("��")) {//�����һ�����ֲ�Ϊ��,��˳����м���
                  if (Integer.parseInt(answer1) >= number3) {//��Ϊ��ʱ�ڶ���������ǣ�,����ǰ�������ֵ���������Ҫ���ڵ��������ֲ�����
                      answer2 = String.valueOf(Integer.parseInt(answer1) - number3);
                      process2 = process + operationSymbol2[0] + number3 + "=";
                      break;
                  }
              }
          } else if (choice2 == 2) {
              operationSymbol2[0] = "��";//�ڶ��������Ϊ��
              if(operationSymbol1[0].equals("��")){
                  //�����ʱ��һ�������ҲΪ��,��ֱ�ӱ�Ϊֻ����һ���µ�ʽ��,ȥ�������������
                  //���������ԭ��������ڶ������ֹ���,Ҫ�������ķ�Χ������n,�ͻᵼ��ֻ�е�������������1��ʱ�����������ĸ������n,���������Ļ���1�ļ���û������
                  //�ҳ��Թ���һ������,������Ҫ�ı�number2�����ȡֵ��Χ��number3�����ȡֵ��Χ,�е��鷳,��ֱ�Ӳ������˺ٺ�
                  process2 = process1;
                  answer2 = simplestFraction(number1,number2);
                  break;
              }else if(operationSymbol1[0].equals("��") || operationSymbol1[0].equals("��")){
                  //�����ʱ��һ���������Ϊ��,��ֱ�Ӹ�ǰ�������ֵ������������,��Ϊ�������Ű�˳�����ᵼ�½�����������
                  if (Integer.parseInt(answer1) < number3 && Integer.parseInt(answer1) > 0) {//������ǰ�������ֵļ�����С�ڵ��������ֲ��Ҵ���0
                      answer2 = simplestFraction(Integer.parseInt(answer1),number3);
                      process2 = "(" + process + ")" + operationSymbol2[0] + number3 + "=";
                      break;
                  }
              }
          }
      }
  }
  
  //����һ�������
  private void oneArithmeticResult(int n) { //�����nҲ�ǿ���ȡֵ��Χ��n
      //������һ��whileѭ���������ɷ�����������Ŀ
      while (true) {
          // ��Ϊ����1�ڼ�����̫����,��̫������������ʽ����������,�Ͱ���ȥ
          number1 = r.nextInt(n - 2) + 2;//���������һ������
          number2 = r.nextInt(n -2) + 2;//��������ڶ�������
          int choice1 = r.nextInt(3);//�������һ������Ϊ4��choice1���������������ʲô
          if (choice1 == 0) {//��choice1=0��ʱ�������Ϊ��
              //���������ֵĺ�С��ȡֵ��Χ��ʱ���������"��"����ʽ
              if (number1 + number2 < n) {
                  operationSymbol1[0] = "��";
                  answer1 = String.valueOf(number1 + number2);//��Ϊanswer1���ַ�������,������Ҫת��
                  break;
              }
          } else if (choice1 == 1) {//��choice1=1��ʱ�������Ϊ��
              //����һ�����ִ��ڵڶ������ֵ�ʱ���������"��"����ʽ
              if (number1 > number2) {
                  operationSymbol1[0] = "��";
                  answer1 = String.valueOf(number1 - number2);
                  break;
              }
          } else if (choice1 == 2) {//��choice>=2��ʱ�������Ϊ��,
              if (number1 < number2) {//��ΪҪ����Ϊ�����,��һ������ҪС�ڵڶ�������
                  operationSymbol1[0] = "��";
                  answer1 = simplestFraction(number1, number2);//����������涨��ķ���ֱ������������
                  break;
              }
          }
      }
      //���������ɲ���"="��process��Ϊ�˷��������ɺ�������������ŵķ�����ֱ�ӵ���
      process = number1 + operationSymbol1[0] + number2;
      //����ֻ����һ���������ʽ��
      process1 = number1 + operationSymbol1[0] + number2 + "=";
  }

  //����һ����������һ��������������
  //����Ϊ���Ӻͷ�ĸ
  private String simplestFraction(int molecule, int denominator) {
      //�������Լ��
      int greatestCommonDivisor = 1;//�ȶ������Լ��
      for (int i = molecule; i >= 1; i--) {
          if (molecule % i == 0 && denominator % i == 0) {
              greatestCommonDivisor = i;//�Ӻ���ǰ����,�����㱻����ʱ,��Ϊ���Լ��
              break;
          }
      }
      //�ٷ���������
      //���Ӻͷ�ĸͬʱ�������Լ��
      return molecule / greatestCommonDivisor + "/" + denominator / greatestCommonDivisor;
  }
}
