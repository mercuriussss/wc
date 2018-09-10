package wc;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        System.out.println("\n\t 输入 “-c 文件名” 表示查询文件的字符数 ");
        System.out.println("\n\t 输入 “-w 文件名” 表示查询文件的词的数目");
        System.out.println("\n\t 输入 “-l 文件名” 表示查询文件的行数");
        System.out.println("\n\t 输入 “-s 文件名” 表示查询文件的字符数");
        System.out.println("\n\t 输入 “-e” 表示退出程序");
        while(true){
            System.out.println("\n请输入相应命令：");
            Scanner sc = new Scanner(System.in);
            //按空格切割成字符串数组
            String command[] = sc.nextLine().toString().split("\\s");

            if(command[0].equals("-e")){
                break;
            }
            else{
                if(CheckOut.check(command)) {
                    Count count = new Count(command[1]);
                    switch (command[0]) {
                        case "-c":
                            count.charNumber();
                            break;
                        case "-w":
                            count.wordNumber();
                            break;
                        case "-l":
                            count.lineNumber();
                            break;
                        default:
                            System.out.println("输入功能有误");
                            break;
                    }
                }else{
                    continue;
                }
            }
        }
    }

}
