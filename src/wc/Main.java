package wc;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        System.out.println("\n\t 输入 “-c 文件完整路径” 表示查询文件的字符数 ");
        System.out.println("\n\t 输入 “-w 文件完整路径” 表示查询文件的词的数目");
        System.out.println("\n\t 输入 “-l 文件完整路径” 表示查询文件的行数");
        System.out.println("\n\t 输入 “-a 文件完整路径” 表示查询文件的空行、注释行、代码行数");
        System.out.println("\n\t 输入 “-s 其他功能指令 文件完整路径” 表示以特定功能查询文件夹下所有代码文件");
        System.out.println("\n\t 输入 “-e” 表示退出程序");
        System.out.println("\n\t 以上除了退出功能外，其余皆可叠加指令查询，如-c -w -l 文件完整路径");
        while(true){
            System.out.println("\n请输入相应命令：");
            Scanner sc = new Scanner(System.in);
            //按空格切割成字符串数组，并将其分为指令组和文件路径
            String commands[] = sc.nextLine().toString().split("\\s");
            //判断是否为退出指令
            if(commands[0].equals("-e")){
                break;
            }

            String cms[] = Arrays.copyOf(commands,commands.length-1);
            String filePath = commands[commands.length-1];
            File file = new File(filePath);


            //递归查询
            if(cms[0].equals("-s")) {
                //检验输入指令除了‘-s’外，还含有其他功能指令
                if(cms.length>1){
                    String newcms[] = Arrays.copyOfRange(cms,1,cms.length);
                    if(CheckOut.checkFileDir(file)) {
                        RecFile.RecF(newcms, file);
                    }
                }else{
                    System.out.println("输入指令有误，请重新输入！");
                }
            }
            //普通查询
            else{
                CheckOut co = new CheckOut(cms,file);
                if(co.checkCommand()&&co.checkFile()) {
                    if(CheckOut.checkCodeFile(file)) {
                        Count count = new Count(cms, file);
                        count.runFunc();
                    }else{
                        System.out.println("该文件不是代码文件，请重新输入！");
                    }
                }else{
                    continue;
                }
            }
        }
    }

}
