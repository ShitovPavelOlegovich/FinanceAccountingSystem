package work_with_wallets;

import WorkWithFile.AddInFile;
import WorkWithFile.FileConstants;
import wallet.Wallet;

import java.util.Scanner;

import static wallet.WalletInfo.*;

public class AddWallets {
    static String name;
    static double balance;
    public static void addWallet() {
        Wallet wallet = new Wallet();
        System.out.println(ENTER_NEW_WALLET.getMessage());
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(ENTER_WALLET_NAME.getMessage());
            name = scanner.next().trim();
            wallet.setName(name);
            System.out.println(ENTER_WALLET_BALANCE.getMessage());
            balance = scanner.nextDouble();
            wallet.setBalance(balance);
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMessage());
        }

        AddInFile.writeFile(FileConstants.PATH_WALLET + wallet.getName() + ".txt", wallet.toString());
        System.out.println(" === Вы добавили новый кошелек === " +
                    "\n⦁Название кошелька: " + name +
                    "\n⦁Баланс: " + balance);
        System.out.println(ENTER_ACTION.getMessage());
    }
}
