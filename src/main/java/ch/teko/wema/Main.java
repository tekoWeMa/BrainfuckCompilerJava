package ch.teko.wema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        // FileToRead
        Path FileToRead = Path.of("D:\\Studium\\IntellijProjekte\\BrainfuckReadfile\\src\\main\\resources\\FileToRead.txt");

        // Read the file to a string
        String str = Files.readString(FileToRead);

        // Create an arraylist to store enums from the string
        ArrayList<OpcodeEnum> EnumList = new ArrayList<>();

        // Iterate over the string
        for (int i = 0; i < str.length(); i++) {
            // Get the current character
            char c = str.charAt(i);

            // Check if the character is a known opcode and add the corresponding enum to the list
            switch (c) {
                case '>' -> EnumList.add(OpcodeEnum.GRÖSSERALS);
                case '<' -> EnumList.add(OpcodeEnum.KLEINERALS);
                case '+' -> EnumList.add(OpcodeEnum.PLUS);
                case '-' -> EnumList.add(OpcodeEnum.MINUS);
                case '.' -> EnumList.add(OpcodeEnum.PUNKT);
                case ',' -> EnumList.add(OpcodeEnum.KOMMA);
                case '[' -> EnumList.add(OpcodeEnum.KLAMMERAUF);
                case ']' -> EnumList.add(OpcodeEnum.KLAMMERZU);
            }
        }
        //System.out.println(EnumList);
        //  ArrayList<OpcodeEnum> EnumList = new ArrayList<>();
        Stack<int>

        for (int i = 0; i < EnumList.size(); i++) {
            OpcodeEnum code = EnumList.get(i);
            if (code == OpcodeEnum.KLAMMERAUF) {

            }

            System.out.println(i);
        }

    }

    public enum OpcodeEnum {
        GRÖSSERALS,
        KLEINERALS,
        PLUS,
        MINUS,
        PUNKT,
        KOMMA,
        KLAMMERAUF,
        KLAMMERZU
    }
}


// Erklärung für Problem: Loop position falls Loop ausgeführt wird HERE:
// Declare 3 variables. one for "is it looping", one to save the Value of the Position of the loop (stack) and one for the amount of loops.

// after closing bracket: how to know wich one is the opposing opening bracket?
// ^ vise versa ( stack solution?)
