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

        // create a arraylist to add both the opening and closing brackets
        ArrayList<BracketPair> bracketList = new ArrayList<>();


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
                    bracketList.add(new BracketPair(i, -1));
                }
                case ']' -> {
                    EnumList.add(OpcodeEnum.KLAMMERZU);
                    if (bracketStack.isEmpty()) {
                        // Prints the position of the position of the closing bracket missing an opening bracket
                        System.out.println("Keis corresponding zum closing bracket ade Position: " + i);
                    } else {
                        int beginIndex = bracketStack.pop();
                        for (BracketPair bp : bracketList) {
                            if (bp.getBegin() == beginIndex) {
                                bp.setEnd(i);
                                break;
                            }
                        }
                    }
                }
            }
        }
        // Prints the index of the overflowing opening brackets
        for (var stack:bracketStack){
            System.out.println("Es Opening Bracket z vill ade position: " + stack);
        }


       // Print enum list value
       // System.out.println(EnumList);

        //print size
        for (int i = 0; i < EnumList.size(); i++) {
            OpcodeEnum code = EnumList.get(i);

            //print index of the enumlist ( not used)
            //System.out.println(i);
        }
        //prints the indexes of the bracketlists
        for (BracketPair bp : bracketList) {
            System.out.println("Begin index: " + bp.getBegin() + " End index: " + bp.getEnd());
        }
    }

    public static class BracketPair {
        private int begin;
        private int end;

        public BracketPair(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
        public int getBegin() {
            return begin;
        }
        public int getEnd() {
            return end;
        }
        public void setEnd(int end) {
            this.end = end;
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
// loop: klasse erstellen mit 2 "members": Begin und end

// bei klasse sind getters und setters benötigt
// array mit loops (sortieren)

// TODO: alle Opcodes interpretieren ausser grösser und kleinerals, klammer auf und zu
// TODO: danach klammern indexieren
