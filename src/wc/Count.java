package wc;

import com.mysql.jdbc.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Count {

    int charNum ;
    int wordNum ;
    int lineNum ;
    int spacelineNum;
    int notelineNum;
    int codelineNum;
    String[] cms;
    String contentLine;
    File file;
    BufferedReader br;


    public Count(String[] commands , File file){
        cms = commands.clone();
        this.file = file;
        System.out.println("文件："+file.getAbsolutePath());
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
        //用空格替换掉非单词的字符，并用StringUtils类将其切割
        while(( contentLine = br.readLine())!=null){
            String str = contentLine.replaceAll("\\W"," ");
            wordNum += StringUtils.split(str," ",true).size();
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

    //统计空白行、代码行和注释行的数目
    public void additionlineNumber() throws IOException{
        spacelineNum = 0;
        notelineNum = 0;
        codelineNum = 0;
        boolean flag = false;
        br = new BufferedReader(new FileReader(file));
        while(( contentLine = br.readLine())!=null){
            contentLine = contentLine.trim();
            if(contentLine.matches("^\\s*$")){
                spacelineNum++;
            }else if(contentLine.startsWith("/*")&&!contentLine.endsWith("*/")){
                notelineNum++;
                flag = true;
            }else if (flag == true){
                notelineNum++;
                if(contentLine.endsWith("*/")){
                    flag = false;
                }
            }else if(contentLine.startsWith("//")||contentLine.endsWith("//")){
                notelineNum++;
            }else{
                codelineNum++;
            }
        }
        System.out.println("空白行："+spacelineNum);
        System.out.println("注释行："+notelineNum);
        System.out.println("代码行："+codelineNum);
    }


    public void runFunc() throws IOException{
        for(String command : cms) {
            switch (command) {
                case "-c":
                    charNumber();
                    break;
                case "-w":
                    wordNumber();
                    break;
                case "-l":
                    lineNumber();
                    break;
                case "-a":
                    additionlineNumber();
                    break;
                default:
                    System.out.println("输入功能有误");
                    break;
            }
        }
    }
}
