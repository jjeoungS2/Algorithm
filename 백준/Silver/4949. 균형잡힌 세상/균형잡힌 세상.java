import java.util.Scanner;
import java.util.Stack;

// 균형잡힌 세상 BJ_5959
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        String s;

        while(true){
            s = sc.nextLine();

            if(s.equals(".")){
                break;
            }

            System.out.println(sol(s));
        }
    }

    public static String sol(String s){
        Stack<Character> stack = new Stack<>();

        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);

            if(c == '(' || c == '['){
                stack.push(c);
            }

            else if(c ==')'){
                if(stack.empty() || stack.peek()!='('){
                    return "no";
                }
                else{
                    stack.pop();
                }
            }

            else if( c == ']'){
                if(stack.empty() || stack.peek()!='['){
                    return "no";
                }
                else{
                    stack.pop();
                }
            }
        }

        if(stack.empty()){
            return "yes";
        } else{
            return "no";
        }
    }
}
