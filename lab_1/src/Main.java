import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Введите номер задачи");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    task1();
                case 2:
                    task2();
                case 3:
                    task3();
                case 4:
                    task4();
                case 5:
                    task5();
            }
        }
    }

    static void task1() {
        System.out.print("Введите натуральное число:");
        int n = in.nextInt();
        int step = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (3 * n) + 1;
            }
            step++;
        }

        System.out.println("Количество шагов: " + step);

    }

    static void task2() {
        System.out.println("Введите натуральное число:");
        int n = in.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int actualNum = in.nextInt();
            if (i % 2 == 0) {
                result += actualNum;
            } else {
                result -= actualNum;
            }
        }

        System.out.println("Сумма ряда: " + result);
    }

    static void task3() {

        System.out.println("Введите координаты клада: ");
        int endX = in.nextInt();
        int endY = in.nextInt();
        in.nextLine(); 

        int x_0 = 0;
        int y_0 = 0;

        int count = 0;
        int minCommand = Integer.MAX_VALUE;

        System.out.println("Введите команды и кол-во шагов: ");
        while (true)
        {
            String command = in.nextLine();
            if (command.equals("стоп"))
            {
                break;
            }

            int steps = in.nextInt();
            in.nextLine();

            switch (command) {
                case "север":
                    y_0 += steps;
                    break;
                case "юг":
                    y_0 -= steps;
                    break;
                case "восток":
                    x_0 += steps;
                    break;
                case "запад":
                    x_0 -= steps;
                    break;
                default:
                    System.out.println("Неверное направление: " + command);
                    continue;
            }

            count++;

            // Проверяем, достигли ли мы клада
            if (x_0 == endX && y_0 == endY)
            {
                minCommand = Math.min(minCommand, count);
            }
        }

        if (minCommand == Integer.MAX_VALUE)
        {
            System.out.println("Клад не найден, карта не верна. Текущие координаты: (" + x_0 + ", " + y_0 + ")");
        }
        else
        {
            System.out.println("Мин кол-во шагов: " + minCommand);
        }

    }

    static void task4()
    {
        System.out.println("Введите кол-во дорог");
        int numRoad = in.nextInt();
        int maxHeight = 0; // Максимально допустимая высота для грузовика
        int finalRoad = 0; // Номер дороги с максимальной высотой

        for (int i = 1; i <= numRoad; i++)
        {
            System.out.println("Введите кол-во туннелей для " + i + " дороги");
            int numSub = in.nextInt();
            System.out.println("Введите высоты");
            int minHeight = Integer.MAX_VALUE; // Минимальная высота для текущей дороги

            for (int j = 0; j < numSub; j++)
            {
                int subHeight = in.nextInt();
                if (subHeight < minHeight)
                {
                    minHeight = subHeight;
                }
            }

            if (minHeight > maxHeight)
            {
                maxHeight = minHeight;
                finalRoad = i;
            }
        }

        System.out.println(finalRoad + " " + maxHeight);
    
    }

    static void task5()
    {
        System.out.println("Введите целое трехзначное число");
        int numb = in.nextInt();

        int digit1 = numb / 100;
        int digit2 = (numb / 10) % 10;
        int digit3 = numb % 10;

        if (numb > 99 && numb < 1000)
        {
            int summ = digit1 + digit2 + digit3;
            int multipli = digit1 * digit2 * digit3;

            if ((summ % 2 == 0) && (multipli % 2 == 0))
            {
                System.out.println("Ураа, число является дважды четным!");
                System.out.println("Сумма цифр " + summ);
                System.out.println("Произведение цифр " + multipli);
            }
            else
            {
                System.out.println("Число не является дважды четным.");
            }
        }
        else
        {
            System.out.println("Некорректно введенное число");
        }
    }
}