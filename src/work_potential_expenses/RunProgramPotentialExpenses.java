package work_potential_expenses;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunProgramPotentialExpenses {
    private static final Scanner scanner = new Scanner(System.in);
    public static void runPotentialExpensesManager() {
        boolean isRunning = true;
        do {
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
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> AddPotentialExpenses.addPotentialExpenses();
                    case 2 -> DepositPotentialExpenses.deposit();
                    case 3 -> WithdrawalPotentialExpenses.withdrawal();
                    case 4 -> GetPotentialExpenses.listPotentialExpenses();
                    case 5 -> EditPotentialExpenses.edit();
                    case 6 -> GetPotentialExpensesInformation.getInformation();
                    case 7 -> GetTotalBalancePotentialExpenses.getTotalBalance();
                    case 8 -> DeletePotentialExpenses.delete();
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
