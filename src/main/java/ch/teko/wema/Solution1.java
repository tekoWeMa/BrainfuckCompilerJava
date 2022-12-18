package ch.teko.wema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        Path fileToRead = Path.of("D:\\Studium\\IntellijProjekte\\BrainfuckReadfile\\src\\main\\resources\\FileToRead.txt");
        String str = Files.readString(fileToRead);

        // Create array list to store enums from string
        ArrayList<OpcodeEnum> enumList = new ArrayList<OpcodeEnum>();

        // Iterate over string
        for (int i = 0; i < str.length(); i++) {
            // Assign value at position i to c
            char c = str.charAt(i);

            // Check if c is character and create enum of that type
            OpcodeEnum code;
            if (c == '>') {
                code = OpcodeEnum.GRÖSSERALS;
            } else if (c == '<') {
                code = OpcodeEnum.KLEINERALS;
            } else if (c == '+') {
                code = OpcodeEnum.PLUS;
            } else if (c == '-') {
                code = OpcodeEnum.MINUS;
            } else if (c == '.') {
                code = OpcodeEnum.PUNKT;
            } else if (c == ',') {
                code = OpcodeEnum.KOMMA;
            } else if (c == '[') {
                code = OpcodeEnum.KLAMMERAUF;
            } else if (c == ']') {
                code = OpcodeEnum.KLAMMERZU;
            } else {
                continue;
            }
            enumList.add(code);
        }
        System.out.println(enumList);
    }

    public enum OpcodeEnum {
        GRÖSSERALS, KLEINERALS, PLUS, MINUS, PUNKT, KOMMA, KLAMMERAUF, KLAMMERZU
    }
}