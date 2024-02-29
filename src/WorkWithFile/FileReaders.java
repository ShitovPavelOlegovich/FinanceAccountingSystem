package WorkWithFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaders {
    public static String reader(String path) {
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String a;
                while ((a = bufferedReader.readLine()) != null) {
                    sb.append(a + "\n");
                }
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    public static String readerSecond(String path) {
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        try {
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                try {
                    String a;
                    while ((a = bufferedReader.readLine()) != null) {
                        sb.append(a + "\n");
                    }
                } finally {
                    bufferedReader.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
