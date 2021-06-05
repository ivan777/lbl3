
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
//       String route = "C:\\Users\\privalovie\\YandexDisk\\Универ\\Конструирование\\labs\\lbl3.txt", str, str1, docsx;
//         Graph Gor Graph12
        String route = "F:\\YandexDisk\\Универ\\Конструирование\\labs\\lbl3.txt", str, str1, docsx;
        int zz,i11 = 0, i1 = 0, A = 20,B = 30,C = 10,D = 3, m = 30, v = 15, r0 = 1000,arrayV = 0;
        double lamda = 1.53, R_1 = 0.0, R_2 = 0.0, R_3 = 0.0, CAR_1 = 0.0, CAR_2 = 0.0, CAR_3 = 0.0; //уровень языка программирования ////λ
        int[][] array;
        double[][] data;
        try
        {

        FileReader finkol = new FileReader(route);
        Scanner src1 = new Scanner(finkol); // Чтение из файла

        while (src1.hasNext()) {
            str1 = src1.nextLine();
            i11++;}

        finkol.close();
        FileReader fin = new FileReader(route);
        Scanner src = new Scanner(fin); // Чтение из файла

        zz = i11+1;
        array = new int[zz][2];

        while (src.hasNext()) {
                int i2 = 0;
                str = src.nextLine();
                if(str.length()!=0) {
                    StringTokenizer st = new StringTokenizer(str, " ");
                    while (st.hasMoreTokens()) {
                        docsx = st.nextToken();
                        array[i1][i2] = Integer.parseInt(docsx);
                        i2++;}
                    i1++;}
        }

        fin.close();
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
        data = new double[zz][10];
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

        for (int j = 0; j < zz; j++) {

            if (j == 0) {
            data[j][0] = j; //Номер ошибки (i)
            data[j][3] = r0; //R1
            data[j][4] = r0; //R2
            data[j][5] = r0; //R3
            }else{
                int arrayB = array[j-1][0];
                arrayV = arrayV + array[j-1][1];

                data[j][0] = j; //Номер
                data[j][1] = arrayB; //B
                data[j][2] = arrayV; //V

                data[j][6] = (arrayB/((1/l1.lamda)+(1/data[j-1][3]))); //C(λ,R) = 1/λ+1/R
                data[j][7] = (arrayB/(1/(l1.lamda*data[j-1][4]))); //C(λ,R) = 1/(λ*R)
                data[j][8] = (arrayB/(1/(l1.lamda+data[j-1][5]))); //C(λ,R) = 1/(λ+R)

                //C(λ,R) = 1/λ+1/R
                CAR_1 = CAR_1 + data[j][6];

                //C(λ,R) = 1/(λ*R)
                CAR_2 = CAR_2 + data[j][7];

                //C(λ,R) = 1/(λ+R)
                CAR_3 = CAR_3 + data[j][8];

                data[j][3] = data[j-1][3]*(1+0.001*(arrayV-CAR_1)); //R 1
                data[j][4] = data[j-1][4]*(1+0.001*(arrayV-CAR_2)); //R 2
                data[j][5] = data[j-1][5]*(1+0.001*(arrayV-CAR_3)); //R 3

                R_1 = R_1 + data[j][3];
                R_2 = R_2 + data[j][4];
                R_3 = R_3 + data[j][5];

           }
        }
            l1.data = data;

        long stop_time = System.currentTimeMillis();
        long run_time = stop_time - start_time;
        output(l1,zz,run_time);
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static class lobject implements Cloneable
    {double lamda, n2_1, V_1, B_1, k_2, i_2, K_2, N_2, V_2, P_2, TK_2, B_2, TN_2, m_2, v_2;
        double[][] data;}

    public static void output(lobject l1,int zz, long run_time)
    {
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("Первая задача");
        System.out.println("============================================");
        System.out.printf("n2: %2.2f",l1.n2_1);
        System.out.println();
        System.out.printf("V: %2.2f",l1.V_1);
        System.out.println();
        System.out.printf("λ: %2.2f",l1.lamda);
        System.out.println();
        System.out.printf("B: %2.2f",l1.B_1);
        System.out.println();
        System.out.println("============================================");
        System.out.println("Вторая задача");
        System.out.println("============================================");
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

        System.out.println("============================================");
        System.out.println("Третья задача");
        System.out.println("============================================");
        System.out.println("C(λ,R) = 1/λ+1/R");
        System.out.println("============================================");
        System.out.print(" ri|");
        System.out.print("          R|");
        System.out.print("       B|");
        System.out.print("       V|");
        System.out.print("  C(λ,R)|");
        System.out.println();

        for (int i = 0; i < zz; i++) {
            System.out.printf("r%2.0f|", l1.data[i][0]);
                System.out.print("    ");
                System.out.printf("%2.2f|", l1.data[i][3]);//R
                System.out.print("    ");
                System.out.printf("%2.2f|", l1.data[i][1]);//B
                System.out.print("    ");
                System.out.printf("%2.2f|", l1.data[i][2]);//V
                System.out.print("    ");
                System.out.printf("%2.2f|", l1.data[i][6]);//C(λ,R)
            System.out.println();
        }
        System.out.println("============================================");


        System.out.println("============================================");
        System.out.println("C(λ,R) = 1/(λ*R)");
        System.out.println("============================================");
        System.out.print(" ri|");
        System.out.print("          R|");
        System.out.print("       B|");
        System.out.print("       V|");
        System.out.print("  C(λ,R)|");
        System.out.println();

        for (int i = 0; i < zz; i++) {
            System.out.printf("r%2.0f|", l1.data[i][0]);
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][4]);//R
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][1]);//B
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][2]);//V
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][7]);//C(λ,R)
            System.out.println();
        }
        System.out.println("============================================");


        System.out.println("============================================");
        System.out.println("C(λ,R) = 1/(λ+R)");
        System.out.println("============================================");
        System.out.print(" ri|");
        System.out.print("          R|");
        System.out.print("       B|");
        System.out.print("       V|");
        System.out.print("  C(λ,R)|");
        System.out.println();

        for (int i = 0; i < zz; i++) {
            System.out.printf("r%2.0f|", l1.data[i][0]);
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][5]);//R
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][1]);//B
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][2]);//V
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][8]);//C(λ,R)
            System.out.println();
        }
        System.out.println("============================================");

        System.out.println("Время выполнения: " + run_time + " сек.");
        System.out.println("============================================");
        System.out.println("============================================");
    }

}