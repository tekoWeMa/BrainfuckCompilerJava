package ch.teko.wema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

// D:\Studium\IntellijProjekte\BrainfuckReadfile\src\main\resources\FileToRead.txt

// Sauce: https://www.geeksforgeeks.org/java-program-to-read-a-file-to-string/

public class Main {
    public static void main(String[] args)
        // idk for what this part is, i guess it handles an exception lol
            throws IOException {
        Path FileToRead
                = Path.of("D:\\Studium\\IntellijProjekte\\BrainfuckReadfile\\src\\main\\resources\\FileToRead.txt");

        //File.readString() method is used to read a text file and store it in a string
        // calling files.readstring filetoreload, wich goes to path and reads the file

        String str = Files.readString(FileToRead);

        //System.out.println(str);

        //create arraylist to store enums from string
        ArrayList<OpcodeEnum> EnumList = new ArrayList<OpcodeEnum>();


        //Iterate over String
        // using simple for-loop
        for (int i = 0; i < str.length(); i++) {

            // System.out.println(str.charAt(i));

            // Wert der Position i wird c zugewiesen.
            char c = str.charAt(i);

            // check if c is chararacter, create enum of that type
            if (c == '>') {
                OpcodeEnum code = OpcodeEnum.GRÖSSERALS;
                EnumList.add(code);
            } else if (c == '<') {
                OpcodeEnum code = OpcodeEnum.KLEINERALS;
                EnumList.add(code);
            } else if (c == '+') {
                OpcodeEnum code = OpcodeEnum.PLUS;
                EnumList.add(code);
            } else if (c == '-') {
                OpcodeEnum code = OpcodeEnum.MINUS;
                EnumList.add(code);
            } else if (c == '.') {
                OpcodeEnum code = OpcodeEnum.PUNKT;
                EnumList.add(code);
            } else if (c == ',') {
                OpcodeEnum code = OpcodeEnum.KOMMA;
                EnumList.add(code);
            } else if (c == '[') {
                OpcodeEnum code = OpcodeEnum.KLAMMERAUF;
                EnumList.add(code);
            } else if (c == ']') {
                OpcodeEnum code = OpcodeEnum.KLAMMERZU;
                EnumList.add(code);
            }


        }
        System.out.println(EnumList);


    }

    public enum OpcodeEnum {

        GRÖSSERALS, KLEINERALS, PLUS, MINUS, PUNKT, KOMMA, KLAMMERAUF, KLAMMERZU

        //>, <, +, -, ., ",", [, ]
    }

}

//TODO: Solution implementieren clean up code in main
// Erklärung für Problem: Loop position falls Loop ausgeführt wird
// after closing bracket: how to know wich one is the opposing opening bracket?
// ^ vise versa ( stack solution?)
