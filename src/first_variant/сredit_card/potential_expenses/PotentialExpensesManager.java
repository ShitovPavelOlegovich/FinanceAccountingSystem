package first_variant.сredit_card.potential_expenses;

import java.util.InputMismatchException;
import java.util.Scanner;
public class PotentialExpensesManager extends PotentialExpenses {
    private final Scanner scanner = new Scanner(System.in);

//    public PotentialExpensesManager(String name, double balance) {
//        super(name, balance);
//    }

    public void runPotentialExpensesManager() {
        System.out.println("=== Работа со списком потенциальных затрат ===" +
                "\n1) Добавление новой потенциальной затраты. " +
                "\n2) Добавление средств к определенной затрате. " +
                "\n3) Снятие средств с определенной затраты." +
                "\n4) Отображение списка потенциальных затрат. " +
                "\n5) Редактирование информации о потенциальной затрате. " +
                "\n6) Отображение состояния конкретной затраты." +
                "\n7) Получение общей суммы по всем затратам." +
                "\n8) Удаление потенциальной затраты. " +
                "\n9) Выход в основное меню. " +
                "\n --- Выберите действие:");

        boolean isRunning = true;
        while (isRunning) {
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> addPotentialExpenses();
                    case 2 -> depositPotentialExpenses();
                    case 3 -> withdrawalPotentialExpenses();
                    case 4 -> getAllPotentialExpenses();
                    case 5 -> editPotentialExpenses();
                    case 6 -> getPotentialExpenses();
                    case 7 -> getTotalBalancePotentialExpenses();
                    case 8 -> deletePotentialExpenses();
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
