import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class QueueWithTwoStack<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();
        
        public void enqueue(T value) { // Push onto newest stack
 
            stackNewestOnTop.push(value);
        }

        public T peek() {
            if(stackOldestOnTop.empty()){
                while(!stackNewestOnTop.empty()){
                    T val = stackNewestOnTop.pop();
                    stackOldestOnTop.push(val);
                }
            }
        
            T vals = stackOldestOnTop.peek();       
    
            return vals;
            
        }

        public T dequeue() {
           if(stackOldestOnTop.empty()){
                while(!stackNewestOnTop.empty()){
                    T val = stackNewestOnTop.pop();
                    stackOldestOnTop.push(val);
                }
            }
            T vals = stackOldestOnTop.pop();

            return vals;
        }
    }

    
    public static void main(String[] args) {
        QueueWithTwoStack<Integer> queue = new QueueWithTwoStack<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

