package learn.yyc.test.demo.stack;

import java.util.Stack;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/5 0005 上午 10:32
 */
public class TestStack {

    public static void main(String[] args) {
//        括号匹配问题
        String str = "(上海)(北京))";
        String str1 = "((上海))";

        char[] chars = str.toCharArray();

        Stack stack = new Stack();

        for(char c : chars){
            if(c == '('){
                stack.push(c);
            }
            if(c == ')'){
                Object pop = stack.peek();
                if(pop == null){
                    System.out.println("error");
                    break;
                }
            }

        }

        if(stack.isEmpty()){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }
}
