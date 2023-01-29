package ch.teko.wema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // FileToRead
        Path FileToRead = Path.of("D:\\Studium\\IntellijProjekte\\BrainfuckReadfile\\src\\main\\resources\\mandelbrot.bf");

        // Read the file to a string
        String str = Files.readString(FileToRead);

        // Create an arraylist to store enums from the string
        ArrayList<OpcodeEnum> EnumList = new ArrayList<>();

        // Create a stack for brackets
        Stack<Integer> bracketStack = new Stack<>();

        // create a arraylist to add both the opening and closing brackets
        ArrayList<BracketPair> bracketList = new ArrayList<>();

        // Create a new byte array called "memory" with a size of 30000
        byte[] memory = new byte[30000];

        // Create an int variable called "pointer"
        int pointer = 0;

        // Iterate over the string
        for (int i = 0; i < str.length(); i++) {
            // Get the current character
            char c = str.charAt(i);

            // Check if the character is a known opcode and add the corresponding enum to the list
            switch (c) {
                case '>' -> {
                    EnumList.add(OpcodeEnum.GRÖSSERALS);
                }
                case '<' -> {
                    EnumList.add(OpcodeEnum.KLEINERALS);
                }
                case '+'  -> {
                    EnumList.add(OpcodeEnum.PLUS);
                }
                case '-' -> {
                    EnumList.add(OpcodeEnum.MINUS);
                }
                case '.' -> {
                    EnumList.add(OpcodeEnum.PUNKT);
                }
                case ',' -> {
                    EnumList.add(OpcodeEnum.KOMMA);
                }
                case '[' -> {
                    EnumList.add(OpcodeEnum.KLAMMERAUF);
                    bracketStack.push(EnumList.size() - 1);
                    bracketList.add(new BracketPair(EnumList.size() - 1, -1));
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
                                bp.setEnd(EnumList.size() - 1);
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
        for (int i = 0; i < EnumList.size(); i++) {
            OpcodeEnum code = EnumList.get(i);
            //System.out.println(i);
            switch (code) {
                case GRÖSSERALS:
                    pointer++;
                    break;
                case KLEINERALS:
                    pointer--;
                    break;
                case PLUS:
                    memory[pointer]++;
                    break;
                case MINUS:
                    memory[pointer]--;
                    break;
                case PUNKT:
                    System.out.print((char)memory[pointer]);
                    break;
                case KOMMA:
                    memory[pointer] = (byte)System.in.read();
                    break;
                case KLAMMERAUF:
                    if (memory[pointer] == 0) {
                        //
                        for (int p = 0; p < bracketList.size(); p++) {
                            if (bracketList.get(p).getBegin() == i) {
                                i = bracketList.get(p).getEnd() - 1;
                                break;
                            }
                            //bracketList code = bracketList.get(p);
                        }
                        //i = bracketList.get(i).getEnd() - 1;
                    } else {
                       // i --;
                    }
                    break;

                case KLAMMERZU:
                    if (memory[pointer] != 0) {
                        for (int p = 0; p < bracketList.size(); p++) {
                            if (bracketList.get(p).getEnd() == i) {
                                i = bracketList.get(p).getBegin() - 1;
                                break;
                            }
                        }
                    } else {
                     //   i--;
                    }
                    break;
            }

            //print index of the enumlist ( not used)
            //System.out.println(i);
        }
        System.out.println();

          //prints the indexes of the bracketlists
          //  for (BracketPair bp : bracketList) {
          // System.out.println("Begin index: " + bp.getBegin() + " End index: " + bp.getEnd());
          //}
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

// TODO: look into performant code to index the opening and closing brackets

// stackoverflow possible solution: https://stackoverflow.com/questions/72046454/how-do-i-implement-the-looping-functionality-in-my-brainfuck-interpreter