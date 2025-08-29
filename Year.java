import java.util.Scanner;

public class Year {

    public static void main(String[] args) {
        System.out.println("Введите год в формате yyyy");
        Scanner scanner = new Scanner(System.in);
        String yearStr = scanner.nextLine(); // Не используйте тут nextInt (!)
        int year = Integer.parseInt(yearStr);
        if ((year % 400) == 0) {
            System.out.println("Количество дней 366");
        } else if ((year % 4 == 0) & (year % 100 != 0)) {
            System.out.println("Количество дней 366");
        } else {
            System.out.println("Количество дней 365");
        }

    }

}
