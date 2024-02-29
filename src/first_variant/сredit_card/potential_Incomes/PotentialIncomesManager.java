package first_variant.сredit_card.potential_Incomes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PotentialIncomesManager extends PotentialIncomes {
    private static final Scanner scanner = new Scanner(System.in);

//    public PotentialIncomesManager(String name, double balance) {
//        super(name, balance);
//    }

    public void renPotentialIncomes() {
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

        boolean isRunning = true;
        while (isRunning) {
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> addPotentialIncomes();
                    case 2 -> depositPotentialIncomes();
                    case 3 -> withdrawalPotentialIncomes();
                    case 4 -> getAllPotentialIncomes();
                    case 5 -> editPotentialIncomes();
                    case 6 -> getPotentialIncomes();
                    case 7 -> getTotalBalancePotentialIncomes();
                    case 8 -> deletePotentialIncomes();
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
        }
    }
}
