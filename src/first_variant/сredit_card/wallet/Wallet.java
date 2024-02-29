package first_variant.сredit_card.wallet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static wallet.WalletInfo.*;

public class Wallet {
    private String name;
    private double balance;
    private static final ArrayList<Wallet> arrayList = new ArrayList<>();

    public static Wallet createWallet(String name, double balance) {
        Wallet wallet = new Wallet();
        wallet.setName(name);
        wallet.setBalance(balance);
        return wallet;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    protected void addWallet() {
        System.out.println(ENTER_NEW_WALLET.getMessage());
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(ENTER_WALLET_NAME.getMessage());
            String name = scanner.nextLine().trim();

            System.out.println(ENTER_WALLET_BALANCE.getMessage());
            double balance = scanner.nextDouble();

            arrayList.add(createWallet(name,balance));
            savingToAFile();

            System.out.println(" === Вы добавили новый кошелек === " +
                    "\n⦁Название кошелька: " + name +
                    "\n⦁Баланс: " + balance);
            System.out.println(ENTER_ACTION.getMessage());
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMessage());
        }

    }
    protected void depositWallet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_NAME_WALLET_DEPOSIT.getMessage());
        name = scanner.nextLine().trim();
        boolean found = false;
        for (Wallet wallet : arrayList) {
            if (wallet.getName().equals(name)) {
                System.out.println(ENTER_ADD_SUM.getMessage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMessage());
                    return;
                }
                wallet.setBalance(wallet.getBalance() + balance);
                savingToAFile();
                System.out.println("Вы добавили к основной сумме " +
                        "\"" + balance + "\"" + " руб.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Кошелек с таким именем" + "\"" + name + "\"" + "не существует.");
        }
        System.out.println(ENTER_ACTION.getMessage());
    }

    protected void withdrawalWallet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_NAME_WALLET_WITHDRAWAL.getMessage());
        name = scanner.nextLine().trim();
        boolean found = false;
        for (Wallet wallet : arrayList) {
            if (wallet.getName().equals(name)) {
                System.out.println(ENTER_WITHDRAWAL_SUM.getMessage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMessage());
                    return;
                }
                wallet.setBalance(wallet.getBalance() - balance);
                savingToAFile();
                System.out.println("Вы сняли с основной суммы " +
                        "\"" + balance + "\"" + " руб.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Кошелек с таким именем" + "\"" + name + "\"" + "не существует.");
        }
        System.out.println(ENTER_ACTION.getMessage());
    }

    protected void editWallet() {
        System.out.println(EDITING_WALLET_INFORMATION.getMessage());
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);

            try {
                System.out.println(ENTER_WALLET_EDIT_NAME.getMessage());
            name = scanner.nextLine().trim();

            int index = -1;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getName().equals(name)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("Кошелек с таким именем" + "\"" + name + "\"" + "не существует.");
                System.out.println(ENTER_ACTION.getMessage());
                return;
            }

            System.out.println(ENTER_WALLET_NEW_NAME.getMessage());
            name = scanner1.nextLine().trim();

            System.out.println(ENTER_WALLET_NEW_BALANCE.getMessage());
            balance = scanner.nextDouble();

//            arrayList.set(index, new Wallet(name, balance));
                arrayList.set(index,createWallet(name,balance));
            savingToAFile();
            System.out.println("Вы успешно отредактировали кошелек под именем: " + "\"" + name + "\"");
            System.out.println(ENTER_ACTION.getMessage());
        } catch (Exception e) {
                System.out.println(INVALID_INPUT.getMessage());
        }

    }

    protected void deleteWallet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(DELETE_WALLET.getMessage());
        System.out.println(ENTER_WALLET_DELETE_NAME.getMessage());
        try {
            name = scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMessage());
        }
//        Iterator<Wallet> iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            Wallet wallet = iterator.next();
//            if (wallet.getName().equals(name)) {
//                iterator.remove();
//                savingToAFile();
//                System.out.println("Вы удалили кошелек под именем: " + "\"" + name + "\"");
//                System.out.println(ENTER_ACTION.getMessage());
//                break;
//            } else {
//                System.out.println("Кошелек с данным именем " + "\"" + name + "\"" + " не существует. ");
//                System.out.println(ENTER_ACTION.getMessage());
//            }
//        }
        boolean found = false;
        for (Wallet wallet : arrayList) {
            if (wallet.getName().equals(name)) {
                arrayList.remove(wallet);
                savingToAFile();
                System.out.println("Вы удалили кошелек под именем: " + "\"" + name + "\"");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Кошелек с данным именем " + "\"" + name + "\"" + " не существует. ");
        }
        System.out.println(ENTER_ACTION.getMessage());
    }
    protected void getTotalBalance() {
        System.out.println(TOTAL_BALANCE_WALLET.getMessage());
        double totalBalance = 0;
        for (Wallet wallet : arrayList) {
            totalBalance += wallet.getBalance();
        }
        System.out.println("\nОбщая сумма по кошелькам: " + totalBalance);
        System.out.println(ENTER_ACTION.getMessage());
    }
    protected ArrayList<Wallet> getAllWallet() {
        System.out.println(LIST_ALL_WALLET.getMessage());
        if (arrayList.isEmpty()) {
            System.out.println(LIST_IS_EMPTY.getMessage());
        } else {
            for (Wallet item : arrayList) {
                System.out.println(item);
            }

        } System.out.println(ENTER_ACTION.getMessage());
        return arrayList;

    }
    protected void getWallet() {
        System.out.println(STATUS_SPECIFIC_WALLET.getMessage());
        System.out.println(ENTER_NAME_WALLET_STATUS_SPECIFIC.getMessage());

        try {
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine().trim();
            boolean found = false;
            for (Wallet wallet : arrayList) {
            if (wallet.getName().equals(name)) {
                System.out.println("Информация о кошельке под именем: " + "\"" + name + "\""
                        + wallet);
                found = true;
                break;

                }
            }
            if (!found){
                System.out.println("Кошелек с именем " + "\"" + name + "\"" + " не найден. ");
            }
            System.out.println(ENTER_ACTION.getMessage());

        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMessage());
        }
    }

    private void savingToAFile() {
        File file = new File("data/list_Wallet.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("Список работы с кошельками: ");
            for (Wallet str : arrayList) {
                writer.write(String.valueOf(str));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getWalletBalance() {
        double totalBalance = 0;
        for (Wallet wallet : arrayList) {
            totalBalance += wallet.getBalance();
        }
        System.out.println("\nОбщая сумма по кошелькам: " + totalBalance);
    }

    @Override
    public String toString() {
        return  name + "\n" + balance;
    }

}
