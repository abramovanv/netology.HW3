import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int typeTax1(int add) {
        return (add * 6) / 100;
    }

    public static int typeTax2(int add, int out) {
        int tax = ((add - out) * 15) / 100;
        return tax;
    }

    public static void main(String[] args) {

        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Выберите операцию и введите её номер: " + "\n" +
                    "1. Добавить новый доход" + "\n" +
                    "2. Добавить новый расход" + "\n" +
                    "3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода:");
                        String moneyStrSpen = scanner.nextLine(); // Не используйте тут nextInt (!)
                        int moneySpen = Integer.parseInt(moneyStrSpen);
                        spendings += moneySpen;
                        break;
                    case 3:
                        int tax1 = typeTax1(earnings);
                        int tax2 = typeTax2(earnings, spendings);
                        if (tax1 < 0 || tax2 < 0) {
                            System.out.println("Налог не может быть отрицательным!");
                            break;
                        }
                        if (tax2 > tax1) {
                            System.out.println("Мы советуем вам УСН доходы" + "\n" +
                                    "Ваш налог составит: " + tax1 + " рублей" + "\n" +
                                    "Налог на другой системе: " + tax2 + " рублей" + "\n" +
                                    "Экономия: " + (tax2 - tax1) + " рублей");
                        } else if (tax1 > tax2) {
                            System.out.println("Мы советуем вам УСН доходы минус расходы" + "\n" +
                                    "Ваш налог составит: " + tax2 + " рублей" + "\n" +
                                    "Налог на другой системе: " + tax1 + " рублей" + "\n" +
                                    "Экономия: " + (tax1 - tax2) + " рублей");
                        } else {
                            System.out.println("Можете выбрать любую систему налогообложения. Налог составит " + tax1);
                        }
                        break;
                    default:
                        System.out.println("Такой операции нет");
                }
            }

        }
        System.out.println("Программа завершена!");
    }
}