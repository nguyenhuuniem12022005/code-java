import java.util.*;
public class kiemtradayngoacdung{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n-->0){
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean check = true;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            } else if(c==')'){
                if(stack.isEmpty() || stack.pop()!='('){
                    check = false;
                    break;
                }
            } else if(c==']'){
                if(stack.isEmpty() || stack.pop()!='['){
                    check = false;
                    break;
                }
            } else if(c=='}'){
                if(stack.isEmpty() || stack.pop()!='{'){
                    check = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            check = false;
        }
        if(check){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    sc.close();
    }
}