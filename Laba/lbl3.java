
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.*;

import static java.lang.Math.*;

public class lbl3 {

    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException
    {   long start_time = System.currentTimeMillis();
//       String route = "C:\\Users\\privalovie\\YandexDisk\\Универ\\Конструирование\\labs\\lbl2.txt", str, str1;
//         Graph Gor Graph12
        String route = "F:\\YandexDisk\\Универ\\Конструирование\\labs\\lbl2.txt", str, str1;
        int A = 20,B = 30,C = 10,D = 3, m = 30, v = 15;
        double lamda = 1.53; //уровень языка программирования ////λ
        int[] array;
        double[][] data;

//        System.out.println("Введите значения переменных: ");
//        Scanner inA = new Scanner(System.in);
//        System.out.print("A: ");
//        A = inA.nextInt();
//        Scanner inB = new Scanner(System.in);
//        System.out.print("B: ");
//        B = inB.nextInt();
//        Scanner inC = new Scanner(System.in);
//        System.out.print("C: ");
//        C = inC.nextInt();
//        Scanner inD = new Scanner(System.in);
//        System.out.print("D: ");
//        D = inD.nextInt();

        lobject l1 = new lobject();

        //Первая задача
        l1.n2_1 = (A*B*C)+(D*A);//n2
        l1.V_1 = (l1.n2_1+2)*((log(l1.n2_1+2))/log(2));//V
        l1.lamda = lamda;
        l1.B_1 = pow(l1.V_1,2)/(3000*l1.lamda);//B

        //Вторая задача
        l1.k_2 = l1.n2_1/8;//k
        l1.i_2 = (((log(l1.n2_1))/log(2))/3)+1;//i
        l1.m_2 = m;//m
        l1.v_2 = v;//v
        l1.K_2 = (l1.n2_1/8)+(l1.n2_1/pow(8,2));//K
        l1.N_2 = (220*l1.K_2)+(l1.K_2*(log(l1.K_2)/log(2)));//N
        l1.V_2 = (220*l1.K_2*(log(48)/log(2)));//V
        l1.P_2 = (3*l1.N_2)/8;//P
        l1.TK_2 = (3*l1.N_2)/(8*l1.m_2*l1.v_2);//Tk
        l1.B_2 = l1.V_2/3000;//B
        l1.TN_2 = l1.TK_2/(2*(log(l1.B_2)));//tn

//            System.out.println("============================================");
//            System.out.println("============================================");
//            System.out.print(" i|");
//            System.out.print("          Xi|");
//            System.out.print("        i*Xi|");
//            System.out.print("            1/B-i+1|");
//            System.out.print("    (B-i+1)*Xi|");
//            System.out.print("                1/i|");
//            System.out.println();
//
//            for (int i = 0; i <= z; i++) {
//                System.out.printf("%2.0f|", data[i][0]);
//                for (int j = 1; j <= 5; j++) {
//                    double m = data[i][j];
//                    System.out.print("        ");
//                    if(j == 3 || j == 5)
//                    {
//                        System.out.printf("%2.9f|", m);
//                    }
//                    else {
//                        System.out.printf("%2.2f|", m);
//                    }
//                    if (z == (j)) {
//                    }
//                }
//                System.out.println();
//            }

        long stop_time = System.currentTimeMillis();
        long run_time = stop_time - start_time;
        output(l1,run_time);
    }

    public static class lobject implements Cloneable
    {double lamda, n2_1, V_1, B_1, k_2, i_2, K_2, N_2, V_2, P_2, TK_2, B_2, TN_2, m_2, v_2;}

    public static void output(lobject l1, long run_time)
    {
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("Первая задача");
        System.out.printf("n2: %2.2f",l1.n2_1);
        System.out.println();
        System.out.printf("V: %2.2f",l1.V_1);
        System.out.println();
        System.out.printf("λ: %2.2f",l1.lamda);
        System.out.println();
        System.out.printf("B: %2.2f",l1.B_1);
        System.out.println();
        System.out.println("Вторая задача");
        System.out.printf("k: %2.2f",l1.k_2);
        System.out.println();
        System.out.printf("m: %2.2f",l1.m_2);
        System.out.println();
        System.out.printf("i: %2.2f",l1.i_2);
        System.out.println();
        System.out.printf("v: %2.2f",l1.v_2);
        System.out.println();
        System.out.printf("K: %2.2f",l1.K_2);
        System.out.println();
        System.out.printf("N: %2.2f",l1.N_2);
        System.out.println();
        System.out.printf("V: %2.2f",l1.V_2);
        System.out.println();
        System.out.printf("P: %2.2f",l1.P_2);
        System.out.println();
        System.out.printf("Tk: %2.2f",l1.TK_2);
        System.out.println();
        System.out.printf("B: %2.2f",l1.B_2);
        System.out.println();
        System.out.printf("Tn: %2.2f",l1.TN_2);
        System.out.println();
        System.out.println("Время выполнения: " + run_time + " сек.");
        System.out.println("============================================");
        System.out.println("============================================");
    }

}