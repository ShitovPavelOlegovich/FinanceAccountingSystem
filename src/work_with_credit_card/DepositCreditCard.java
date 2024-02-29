package work_with_credit_card;

import WorkWithFile.AddInFile;
import WorkWithFile.DeleteFile;
import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static wallet.WalletInfo.ENTER_ACTION;
import static wallet.WalletInfo.INVALID_INPUT;
import static сredit_card.CreditCardInfo.ENTER_ADD_SUM;
import static сredit_card.CreditCardInfo.ENTER_NAME_CARD_DEPOSIT;

public class DepositCreditCard {

    static String name = "";
    static double balance;

    public static void deposit() {
        System.out.println(ENTER_NAME_CARD_DEPOSIT.getMassage());
        Scanner scanner = new Scanner(System.in);

        name = scanner.next().trim();
        File[] files = new File(FileConstants.PATH_CREDIT_CARD).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    System.out.println(ENTER_ADD_SUM.getMassage());
                    balance = scanner.nextDouble();

                    String[] strings = FileReaders.reader(FileConstants.PATH_CREDIT_CARD + name + ".txt").split("\n");
                    strings[1] = String.valueOf(balance + Double.parseDouble(strings[1]));
                    String text = strings[0] + "\n" + strings[1];
                    DeleteFile.deleteF(FileConstants.PATH_CREDIT_CARD + name + ".txt");
                    AddInFile.writeFile(FileConstants.PATH_CREDIT_CARD + name + ".txt", text);

                    System.out.println("Вы добавили к основной сумме " +
                            "\"" + balance + "\"" + " $.");
                    return;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT.getMessage());
                return;
            }
        }
        System.out.println("Кредитной карты с данным " + "\"" + name + "\"" + " не существует.");
        System.out.println(ENTER_ACTION.getMessage());


    }
}
