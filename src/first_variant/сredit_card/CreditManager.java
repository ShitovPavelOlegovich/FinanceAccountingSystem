package first_variant.сredit_card;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreditManager extends CreditCard {
    private final static Scanner scanner = new Scanner(System.in);

//    public CreditManager(String name, double balance) {
//        super(name, balance);
//    }

    public void runCreditCard() {
        System.out.println("\n=== Работа с кредитными картами === " +
                "\n1) Отображение состояния конкретной кредитной карты. " +
                "\n2) Добавление новой кредитной карты. " +
                "\n3) Получение общей суммы по всем кредитным картам. " +
                "\n4) Внести дополнительные средства на кредитную карту." +
                "\n5) Снять денежные средства с кредитной карты. " +
                "\n6) Редактирование информации о кредитной карте. " +
                "\n7) Список всех кредитных карт. " +
                "\n8) Удаление кредитной карты. " +
                "\n9) Выход из программы. " +
                "\n --- Выберите действие:");

        boolean isRunning = true;
        while (isRunning) {
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> getCreditCard();
                    case 2 -> addCreditCard();
                    case 3 -> getTotalBalanceCreditCard();
                    case 4 -> depositCreditCard();
                    case 5 -> withdrawalCreditCard();
                    case 6 -> editCreditCard();
                    case 7 -> getAllCreditCard();
                    case 8 -> deleteCreditCard();
                    case 9 -> {
                        isRunning = false;
                        System.out.println("\n=== Возврат в основное меню ===");
                        System.out.println("Выберите действие из основного меню :");
                    }
                    default -> System.out.println("Введите номер из списка: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("введите номер из списка.");
                scanner.next();
            }
        }
    }

}
