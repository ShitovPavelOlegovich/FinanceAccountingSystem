package first_variant.сredit_card;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static сredit_card.CreditCardInfo.*;

public class CreditCard {
    private String name;
    private double balance;

    private static final ArrayList<CreditCard> arrayListCredit = new ArrayList<>();
//    private static final DecimalFormat decimalFormat = new DecimalFormat("$#.##");


//    public CreditCard(String name, double balance) {
//        this.name = name;
//        this.balance = balance;
//
//    }

    public static CreditCard creditCard(String name, double balance) {
        CreditCard creditCard = new CreditCard();
        creditCard.setName(name);
        creditCard.setBalance(balance);
        return creditCard;
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

    protected void addCreditCard() {
        System.out.println(ENTER_NEW_CREDIT_CARD.getMassage());
        System.out.println(ENTER_NAME_CREDIT_CARD.getMassage());

        try {
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine().trim();
            System.out.println(ENTER_BALANCE_CREDIT_CARD.getMassage());
            balance = scanner.nextDouble();

            arrayListCredit.add(creditCard(name, balance));
            safeInfoCreditCard();
            System.out.println(" === Вы добавили новую кредитную карту === " +
                    "\nНазвание кошелька: " + name +
                    "\nБаланс: " + balance + "$");
            System.out.println(ENTER_ACTION.getMassage());

        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
    }
    protected void depositCreditCard() {
        System.out.println(ENTER_NAME_CARD_DEPOSIT.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine().trim();
        boolean found = false;
        for (CreditCard creditCard : arrayListCredit) {
            if (creditCard.getName().equals(name)) {
                System.out.println(ENTER_ADD_SUM.getMassage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMassage());
                    return;
                }
                creditCard.setBalance(creditCard.getBalance() + balance);
                safeInfoCreditCard();
                System.out.println("Вы добавили к основной сумме " +
                        "\"" + balance + "\"" + " $.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Кредитной карты с данным " + "\"" + name + "\"" + " не существует.");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void withdrawalCreditCard() {
        System.out.println(ENTER_NAME_CARD_WITHDRAWAL.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine().trim();
        boolean found = false;
        for (CreditCard creditCard : arrayListCredit) {
            if (creditCard.getName().equals(name)) {
                System.out.println(ENTER_WITHDRAWAL_SUM.getMassage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMassage());
                    return;
                }
                creditCard.setBalance(creditCard.getBalance() - balance);
                safeInfoCreditCard();
                System.out.println("Вы сняли с основной сумме " +
                        "\"" + balance + "\"" + " $.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Кредитной карты с данным " + "\"" + name + "\"" + " не существует.");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void editCreditCard() {
        System.out.println(EDITING_CREDIT_CARD_INFORMATION.getMassage());
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        try {
            System.out.println(ENTER_CARD_EDIT_NAME.getMassage());
            name = scanner.nextLine().trim();

            int index = -1;
            for (int i = 0; i < arrayListCredit.size(); i++) {
                if (arrayListCredit.get(i).getName().equals(name)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("Кредитной карты с данным " + "\"" + name + "\"" + " не существует.");
                System.out.println(ENTER_ACTION.getMassage());
                return;
            }

            System.out.println(ENTER_NEW_NAME_CARD.getMassage());
            name = scanner1.nextLine().trim();

            System.out.println(ENTER_NEW_BALANCE_CARD.getMassage());
            balance = scanner.nextDouble();

            arrayListCredit.set(index, creditCard(name, balance));
            safeInfoCreditCard();
            System.out.println("Вы успешно отредактировали кредитную карту под именем: " + "\"" + name + "\"");
            System.out.println(ENTER_ACTION.getMassage());


            } catch (Exception e) {
                System.out.println(INVALID_INPUT.getMassage());
        }

    }
    protected void deleteCreditCard() {
        System.out.println(DELETE_CREDIT_CARD.getMassage());
        System.out.println(ENTER_NAME_CARD_DELETE.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        boolean found = false;
        for (CreditCard creditCard : arrayListCredit) {
            if (creditCard.getName().equals(name)) {
                arrayListCredit.remove(creditCard);
                safeInfoCreditCard();
                System.out.println("Вы удалили кредитную карту под именем: " + "\"" + name + "\"");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Кредитная карта с данным именем " + "\"" + name + "\"" + " не существует. ");
        }
        System.out.println(ENTER_ACTION.getMassage());

    }

    protected void getTotalBalanceCreditCard() {
        System.out.println(TOTAL_BALANCE_CREDIT_CARD.getMassage());
        double totalBalance = 0;
        for (CreditCard creditCard : arrayListCredit) {
            totalBalance += creditCard.getBalance();
        }
        System.out.println("\nОбщая сумма по кредитным картам: " + totalBalance + "$");
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void getCreditCard() {
        System.out.println(STATUS_SPECIFIC_CREDIT_CARD.getMassage());
        System.out.println(ENTER_NAME_CARD_STATUS_SPECIFIC.getMassage());

        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine().trim();

        try {
            boolean found = false;
            for (CreditCard creditCard : arrayListCredit) {
                if (creditCard.getName().equals(name)) {
                    System.out.println("Информация по кредитной карте с именем " + "\"" + name + "\""
                    + creditCard);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Кредитная карта с данным именем " + "\"" + name + "\"" + " не найдена. ");
            }
            System.out.println(ENTER_ACTION.getMassage());

        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMassage());
        }

    }
    protected ArrayList<CreditCard> getAllCreditCard() {
        System.out.println(LIST_ALL_CREDIT_CARD.getMassage());
        if (arrayListCredit.isEmpty()) {
            System.out.println(LIST_IS_EMPTY.getMassage());
        } else {
            for (CreditCard creditCard : arrayListCredit) {
                System.out.println(creditCard);

            }
        } System.out.println(ENTER_ACTION.getMassage());
        return arrayListCredit;
    }

    private void safeInfoCreditCard() {
        File file = new File("data/list_CreditCard.txt");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("Список работы с кредитными картами: ");
            for (CreditCard creditCard : arrayListCredit) {
                bufferedWriter.write(String.valueOf(creditCard));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getCardBalance() {
        double totalBalance = 0;
        for (CreditCard creditCard : arrayListCredit) {
            totalBalance += creditCard.getBalance();
        }
        System.out.println("Общая сумма по кредитным картам: " + totalBalance + "$");
        System.out.println(ENTER_ACTION.getMassage());
    }

    @Override
    public String toString() {
        return name + "\n" + balance;

    }
}
