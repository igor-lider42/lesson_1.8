import java.time.LocalDate;

public class Main {
    public static void printSeparator() {
        System.out.println("+++++++++++++++");
        System.out.println("---------------");
    }

    public static void printIssues(int issuesCount) {
        System.out.println(issuesCount);
    }

    public static int sum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        task1();

        int[] issuesByMonths = {4, 6, 7, 9, 2, 5, 12, 3, 7, 10, 6, 7, 1, 8,};
        printSeparator();
        for (int i = 0; i < issuesByMonths.length; i++) {
            printIssues(issuesByMonths[i]);
            if ((i + 1) % 3 == 0) {
                printSeparator();
            }
        }
        printSeparator();
        int total = sum(issuesByMonths);
        printIssues(total);

        System.out.println();
    }

    public static void task1() {
        System.out.println("Задача 1");
//### Задание 1
//Реализуйте метод, который получает в качестве параметра год,
// а затем проверяет, является ли он високосным, и выводит результат в консоль.
//*Эту проверку вы уже реализовывали в задании по условным операторам.*
//Теперь проверку нужно обернуть в метод и использовать год, который приходит в виде параметра.
//Результат программы выведите в консоль. Если год високосный,
// то должно быть выведено “*номер года —* високосный год”.
// Если год не високосный, то, соответственно: “*номер года —* не **високосный год”.

    }

    public static void printIsLeapYear(int year) {
        boolean yearIsLeap = isLeap(year);
        printIsLeapYearResult(year, yearIsLeap);

    }

    private static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0;
    }

    private static void printIsLeapYearResult(int year, boolean yearIsLeap) {
        if (yearIsLeap) {
            System.out.println(year + " високосный год.");
        } else {
            System.out.println(year + " не високосный год.");
        }
        System.out.println("Задание 2");
    }
//    ### Задание 2
//Вспомним задание 2 по условным операторам,
// где нам необходимо было предложить пользователю облегченную версию приложения.
//- Текст прошлого задания
//    К нам пришли коллеги и сообщили, что нам нужно знать не только операционную систему телефона,
//    но и год его создания: от этого зависит, подойдет ли приложение для телефона или оно просто не установится.
//    Если телефон произведен с 2015 по нынешний год, то приложение будет работать корректно.
//    Если телефон произведен ранее 2015 года, то клиенту нужно посоветовать
//    установить облегченную версию приложения.
//    Ваша задача: написать программу, которая выдает соответствующее сообщение клиенту
//    при наличии двух условий — операционной системы телефона (iOS или Android) и года производства.
//    Если год выпуска ранее 2015 года, то к сообщению об установке нужно добавить информацию
//    об облегченной версии.
//    Например, для iOS оно будет звучать так:
//    «Установите облегченную версию приложения для iOS по ссылке».
//    А для Android так:
//    «Установите облегченную версию приложения для Android по ссылке».
//    При этом для пользователей с телефоном с 2015 года выпуска нужно вывести обычное предложение
//    об установке приложения.
//    Для обозначения года создания используйте переменную clientDeviceYear, где необходимо указать 2015 год.
//    **Важно**: вложенность больше двух этажей не допускается (условный оператор внутри условного оператора).
//
//Напишите метод, куда подаются два параметра: тип операционной системы (ОС)
// ( 0 — iOS или 1 — Android и год выпуска устройства.
//Если устройство старше текущего года, предложите ему установить lite-версию (облегченную версию).
//Текущий год можно получить таким способом:
//int currentYear = LocalDate.now().getYear();
//Или самим задать значение вручную, введя в переменную числовое значение.
//В результате программа должна выводить в консоль в зависимости от исходных данных,
// какую версию приложения (обычную или lite) и для какой ОС (Android или iOS) нужно установить пользователю.

    public static void recommendApplicationVersion(int clientOS, int deviceYear) {
        boolean deviceIsOld = isDeviceOld(deviceYear);
        System.out.print("Установите ");
        if (deviceIsOld) {
            System.out.print("Lite ");
        }
        System.out.println("версию для ");
        if (clientOS == 0) {
            System.out.println("IOS");
        } else {
            System.out.println("Android");
        }
    }

    public static void printSetSystem(int clientDeviceYear, int clientDevice) {
    }

    private static boolean isDeviceOld(int deviceYear) {
        int currentYear = LocalDate.now().getYear();
        return deviceYear <= currentYear;
    }

    private static void choosingVersion(int oS, int yearManufacture) {
        String osType = "";
        switch (oS) {
            case 0:
                osType = "IOS";
                break;
            case 1:
                osType = "Android";
        }
        System.out.printf("Установите %s версию приложения для %s по ссылке",
                getVersionByYear(yearManufacture), osType);
    }

    private static String getVersionByYear(int year) {
        return year < LocalDate.now().getYear() ? "облегчённую" : "";
    }
//    ### Задание 3
//Возвращаемся к любимой многими задаче на расчет дней доставки банковской карты от банка.
//- Текст прошлого задания
//  Вернемся к делам банковским. У нас хороший банк,
//  поэтому для наших клиентов мы организуем доставку банковских карт на дом с четкой датой доставки.
//  Чтобы известить клиента о том, когда будет доставлена его карта,
//  нам нужно знать расстояние от нашего офиса до адреса доставки.
//    Правила доставки такие:
//    Доставка в пределах 20 км занимает сутки.
//    Доставка в пределах от 20 км до 60 км добавляет еще один день доставки.
//    Доставка в пределах 60 км до 100 км добавляет еще одни сутки.
//    То есть с каждым следующим интервалом доставки срок увеличивается на 1 день.
//    Напишите программу, которая выдает сообщение в консоль:
//    "Потребуется дней: " + срок доставки
//    Объявите целочисленную переменную deliveryDistance = 95, которая содержит дистанцию до клиента.
//Наша задача — доработать код, а именно написать метод,
// который на вход принимает дистанцию и возвращает итоговое количество дней доставки.

    public static void calculateDeliveryDays(int deliveryDistance) {
        int result = 1;
        if (deliveryDistance > 20) {
            result++;
        }
        if (deliveryDistance > 60 && deliveryDistance <= 100) {
            result++;
        } else {
            System.out.println("Невозможно расчитать сроки доставки");
        }
        System.out.println("Потребуется дней: " + result);
    }
}
