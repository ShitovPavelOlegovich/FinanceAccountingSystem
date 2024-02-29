package WorkWithFile;

import java.io.File;


public class DeleteFile {
    public static void deleteF(String path) {
        new File(path).delete();
    }

}
