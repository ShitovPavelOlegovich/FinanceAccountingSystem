package WorkWithFile;

import potential_expenses.PotentialExpenses;
import java.io.*;
import java.util.ArrayList;

public class GetAllPotentialExpensesToList {
    private static ArrayList<String> arrayList;
    public static ArrayList<PotentialExpenses> list() {
        try {
            File folder = new File(FileConstants.PATH_POTENTIAL_EXPENSES);
            File[] files = folder.listFiles();
            ArrayList<PotentialExpenses> potentialExpenses = new ArrayList<>();
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
                PotentialExpenses potentialExpenses1 = new PotentialExpenses();
                potentialExpenses1.setName(arrayList.get(0));
                potentialExpenses1.setBalance(Double.parseDouble(arrayList.get(1)));
                potentialExpenses.add(potentialExpenses1);

            }
            return potentialExpenses;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
