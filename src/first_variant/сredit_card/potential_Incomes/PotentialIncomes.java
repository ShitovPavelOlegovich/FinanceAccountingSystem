package first_variant.сredit_card.potential_Incomes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static potential_Incomes.PotentialIncomesInfo.*;
public class PotentialIncomes {
    private final ArrayList<PotentialIncomes> incomesArrayList = new ArrayList<>();
    private String name;
    private double balance;

//    public PotentialIncomes(String name, double balance) {
//        this.name = name;
//        this.balance = balance;
//    }
    public static PotentialIncomes potentialIncomes(String name, double balance) {
        PotentialIncomes potentialIncomes = new PotentialIncomes();
        potentialIncomes.setName(name);
        potentialIncomes.setBalance(balance);
        return potentialIncomes;
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

    protected void addPotentialIncomes() {
        System.out.println(ADD_NEW_POTENTIAL_INCOMES.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine().trim();
            System.out.println(ENTER_SUM.getMassage());
            balance = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        incomesArrayList.add(potentialIncomes(name,balance));
        savingToFile();
        System.out.println("=== Вы добавили новый потенциальный доход ===" +
                "\n⦁Название дохода: " + name +
                "\n⦁Сумма дохода: " + balance);
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void depositPotentialIncomes() {
        System.out.println(ADD_ADDITIONAL_AMOUNT.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine().trim();
        boolean found = false;
        for (PotentialIncomes potentialIncomes : incomesArrayList) {
            if (potentialIncomes.getName().equals(name)) {
                System.out.println(ENTER_SUM.getMassage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMassage());
                }
                potentialIncomes.setBalance(potentialIncomes.getBalance() + balance);
                savingToFile();
                System.out.println("Вы добавили к основной сумме " +
                        "\"" + balance + "\"" + " руб.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Дохода с таким именем" + "\"" + name + "\"" + "не существует.");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void withdrawalPotentialIncomes() {
        System.out.println(WITHDRAWAL_SUM.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine().trim();
        boolean found = false;
        for (PotentialIncomes potentialIncomes : incomesArrayList) {
            if (potentialIncomes.getName().equals(name)) {
                System.out.println(ENTER_SUM.getMassage());
                try {
                    balance = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(INVALID_INPUT.getMassage());
                }
                potentialIncomes.setBalance(potentialIncomes.getBalance() - balance);
                savingToFile();
                System.out.println("Вы сняли к основной сумме " +
                        "\"" + balance + "\"" + " руб.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Дохода с таким именем" + "\"" + name + "\"" + "не существует.");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void editPotentialIncomes() {
        System.out.println(EDITING_POTENTIAL_INCOMES_INFORMATION.getMassage());
        System.out.println(ENTER_POTENTIAL_INCOMES_EDIT_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        try {
            name = scanner.nextLine().trim();
            int index = -1;
            for (int i = 0; i < incomesArrayList.size(); i++) {
                if (incomesArrayList.get(i).getName().equals(name)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("Дохода с таким названием" + "\"" + name + "\"" + "не существует.");
                System.out.println(ENTER_ACTION.getMassage());
                return;
            }
            System.out.println(ENTER_NEW_NAME.getMassage());
            name = scanner1.nextLine().trim();
            System.out.println(ENTER_NEW_SUM.getMassage());
            balance = scanner.nextDouble();

            incomesArrayList.set(index,potentialIncomes(name,balance));
            savingToFile();
            System.out.println("Вы успешно отредактировали потенциальный доход. ");
            System.out.println(ENTER_ACTION.getMassage());
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
    }
    protected void deletePotentialIncomes() {
        System.out.println(DELETE_POTENTIAL_INCOMES.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine().trim();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        boolean found = false;
        for (PotentialIncomes potentialIncomes : incomesArrayList) {
            if (potentialIncomes.getName().equals(name)) {
                incomesArrayList.remove(potentialIncomes);
                System.out.println("Вы удалили доход под назавнием " + "\"" + name + "\"");
                savingToFile();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Дохода с данным именем " + "\"" + name + "\"" + " не существует. ");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }


    protected void getTotalBalancePotentialIncomes() {
        System.out.println("=== Общий баланс потенциальных доходов ===");
        double totalBalance = 0;
        for (PotentialIncomes potentialIncomes : incomesArrayList) {
            totalBalance += potentialIncomes.getBalance();
        }
        System.out.println("\nОбщая сумма по доходам: " + totalBalance + " руб.");
        System.out.println(ENTER_ACTION.getMassage());
    }
    protected void getPotentialIncomes() {
        System.out.println(INFORMATION_POTENTIAL_INCOMES.getMassage());
        System.out.println(ENTER_NAME.getMassage());
        Scanner scanner = new Scanner(System.in);
        try {
            name = scanner.nextLine().trim();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT.getMassage());
        }
        boolean found = false;
        for (PotentialIncomes potentialIncomes : incomesArrayList) {
            if (potentialIncomes.getName().equals(name)) {
                System.out.println("Информация о доходе под названием: " + "\"" + name + "\""
                        + potentialIncomes);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Дохода с названием " + "\"" + name + "\"" + " не найдено. ");
        }
        System.out.println(ENTER_ACTION.getMassage());
    }

    protected ArrayList<PotentialIncomes> getAllPotentialIncomes() {
        System.out.println(LIST_POTENTIAL_INCOMES.getMassage());
        if (incomesArrayList.isEmpty()) {
            System.out.println(LIST_IS_EMPTY.getMassage());
        } else {
            for (PotentialIncomes potentialIncomes : incomesArrayList) {
                System.out.println(potentialIncomes);
            }
        }
        System.out.println(ENTER_ACTION.getMassage());
        return incomesArrayList;
    }

    private void savingToFile() {
        File file = new File("data/list_PotentialIncomes");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("Список по потенциальным доходам: ");
            for (PotentialIncomes potentialIncomes : incomesArrayList) {
                bufferedWriter.write(String.valueOf(potentialIncomes));
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
