package wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Count {

    int charNum ;
    int wordNum ;
    int lineNum ;
    String contentLine;
    File file;
    BufferedReader br;

    public Count(String filePath) {

        file = new File(filePath);

    }
    public void charNumber() throws IOException{
        charNum = 0;
        br = new BufferedReader(new FileReader(file));
        while(( contentLine = br.readLine())!=null){
            String str = contentLine.replaceAll("\\s","");
            charNum += str.length();
        }
        System.out.println("字符数："+charNum);
    }
    public void wordNumber() throws IOException{
        wordNum = 0;
        br = new BufferedReader(new FileReader(file));
        while(( contentLine = br.readLine())!=null){
            String str = contentLine.replaceAll("[\\p{Nd}\\p{Punct}\\s\\u4e00-\\u9fa5]"," ");
            wordNum += str.split("\\s+").length;
        }
        System.out.println("单词数："+wordNum);
    }
    public void lineNumber() throws IOException{
        lineNum =0;
        br = new BufferedReader(new FileReader(file));
        while(( contentLine = br.readLine())!=null){
            lineNum++;
        }
        System.out.println("行数："+lineNum);
    }
}
