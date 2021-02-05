package string;

import java.util.Stack;

/**
 * 
 * 
 * 
 * 输入："abbaca"
 * 输出："ca" 
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test01 {

    public static void main(String[] args) {
        System.out.println(new Test01().removeDuplicates("abbacd"));
    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        int len = S.length();
        for (int i =0; i < len; i++) {
            if (!stack.empty() && stack.peek() == S.charAt(i)) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character ch: stack) {
            result.append(ch);
        }
        return result.toString();
    }
    
}