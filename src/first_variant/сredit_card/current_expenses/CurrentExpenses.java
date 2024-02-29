package first_variant.сredit_card.current_expenses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static current_expenses.CurrentExpensesInfo.*;
public class CurrentExpenses {
    private String name;
    private double balance;

    private static final ArrayList<CurrentExpenses> arrayListCurrent = new ArrayList<>();
    public static CurrentExpenses currentExpenses(String name, double balance) {
        CurrentExpenses currentExpenses = new CurrentExpenses();
        currentExpenses.setName(name);
        currentExpenses.setBalance(balance);
        return currentExpenses;
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

    protected void addCurrentExpenses() {
        System.out.println(ADD_NEW_CURRENT_EXPENSES.getMassage());
        System.out.println(ENTER_CURRENT_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine().trim();
            System.out.println(ENTER_BALANCE_CURRENT_EXPENSES.getMassage());
            balance = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        arrayListCurrent.add(currentExpenses(name,balance));
        savingToFile();
        System.out.println("=== Вы добавили новую затрату ===" +
                "\n⦁Название затраты: " + name +
                "\n⦁Сумма затраты: " + balance);
        System.out.println(ENTER_ACTION.getMassage());
    }

    protected void depositCurrentExpenses() {
        System.out.println(ADD_ADDITIONAL_AMOUNT.getMassage());
        System.out.println(ENTER_CURRENT_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine().trim();
        boolean found = false;
        for (CurrentExpenses currentExpenses : arrayListCurrent) {
            if (currentExpenses.getName().equals(name)) {
                System.out.println(ENTER_SUM.getMassage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMassage());
                }
                currentExpenses.setBalance(currentExpenses.getBalance() + balance);
                savingToFile();
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

    protected void withdrawalCurrentExpenses() {
        System.out.println(WITHDRAWAL_SUM.getMassage());
        System.out.println(ENTER_CURRENT_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine().trim();
        boolean found = false;
        for (CurrentExpenses currentExpenses : arrayListCurrent) {
            if (currentExpenses.getName().equals(name)) {
                System.out.println(ENTER_SUM.getMassage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMassage());
                }
                currentExpenses.setBalance(currentExpenses.getBalance() - balance);
                savingToFile();
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

    protected void editCurrentExpenses() {
        System.out.println(EDITING_CURRENT_EXPENSES_INFORMATION.getMassage());
        System.out.println(ENTER_CURRENT_EXPENSES_EDIT_NAME.getMassage());

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        try {
            name = scanner.nextLine().trim();

            int index = -1;
            for (int i = 0; i < arrayListCurrent.size(); i++) {
                if (arrayListCurrent.get(i).getName().equals(name)) {
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

            arrayListCurrent.set(index,currentExpenses(name,balance));
            savingToFile();
            System.out.println("Вы успешно отредактировали затрату.");
            System.out.println(ENTER_ACTION.getMassage());

        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
    }
    protected void deleteCurrentExpenses() {
        System.out.println(DELETE_CURRENT_EXPENSES.getMassage());
        System.out.println(ENTER_CURRENT_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine().trim();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        boolean found = false;
        for (CurrentExpenses currentExpenses : arrayListCurrent) {
            if (currentExpenses.getName().equals(name)) {
                arrayListCurrent.remove(currentExpenses);
                savingToFile();
                System.out.println("Вы удалили затрату под назавнием " + "\"" + name + "\"");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Затраты с таким именем" + "\"" + name + "\"" + "не существует.");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void getTotalBalanceCurrentExpenses() {
        System.out.println(TOTAL_BALANCE.getMassage());
        double totalBalance = 0;
        for (CurrentExpenses currentExpenses : arrayListCurrent) {
            totalBalance += currentExpenses.getBalance();
        }
        System.out.println("Общая сумма по затратам: " + totalBalance + " руб.");
        System.out.println(ENTER_ACTION.getMassage());
    }

    protected void getCurrentExpenses() {
        System.out.println(INFORMATION_CURRENT_EXPENSES.getMassage());
        System.out.println(ENTER_CURRENT_EXPENSES.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine().trim();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        boolean found = false;
        for (CurrentExpenses currentExpenses : arrayListCurrent) {
            if (currentExpenses.getName().equals(name)) {
                System.out.println("Информация о затрате под названием: " + "\"" + name + "\""
                        + currentExpenses);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Затраты с таким именем" + "\"" + name + "\"" + "не существует.");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }

    protected ArrayList<CurrentExpenses> getAllCurrentExpenses() {
        System.out.println(LIST_CURRENT_EXPENSES.getMassage());
       if (arrayListCurrent.isEmpty()) {
           System.out.println(LIST_IS_EMPTY.getMassage());
       } else {
           for (CurrentExpenses currentExpenses : arrayListCurrent) {
               System.out.println(currentExpenses);
           }
           System.out.println(ENTER_ACTION.getMassage());
       } return arrayListCurrent;
    }
    private void savingToFile() {
        File file = new File("data/list_CurrentExpenses");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("Список работы с текущими затратами: ");
            for (CurrentExpenses currentExpenses : arrayListCurrent) {
                bufferedWriter.write(String.valueOf(currentExpenses));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name + "\n" + balance;
    }
}
