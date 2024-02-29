package WorkWithFile;

import java.io.File;
import java.io.IOException;

public class UpdateFile {
    public static void update(String path, String newText) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder sb = new StringBuilder();
        String oldFile = FileReaders.reader(path);
        sb.append(oldFile);
        sb.append(newText);
        AddInFile.writeFile(path,sb.toString());
    }
}
