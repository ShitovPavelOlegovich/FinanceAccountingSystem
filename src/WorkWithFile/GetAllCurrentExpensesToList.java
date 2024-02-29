package WorkWithFile;

import current_expenses.CurrentExpenses;;
import java.io.*;
import java.util.ArrayList;

public class GetAllCurrentExpensesToList {
    private static ArrayList<String> arrayList;

    public static ArrayList<CurrentExpenses> list() {
        try {
            File folder = new File(FileConstants.PATH_CURRENT_EXPENSES);
            File[] files = folder.listFiles();
            ArrayList<CurrentExpenses> currentExpenses = new ArrayList<>();
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
                CurrentExpenses current = new CurrentExpenses();
                current.setName(arrayList.get(0));
                current.setBalance(Double.parseDouble(arrayList.get(1)));
                currentExpenses.add(current);

            }
            return currentExpenses;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
