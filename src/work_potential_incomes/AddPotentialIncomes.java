package work_potential_incomes;

import WorkWithFile.AddInFile;
import WorkWithFile.FileConstants;
import potential_Incomes.PotentialIncomes;
import java.util.Scanner;

import static potential_Incomes.PotentialIncomesInfo.*;
import static potential_Incomes.PotentialIncomesInfo.ENTER_ACTION;
import static potential_Incomes.PotentialIncomesInfo.INVALID_INPUT;


public class AddPotentialIncomes {
    static String name;
    static double balance;
    public static void addPotentialIncomes() {
        PotentialIncomes potentialIncomes = new PotentialIncomes();
        System.out.println(ADD_NEW_POTENTIAL_INCOMES.getMassage());
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(ENTER_NAME.getMassage());
            name = scanner.next().trim();
            potentialIncomes.setName(name);
            System.out.println(ENTER_SUM.getMassage());
            balance = scanner.nextDouble();
            potentialIncomes.setBalance(balance);
        } catch (Exception e) {
            System.out.println(INVALID_INPUT.getMassage());
        }

        AddInFile.writeFile(FileConstants.PATH_POTENTIAL_INCOMES + potentialIncomes.getName() +
                ".txt", potentialIncomes.toString());
        System.out.println("=== Вы добавили новый потенциальный доход ===" +
                "\n⦁Название дохода: " + name +
                "\n⦁Сумма дохода: " + balance);
        System.out.println(ENTER_ACTION.getMassage());

    }
}
