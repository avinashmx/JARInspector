import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Driver {
    public static void main(String args[]) throws Exception {
        File dir = new File(args[0]);
        String filenames[] = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".ear");
            }
        });
        System.out.println(Arrays.toString(filenames));
        for (String fileName : filenames) {
            fileName = dir.getAbsolutePath()+ "/" + fileName;
            System.out.println("Traversing " + fileName);
            File file = new File(fileName);
            FileInputStream input = new FileInputStream(file);
            ZipTraverse zipTraverse = new ZipTraverse();
            zipTraverse.traverseZIP(input, file.getName(), new String[]{".zip", ".jar", ".war",".ear"});
        }

    }


}
