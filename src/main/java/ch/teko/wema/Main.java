package ch.teko.wema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // FileToRead
        Path FileToRead = Path.of("D:\\Studium\\IntellijProjekte\\BrainfuckReadfile\\src\\main\\resources\\FileToRead.txt");

        // Read the file to a string
        String str = Files.readString(FileToRead);

        // Create an arraylist to store enums from the string
        ArrayList<OpcodeEnum> EnumList = new ArrayList<>();

        // Create a stack for brackets
        Stack<Integer> bracketStack = new Stack<>();

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
                case '[' -> {
                    EnumList.add(OpcodeEnum.KLAMMERAUF);
                    bracketStack.push(i);
                }
                case ']' -> {
                    EnumList.add(OpcodeEnum.KLAMMERZU);
                    if (bracketStack.isEmpty()) {
                        System.out.println("Keis closing bracket ade Position: " + i);
                    } else {
                        // removes top element from
                        bracketStack.pop();
                    }
                }
            }
        }
        //System.out.println(EnumList);
         // ArrayList<OpcodeEnum> EnumList = new ArrayList<>();

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



// stack machen:

//    Copy code
//    Stack stack = new Stack(5);
//stack.push(1);
//        stack.push(2);
//        stack.push(3);
//
//
//
// loop: klasse erstellen mit 2 "members": Begin und end
// bei klasse sind getters und setters benötigt
// array mit loops (sortieren)
//

// Notes: why create a seperate class? not really making sense as of now

// what use getters and setters for? no understand