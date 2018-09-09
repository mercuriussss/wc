package wc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\t 输入 “-c 文件名” 表示查询文件的字符数 ");
        System.out.println("\n\t 输入 “-w 文件名” 表示查询文件的词的数目");
        System.out.println("\n\t 输入 “-l 文件名” 表示查询文件的行数");
        System.out.println("\n\t 输入 “-s 文件名” 表示查询文件的字符数");
        System.out.println("\n\t 输入 “-e” 表示退出程序");
        while(true){
            System.out.println("\n请输入相应命令：");
            Scanner sc = new Scanner(System.in);
            //按空格切割成字符串数组
            String cm[] = sc.nextLine().toString().split("\\s");

            if(cm[0].equals("-e")){
                break;
            }
            else{
                Count.fileRead(cm);
            }

        }
    }

}
