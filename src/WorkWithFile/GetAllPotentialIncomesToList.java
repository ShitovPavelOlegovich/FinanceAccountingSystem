package WorkWithFile;

import potential_Incomes.PotentialIncomes;

import java.io.*;
import java.util.ArrayList;

public class GetAllPotentialIncomesToList {
    private static ArrayList<String> arrayList;
    public static ArrayList<PotentialIncomes> list() {
        try {
            File folder = new File(FileConstants.PATH_POTENTIAL_INCOMES);
            File[] files = folder.listFiles();
            ArrayList<PotentialIncomes> potentialIncomes = new ArrayList<>();
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
                PotentialIncomes incomes = new PotentialIncomes();
                incomes.setName(arrayList.get(0));
                incomes.setBalance(Double.parseDouble(arrayList.get(1)));
                potentialIncomes.add(incomes);
            }
            return potentialIncomes;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
