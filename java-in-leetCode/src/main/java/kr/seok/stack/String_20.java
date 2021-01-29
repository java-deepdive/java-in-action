package kr.seok.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * 1. 스택 Stack을 초기화
 * 2. Bracket을 한 번에 하나씩 처리
 * 3. 만약 opening bracket을 마주하는 경우 stack에 밀어넣는다.
 * 4. closed bracket에 마주하는 경우 stack top 을 확인, top 에 있는 요소와 closed bracket이 같지 않으면 false, 아니면 계속 진행
 * 5. 스택에 아직 요소가 남아있으면 false
 *
 */
public class String_20 {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public String_20() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();

        /*
            [{{}}]
         */
        for (int i = 0; i < s.length(); i++) {
            /*
                }}]
                closed bracket을 가져와서 mapping 되는 key를 조회
             */
            char c = s.charAt(i);
            // If the current character is a closing bracket.
            /*
                s = [{{'}'}]
                c = }

                map 에 저장된 bracket 확인
             */
            if (this.mappings.containsKey(c)) {
                System.out.println(c);
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                /*
                    s = [{{'}'}]
                    c = }
                    topElement = '#'
                 */
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                /*
                    s = [{{'}'}]
                    c = }
                    topElement = '#'

                     { 와 { 를 비교
                 */
                System.out.println(topElement + " :: " + this.mappings.get(c));
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
