package paircoding;

import java.util.Random;

//���ɲ������ŵ���Ŀ
public class creatArithmetic02 {
  //������������Բ�����creatArithmetic01
  String process;
  String process1;
  String process2;
  String[] operationSymbol1 = new String[1];
  String[] operationSymbol2 = new String[1];
  int number1;
  int number2;
  int number3;
  String answer1;
  String answer2;
  Random r = new Random();

  public creatArithmetic02(int n) {
      oneArithmeticResult(n);
      twoArithmeticResult(n);
  }

  //�������������
  private void twoArithmeticResult(int n) {
      oneArithmeticResult(n);
      while (true) {
          if(operationSymbol1[0].equals("��")) {//�����һ�������Ϊ��,ͬ��creatArithmetic01�еĽ���
              process2 = process1;
              answer2 = simplestFraction(number1,number2);
              break;
          }
          number3 = r.nextInt(n - 2) + 2;//���ɵ������������
          int choice2 = r.nextInt(2);//����choice2����ȷ������������
          if (choice2 == 0) {//�ڶ��������Ϊ��
              operationSymbol2[0] = "��";
              if (operationSymbol1[0].equals("��") || operationSymbol1[0].equals("��")) {//�����һ����������ǡ�,��˳�����
                  if (Integer.parseInt(answer1) + number3 < n) {
                      answer2 = String.valueOf(Integer.parseInt(answer1) + number3);
                      process2 = process + operationSymbol2[0] + number3 + "=";
                      break;
                  }
              }
          } else if (choice2 == 1) {//�ڶ��������Ϊ��
              operationSymbol2[0] = "��";
             if (operationSymbol1[0].equals("��") || operationSymbol1[0].equals("��")) {
                  if (Integer.parseInt(answer1) >= number3) {
                      answer2 = String.valueOf(Integer.parseInt(answer1) - number3);
                      process2 = process + operationSymbol2[0] + number3 + "=";
                      break;
                  }
              }
          }              //����˵��һ��Ϊʲôû�п��ǵڶ��������Ϊ��
      }                  //����ڶ��������Ϊ��,��ô��һ��������Ͳ����ǣ����ߣ���,����������Ϊ�����
  }                      //�����һ�������ҲΪ��,��ô�ͺ�֮ǰ���͵�������Ϊ�µ����һ��,����ȥ����

  //����һ�������
  //���������creatArithmetic01�е�����һ�������
  private void oneArithmeticResult(int n) {
      while (true) {
          int randomNumber1 = r.nextInt(n - 2) + 2;
          int randomNumber2 = r.nextInt(n - 2) + 2;
          int choice1 = r.nextInt(3);
          if (choice1 == 0) {
              operationSymbol1[0] = "��";
              if (randomNumber1 + randomNumber2 < n) {
                  answer1 = String.valueOf(randomNumber1 + randomNumber2);
                  number1 = randomNumber1;
                  number2 = randomNumber2;
                  break;
              }
          } else if (choice1 == 1) {
              operationSymbol1[0] = "��";
              if (randomNumber1 > randomNumber2) {
                  answer1 = String.valueOf(randomNumber1 - randomNumber2);
                  number1 = randomNumber1;
                  number2 = randomNumber2;
                  break;
              }
          } else if (choice1 == 2) {
              if (randomNumber1 < randomNumber2) {
                  operationSymbol1[0] = "��";
                  answer1 = simplestFraction(randomNumber1, randomNumber2);
                  number1 = randomNumber1;
                  number2 = randomNumber2;
                  break;
              }
          }
      }
      process = number1 + operationSymbol1[0] + number2;
      process1 = number1 + operationSymbol1[0] + number2 + "=";
  }

  //����һ����������һ��������������
  //����Ϊ���Ӻͷ�ĸ
  private String simplestFraction(int molecule, int denominator) {
      //�������Լ��
      int greatestCommonDivisor = 1;
      for (int i = molecule; i >= 1; i--) {
          if (molecule % i == 0 && denominator % i == 0) {
              greatestCommonDivisor = i;
              break;
          }
      }
      //�ٷ���������
      return molecule / greatestCommonDivisor + "/" + denominator / greatestCommonDivisor;
  }
}

