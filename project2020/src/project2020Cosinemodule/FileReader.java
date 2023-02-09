package project2020Cosinemodule;
import java.io.*;
//import java.lang.*;
public class FileReader {
    String readfile()throws Exception{
        File file = new File("F:\\Passage1\\Paragraph.txt");
        BufferedReader br = new BufferedReader(new java.io.FileReader(file));
        String st="",s="";
        while ((st = br.readLine()) != null)
            s=s+st;
        return s;
    }
}