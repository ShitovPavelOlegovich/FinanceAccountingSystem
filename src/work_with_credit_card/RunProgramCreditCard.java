package work_with_credit_card;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunProgramCreditCard {
    private final static Scanner scanner = new Scanner(System.in);
    public static void runCreditCard() {
        boolean isRunning = true;
        do {
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
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> GetCreditCardInformation.getInformation();
                    case 2 -> AddCreditCards.addCreditCard();
                    case 3 -> GetTotalBalanceCreditCard.getTotalBalance();
                    case 4 -> DepositCreditCard.deposit();
                    case 5 -> WithdrawalCreditCard.withdrawal();
                    case 6 -> EditCreditCard.edit();
                    case 7 -> GetAllCreditCard.listAllCreditCard();
                    case 8 -> DeleteCreditCard.delete();
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
        } while (isRunning);
    }
}
