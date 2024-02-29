package first_variant.сredit_card.current_expenses;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrentExpensesManager extends CurrentExpenses {
    private final static Scanner scanner = new Scanner(System.in);

    public void runCurrentExpensesManager() {
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

        boolean isRunning = true;
        while (isRunning) {
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> addCurrentExpenses();
                    case 2 -> depositCurrentExpenses();
                    case 3 -> withdrawalCurrentExpenses();
                    case 4 -> getAllCurrentExpenses();
                    case 5 -> editCurrentExpenses();
                    case 6 -> getCurrentExpenses();
                    case 7 -> getTotalBalanceCurrentExpenses();
                    case 8 -> deleteCurrentExpenses();
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
        }
    }

}
