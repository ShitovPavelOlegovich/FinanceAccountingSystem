package WorkWithFile;


import сredit_card.CreditCard;
import java.io.*;
import java.util.ArrayList;

public class GetAllCreditCardsToList {
    private static ArrayList<String> arrayList;
    public static ArrayList<CreditCard> list() {
        try {
            File folder = new File(FileConstants.PATH_CREDIT_CARD);
            File[] files = folder.listFiles();
            ArrayList<CreditCard> creditCards = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                arrayList = new ArrayList<>();
                File file = files[i];
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    arrayList.add(line);
                    line = bufferedReader.readLine();
                }
                CreditCard creditCard = new CreditCard();
                creditCard.setName(arrayList.get(0));
                creditCard.setBalance(Double.parseDouble(arrayList.get(1)));
                creditCards.add(creditCard);

            }
            return creditCards;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
