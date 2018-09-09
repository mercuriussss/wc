package wc;

import java.io.File;

public class Count {

    public void fileRead(String[] args){
        String cm =args[0];
        String fileName = args[1];
        File file = new File(fileName);

        switch (cm) {
            case "-c":
                countChar();break;
            case "-w":
                countWord();break;
            case "-l":
                countLine();break;
            default:
                System.out.println("输入功能有误");break;
        }
    }

    void countWord(){

    }

    void countChar(){

    }

    void countLine(){

    }
}
