package WorkWithFile;

import wallet.Wallet;

import java.io.*;
import java.util.ArrayList;

public class GetAllWalletsToList {
    private static ArrayList<String> arrayList;
    public static ArrayList<Wallet> list() {
        try {
            File folder = new File(FileConstants.PATH_WALLET);
            File[] files = folder.listFiles();
            ArrayList<Wallet> wallets = new ArrayList<>();
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
                Wallet wallet = new Wallet();
                wallet.setName(arrayList.get(0));
                wallet.setBalance(Double.parseDouble(arrayList.get(1)));
                wallets.add(wallet);
            }
            return wallets;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
