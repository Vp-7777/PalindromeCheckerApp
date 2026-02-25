import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class PalindromeCheckerApp {
    public static boolean twoPointerCheck(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeCheck(String input) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text : ");
        String input = scanner.nextLine();

        long startTime, endTime;

        startTime = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean result2 = stackCheck(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean result3 = dequeCheck(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println("Two Pointer Result : " + result1 + " | Time (ns) : " + twoPointerTime);
        System.out.println("Stack Result : " + result2 + " | Time (ns) : " + stackTime);
        System.out.println("Deque Result : " + result3 + " | Time (ns) : " + dequeTime);

        scanner.close();


    }

}
