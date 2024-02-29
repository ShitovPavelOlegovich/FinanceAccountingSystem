package start_program;

import verification.VerificationLoginPassword;
import work_current_expenses.RunProgramCurrentExpenses;
import work_potential_expenses.RunProgramPotentialExpenses;
import work_potential_incomes.RunProgramPotentialIncomes;
import work_with_credit_card.GetTotalBalanceCreditCard;
import work_with_credit_card.RunProgramCreditCard;
import work_with_wallets.GetTotalBalanceWallets;
import work_with_wallets.RunProgramWallet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartManager {
    private final static Scanner scanner = new Scanner(System.in);

    public static boolean auth() {
        VerificationLoginPassword verificationLoginPassword = new VerificationLoginPassword();
        System.out.println("=== Система учета финансов ===");
        System.out.println("1)Авторизация." +
                "\n2)Регистрация.");
        switch (new Scanner(System.in).nextInt()) {
            case 1 -> {
                if (verificationLoginPassword.verification()) {
                    return true;
                }
            }
            case 2 -> {
                verificationLoginPassword.register();
                return true;
            }
        }
        return false;
    }
    public static void start() {
        if (auth()) {
            System.out.println("=== Система учета финансов ===" +
                    "\n1) Работа с кошельками. " +
                    "\n2) Работа с кредитными картами. " +
                    "\n3) Получение общей суммы по кошелькам и картам. " +
                    "\n4) Работа со списком потенциальных затрат. " +
                    "\n5) Работа со списком текущих затрат. " +
                    "\n6) Работа со списком потенциальных доходов. " +
                    "\n7) Выход из приграммы. " +
                    "\n --- Выберите действие: ");


            boolean isRunning = true;
            while (isRunning) {
                try {
                    int input = scanner.nextInt();
                    switch (input) {
                        case 1 -> RunProgramWallet.runWallet();
                        case 2 -> RunProgramCreditCard.runCreditCard();
                        case 3 -> {
                            GetTotalBalanceWallets.getTotalBalanceWallets();
                            GetTotalBalanceCreditCard.getTotalBalanceCreditCard();
                        }
                        case 4 -> RunProgramPotentialExpenses.runPotentialExpensesManager();
                        case 5 -> RunProgramCurrentExpenses.runCurrentExpensesManager();
                        case 6 -> RunProgramPotentialIncomes.runPotentialIncomes();
                        case 7 -> isRunning = false;
                        default -> System.out.println("Выберите действие из основного меню: ");
                    }
                    if (input == 7) {
                        System.out.println("=== Выход === " +
                                "\n" + "\nСпасибо за использование системы учета финансов!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Выберите действие из основного меню: ");
                    scanner.next();
                }
            }
        }
    }
}

