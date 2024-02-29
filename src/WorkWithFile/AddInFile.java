package WorkWithFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public  class AddInFile {
    public static void writeFile(String path, String text) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            try {
                bufferedWriter.write(text);
            } finally {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
