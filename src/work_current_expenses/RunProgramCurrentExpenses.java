package work_current_expenses;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunProgramCurrentExpenses {
    private final static Scanner scanner = new Scanner(System.in);

    public static void runCurrentExpensesManager() {
        boolean isRunning = true;
        do{
        System.out.println("=== Работа со списком текущих затрат ===" +
                "\n1) Добавление новой текущей затраты. " +
                "\n2) Добавление средств к определенной затрате. " +
                "\n3) Снятие средств с определенной затраты." +
                "\n4) Отображение списка текущих затрат. " +
                "\n5) Редактирование информации о текущей затрате. " +
                "\n6) Отображение состояния текущей затраты." +
                "\n7) Получение общей суммы по всем затратам." +
                "\n8) Удаление текущей затраты. " +
                "\n9) Выход в основное меню. " +
                "\n --- Выберите действие:");

            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> AddCurrentExpenses.addCurrentExpenses();
                    case 2 -> DepositCurrentExpenses.deposit();
                    case 3 -> WithdrawalCurrentExpenses.withdrawal();
                    case 4 -> GetCurrentExpenses.listAllCurrentExpenses();
                    case 5 -> EditCurrentExpenses.edit();
                    case 6 -> GetCurrentExpensesInformation.getInformation();
                    case 7 -> GetTotalBalanceCurrentExpenses.getTotalBalance();
                    case 8 -> DeleteCurrentExpenses.delete();
                    case 9 -> {
                        isRunning = false;
                        System.out.println("\n=== Возврат в основное меню ===");
                        System.out.println("Выберите действие из основного меню :");
                    }
                    default -> System.out.println("Введите номер из списка. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите номер из списка. ");
                scanner.next();
            }
        } while (isRunning);
    }
}
