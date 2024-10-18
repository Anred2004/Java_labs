import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;


public class Main
{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        //*****************111********************//

        System.out.println("Введите строку: ");
        String myStr = in.nextLine();
        String finalStr = task_1(myStr);
        System.out.println("Уникальная подстрока: " + finalStr);

        //*****************222********************//
        System.out.println();
        int[] massiv1 = {1,2,5,8,10};
        int[] massiv2 = {2,15,18,100};
        int[] finalMass = task_2(massiv1, massiv2);
        System.out.println("Обьединенный отсортированный массив: " + Arrays.toString(finalMass));

        //*****************333********************//
        System.out.println();
        System.out.println("Максимальная сумма подмассива: " + task_3(massiv1));

        //*****************444********************//

        int[][] finalmatrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] matrix = task_4(finalmatrix);
        System.out.print("\nПовернутая матрица на 90 по часовой\n");
        for (int[] n : matrix)
        {
            for (int element : n)
            {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        //*****************555********************//

        System.out.println();
        int g = 7;
        System.out.println("Искомая пара элементов: " + Arrays.toString(task_5(massiv1, g)));

        //*****************666********************//

        System.out.println();
        System.out.println("Сумма элементов матрицы: " + task_6(finalmatrix));

        //*****************777********************//

        System.out.println();
        System.out.println("Максимальные элементы в каждой строке: " + Arrays.toString(task_7(finalmatrix)));

        //*****************888********************//

        int[][] matrix1 = task_8(finalmatrix);
        System.out.print("\nПовернутая матрица на 90 против часовой\n");
        for (int[] n : matrix1)
        {
            for (int element : n)
            {
                System.out.print(element + " ");
            }
            System.out.println();
        }



    }

    public static String task_1 (String str)
    {
        String subString = "";
        int i = str.length();
        int maxLengthSubstr = 0;
        int start = 0;
        int[] lastIndex = new int[256]; //храним последний индекс символа

        for (int end = 0; end < i; end++)
        {
            char currentChar = str.charAt(end);
            start = Math.max(start, lastIndex[currentChar]);
            // длина текущей уникальной подстроки
            int length = end - start + 1;
            if (length > maxLengthSubstr)
            {
                maxLengthSubstr = length;
                subString = str.substring(start, end + 1);
            }
            // Обновляем последний индекс символа
            lastIndex[currentChar] = end + 1;
        }

        return subString;
    }

    public static int[] task_2 (int[] mass1, int[] mass2)
    {
        int[] finalMass = new int[mass1.length + mass2.length];

        int step = 0;
        for (int i = 0; i < mass1.length; i++)
        {
            finalMass[step] = mass1[i];
            step++;
        }
        for (int i = 0; i < mass2.length; i++)
        {
            finalMass[step] = mass2[i];
            step++;
        }
        Arrays.sort(finalMass);
        return finalMass;
    }

    public static int task_3 (int[] mass)
    {
        if (mass.length == 0)
        {
            return 0;
        }
        int maxSubCursum = mass[0];
        int maxSubsum = mass[0];

        for (int i = 1; i < mass.length; i++)
        {
            maxSubCursum = Math.max(mass[i], maxSubCursum + mass[i]);
            if(maxSubCursum > maxSubsum)
            {
                maxSubsum = maxSubCursum;
            }
        }
        return maxSubsum;
    }

    public static int[][] task_4 (int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] rotated = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static int[] task_5 (int[] mass, int target)
    {
        for(int i = 0; i < mass.length - 1; i++)
        {
            for(int j = i + 1; j < mass.length; j++)
            {
                if(mass[i] + mass[j] == target)
                {
                    return new int[] {mass[i], mass[j]};
                }
            }
        }
        return null;
    }

    public static int task_6 (int[][] matrix)
    {
        int sum = 0;
        for(int[] n : matrix)
        {
            for(int element: n)
            {
                sum += element;
            }
        }
        return sum;
    }

    public static int[] task_7 (int[][] mass)
    {
        int[] maxUnit = new int[mass.length];

        for (int i = 0; i < mass.length; i++)
        {
            int max = mass[i][0];
            for (int j = 1; j < mass[i].length; j++)
            {
                if (mass[i][j] > max)
                {
                    max = mass[i][j];
                }
            }
            maxUnit[i] = max;
        }
        return maxUnit;
    }

    public static int[][] task_8 (int[][] matrix1)
    {
        int n = matrix1.length;
        int m = matrix1[0].length;
        int[][] rotated = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                rotated[m - 1 - j][i] = matrix1[i][j];
            }
        }
        return rotated;
    }
    
}
