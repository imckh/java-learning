package designpattern.behavioral_pattern.interpreter.v1;

public class Client {
    public static void main(String args[]) {
        String instruction = "up move 5 and down run 10 and left move 5";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        String outString;
        outString = handler.output();
        System.out.println(outString);
        // 向上移动5再向下快速移动10再向左移动5
    }
}
