package BTU.Davit.Tabutsadze.Task2;

import org.apache.log4j.Logger;

import java.io.File;

public class Main {

    final static Logger logger=Logger.getLogger(Main.class);

    public static void main(String[] args) {
        File myTextFile = new File("C:\\Users\\PC\\IdeaProjects\\Davit_Tabutsadze_task_2\\myFile");
        findWordbyDir(myTextFile, "word");

    }
    private static void findWordbyDir(File Path, String word){
        try {
            File[] ragacFile = Path.listFiles();
            for(File currentFile : ragacFile){
                if(containsWord(currentFile.getName(),word))logger.info(currentFile.getName());
                if(currentFile.isDirectory())findWordbyDir(currentFile, word);
            }
        }catch (Exception e){e.printStackTrace();}
    }
    private static boolean containsWord(String word, String toFind){
        int maxIndex = word.length() - toFind.length()+1;
        for(int i = 0; i < maxIndex; i++) {
            String sub = word.substring(i, i+toFind.length());
            if(sub.equals(toFind)) return true;
        }
        return false;

    }
}