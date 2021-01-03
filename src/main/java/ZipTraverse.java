import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipTraverse {


    public void traverseZIP(InputStream compressedInput, String name, String[] extensions) throws IOException {
        check(compressedInput,name,1,extensions);
    }

    private void check(InputStream compressedInput, String name, int depth,String[] extensions) throws IOException {
        ZipInputStream input = new ZipInputStream(compressedInput);
        ZipEntry entry = null;
        while ( (entry = input.getNextEntry()) != null ) {
            String depthStr = "";
            for (int x = 0; x < depth; x++) {
                depthStr = depthStr+  "\t";
            }
            System.out.println(depthStr + entry.getName()+" , " + name);
            for (String extension : extensions) {
                if (entry.getName().endsWith(".jar")) {
                    check(input, name + "/" + entry.getName(),++depth,extensions);
                    depth--;
                    break;
                }
            }
        }
    }

}
