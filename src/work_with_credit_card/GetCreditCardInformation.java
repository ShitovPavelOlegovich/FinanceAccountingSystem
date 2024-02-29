package work_with_credit_card;

import WorkWithFile.FileConstants;
import WorkWithFile.FileReaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static wallet.WalletInfo.*;
import static сredit_card.CreditCardInfo.ENTER_NAME_CARD_STATUS_SPECIFIC;
import static сredit_card.CreditCardInfo.STATUS_SPECIFIC_CREDIT_CARD;

public class GetCreditCardInformation {
    public static void getInformation() {
        System.out.println(STATUS_SPECIFIC_CREDIT_CARD.getMassage());
        System.out.println(ENTER_NAME_CARD_STATUS_SPECIFIC.getMassage());
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next().trim();
        File[] files = new File(FileConstants.PATH_CREDIT_CARD).listFiles();
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null && line.equals(name)) {
                    String[] strings = FileReaders.reader(FileConstants.PATH_CREDIT_CARD + name + ".txt").split("\n");
                    strings[1] = String.valueOf(strings[1]);
                    System.out.println("Информация по кредитной карте с именем " + "\"" + name + "\""
                            + "\n~" + strings[0] + " - " + strings[1] + " $.");
                    System.out.println(ENTER_ACTION.getMessage());
                    return;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT.getMessage());
                return;
            }
        }
        System.out.println("Кредитная карта с данным именем " + "\"" + name + "\"" + " не найдена. ");
        System.out.println(ENTER_ACTION.getMessage());
    }
}
