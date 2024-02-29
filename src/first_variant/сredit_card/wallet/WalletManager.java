package first_variant.сredit_card.wallet;


import java.util.InputMismatchException;
import java.util.Scanner;

public class WalletManager extends Wallet {
    private final Scanner scanner = new Scanner(System.in);

   public void runWallet() {
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

       boolean isRunning = true;
       while (isRunning) {
           try {
               int input = scanner.nextInt();
               switch (input) {
                   case 1 -> getWallet();
                   case 2 -> addWallet();
                   case 3 -> getTotalBalance();
                   case 4 -> depositWallet();
                   case 5 -> withdrawalWallet();
                   case 6 -> editWallet();
                   case 7 -> getAllWallet();
                   case 8 -> deleteWallet();
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
       }
   }

}
