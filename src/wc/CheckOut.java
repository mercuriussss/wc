package wc;

import java.io.*;
import java.util.Arrays;

public class CheckOut {

    String[] cms;
    File file;
    String[] cmCol = {"-c","-w","-l","-s","-a"}; //指令数组，用于检验输入指令是否正确

    public CheckOut(String[] command,File file){
        cms = command.clone();
        this.file = file;
    }

    public boolean checkFile() {

        if (file.isFile() && file.exists()) {
            return true;
        } else {
            System.out.println("该文件不存在！请检查路径是否输入错误！");
            return false;
        }
    }

    public boolean checkCommand(){
        for(String cm : cms){
            if(!Arrays.asList(cmCol).contains(cm)){
                System.out.println("输入命令有误，请重新输入！");
                return false;
            }
        }
        return true;
    }

    public static boolean checkFile(File file){
        if(file.isFile()&&file.exists()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkFileDir(File file){
        if(file.isDirectory()){
            if(file.list().length>0){
                return true;
            }else{
                System.out.println("该目录为空目录！");
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean checkCodeFile(File file){
        String str = file.getName();
        if(str.endsWith(".java")||str.endsWith(".cpp")||str.endsWith(".c")){
            return true;
        }else{
            return false;
        }
    }

}

