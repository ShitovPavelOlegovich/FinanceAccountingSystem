package work_with_wallets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunProgramWallet {
    private static final Scanner scanner = new Scanner(System.in);

    public static void runWallet() {
        boolean isRunning = true;
        do {
            System.out.println("\n=== Работа с кошельками ===" +
                    "\n1) Отображение состояния конкретного кошелька." +
                    "\n2) Добавление нового кошелька с указанием названия и начальной суммы." +
                    "\n3) Получение общей суммы по всем кошелькам." +
                    "\n4) Внести дополнительные денежные средства на кошелек. " +
                    "\n5) Снятия денежных средств с кошелька. " +
                    "\n6) Редактирование информации о кошельке. " +
                    "\n7) Список всех кошельков. " +
                    "\n8) Удаление кошелька." +
                    "\n9) Выход в основное меню. " +
                    "\n --- Выберите действие:");
                try {
                    int input = scanner.nextInt();
                    switch (input) {
                        case 1 -> GetWalletInformation.getInformation();
                        case 2 -> AddWallets.addWallet();
                        case 3 -> GetTotalBalanceWallets.getTotalBalance();
                        case 4 -> DepositWallets.depositWallet();
                        case 5 -> WithdrawalWallets.withdrawal();
                        case 6 -> EditWallets.edit();
                        case 7 -> GetAllWallets.listAllWallets();
                        case 8 -> DeleteWallets.deleteW();
                        case 9 -> {
                            isRunning = false;
                            System.out.println("\n=== Возврат в основное меню ===");
                            System.out.println("Выберите действие из основного меню :");
                        }
                        default -> System.out.println("Введите номер из списка: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Введите номер из списка. ");
                    scanner.next();
                }
        } while (isRunning);
    }
}
