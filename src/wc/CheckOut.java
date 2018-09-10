package wc;

import java.io.*;

public class CheckOut {

    public static boolean check(String[] args){
        String cm =args[0];
        String filePath = args[1];
        File file = new File(filePath);
        if(cm.length()!=2){
            System.out.println("输入命令有误，请重新输入！");
            return false;
        }

        //判断文件是否存在
        if(file.isFile()&&file.exists()){
            return true;
        }else{
            System.out.println("该文件不存在！请检查路径是否输入错误！");
            return false;
        }
    }
}

