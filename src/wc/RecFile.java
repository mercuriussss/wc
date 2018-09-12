package wc;

import java.io.File;
import java.io.IOException;

public class RecFile {

     public static void RecF(String[] cms,File file) throws IOException{
        if(CheckOut.checkFile(file)&&CheckOut.checkCodeFile(file)){
            Count count = new Count(cms,file);
            count.runFunc();
        }else if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fs : files) {
                RecF(cms, fs);
            }
        }
    }
}
