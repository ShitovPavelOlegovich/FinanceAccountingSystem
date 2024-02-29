package first_variant.сredit_card.potential_expenses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static potential_expenses.PotentialExpensesInfo.*;
public class PotentialExpenses {
    private final ArrayList<PotentialExpenses> expensesArrayList = new ArrayList<>();

    private String name;
    private double balance;

//    public PotentialExpenses(String name, double balance) {
//        this.name = name;
//        this.balance = balance;
//    }
    public static PotentialExpenses potentialExpenses(String name, double balance) {
        PotentialExpenses potentialExpenses = new PotentialExpenses();
        potentialExpenses.setName(name);
        potentialExpenses.setBalance(balance);
        return potentialExpenses;
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

    protected void addPotentialExpenses() {
        System.out.println(ADD_NEW_POTENTIAL_EXPENSES.getMassage());
        System.out.println(ENTER_POTENTIAL_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine().trim();
            System.out.println(ENTER_BALANCE_POTENTIAL_EXPENSES.getMassage());
            balance = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        expensesArrayList.add(potentialExpenses(name,balance));
        savingToAFile();
        System.out.println("=== Вы добавили новую затрату ===" +
                "\n⦁Название затраты: " + name +
                "\n⦁Сумма затраты: " + balance);
        System.out.println(ENTER_ACTION.getMassage());
    }

    protected void depositPotentialExpenses() {
        System.out.println(ADD_ADDITIONAL_AMOUNT.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine().trim();
        boolean found = false;
        for (PotentialExpenses potentialExpenses : expensesArrayList) {
            if (potentialExpenses.getName().equals(name)) {
                System.out.println(ENTER_SUM.getMassage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMassage());
                }
                potentialExpenses.setBalance(potentialExpenses.getBalance() + balance);
                savingToAFile();
                System.out.println("Вы добавили к основной сумме " +
                        "\"" + balance + "\"" + " руб.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Затраты с таким именем" + "\"" + name + "\"" + "не существует.");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }

    protected void withdrawalPotentialExpenses() {
        System.out.println(WITHDRAWAL_SUM.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine().trim();
        boolean found = false;
        for (PotentialExpenses potentialExpenses : expensesArrayList) {
            if (potentialExpenses.getName().equals(name)) {
                System.out.println(ENTER_SUM.getMassage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMassage());
                }
                potentialExpenses.setBalance(potentialExpenses.getBalance() - balance);
                savingToAFile();
                System.out.println("Вы сняли с основной суммы " +
                        "\"" + balance + "\"" + " руб.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Затраты с таким именем" + "\"" + name + "\"" + "не существует.");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void editPotentialExpenses() {
        System.out.println(EDITING_POTENTIAL_EXPENSES_INFORMATION.getMassage());
        System.out.println(ENTER_POTENTIAL_EXPENSES_EDIT_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        try {
            name = scanner.nextLine().trim();
            int index = -1;
            for (int i = 0; i < expensesArrayList.size(); i++) {
                if (expensesArrayList.get(i).getName().equals(name)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("Затраты с таким названием" + "\"" + name + "\"" + "не существует.");
                System.out.println(ENTER_ACTION.getMassage());
                return;
            }
            System.out.println(ENTER_NEW_NAME.getMassage());
            name = scanner1.nextLine().trim();
            System.out.println(ENTER_NEW_SUM.getMassage());
            balance = scanner.nextDouble();

            expensesArrayList.set(index, potentialExpenses(name,balance));
            savingToAFile();
            System.out.println("Вы успешно отредактировали затрату.");
            System.out.println(ENTER_ACTION.getMassage());


        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
    }
    protected void deletePotentialExpenses() {
        System.out.println(DELETE_POTENTIAL_EXPENSES.getMassage());
        System.out.println(ENTER_NAME_POTENTIAL_EXPENSES_DELETE.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine().trim();
        }catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        boolean found = false;
        for (PotentialExpenses potentialExpenses : expensesArrayList) {
            if (potentialExpenses.getName().equals(name)) {
                expensesArrayList.remove(potentialExpenses);
                savingToAFile();
                System.out.println("Вы удалили затрату под назавнием " + "\"" + name + "\"");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Затраты с данным именем " + "\"" + name + "\"" + " не существует. ");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void getTotalBalancePotentialExpenses() {
        double totalBalance = 0;
        for (PotentialExpenses potentialExpenses : expensesArrayList) {
            totalBalance += potentialExpenses.getBalance();
        }
        System.out.println("Общая сумма по затратам: " + totalBalance + " руб.");
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void getPotentialExpenses() {
        System.out.println(INFORMATION_POTENTIAL_EXPENSES.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);

        try {
            name = scanner.nextLine().trim();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        boolean found = false;
        for (PotentialExpenses potentialExpenses : expensesArrayList) {
            if (potentialExpenses.getName().equals(name)) {
                System.out.println("Информация о затрате под названием: " + "\"" + name + "\""
                        + potentialExpenses);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Затраты с названием " + "\"" + name + "\"" + " не найдено. ");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }

    protected ArrayList<PotentialExpenses> getAllPotentialExpenses() {
        System.out.println(LIST_POTENTIAL_EXPENSES.getMassage());
        if (expensesArrayList.isEmpty()) {
            System.out.println(LIST_IS_EMPTY.getMassage());
        } else {
            for (PotentialExpenses potentialExpenses : expensesArrayList) {
                System.out.println(potentialExpenses);
            }
        } System.out.println(ENTER_ACTION.getMassage());
        return expensesArrayList;
    }

    private void savingToAFile() {
        File file = new File("data/list_PotentialExpenses");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("Список работы с текущими затратами: ");
            for (PotentialExpenses potentialExpenses : expensesArrayList) {
                bufferedWriter.write(String.valueOf(potentialExpenses));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name + "\n" + balance;
    }
}
