package work_potential_incomes;

import work_potential_expenses.GetPotentialExpensesInformation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunProgramPotentialIncomes {
    private static final Scanner scanner = new Scanner(System.in);
    public static void runPotentialIncomes() {
        boolean isRunning = true;
        do {
        System.out.println("=== Работа со списком потенциальных доходов ===" +
                "\n1) Добавление нового потенциального дохода. " +
                "\n2) Добавление средств к определенному доходу. " +
                "\n3) Снятие средств с определенного дохода." +
                "\n4) Отображение списка потенциальных доходов. " +
                "\n5) Редактирование информации о потенциальном доходе. " +
                "\n6) Отображение состояния конкретного дохода." +
                "\n7) Получение общей суммы по всем доходам." +
                "\n8) Удаление потенциального дохода. " +
                "\n9) Выход в основное меню. " +
                "\n --- Выберите действие:");
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> AddPotentialIncomes.addPotentialIncomes();
                    case 2 -> DepositPotentialIncomes.depositPotentialIncomes();
                    case 3 -> WithdrawalPotentialIncomes.withdrawalPotentialIncomes();
                    case 4 -> GetAllPotentialIncomes.listPotentialIncomes();
                    case 5 -> EditPotentialIncomes.editPotentialIncomes();
                    case 6 -> GetPotentialIncomesInformation.getPotentialIncomes();
                    case 7 -> GetTotalBalancePotentialIncomes.getTotalBalancePotentialIncomes();
                    case 8 -> DeletePotentialIncomes.deletePotentialIncomes();
                    case 9 -> {
                        isRunning = false;
                        System.out.println("\n=== Возврат в основное меню ===");
                        System.out.println("Выберите действие из основного меню :");
                    }
                    default ->  System.out.println("Введите номер из списка. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите номер из списка. ");
                scanner.next();
            }
        } while (isRunning);
    }
}
