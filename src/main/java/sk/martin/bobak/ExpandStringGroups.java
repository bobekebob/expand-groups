package sk.martin.bobak;

import java.util.LinkedList;
import java.util.List;

public class ExpandStringGroups
{

    /**
     * if char - put in on stack
     * if { - do nothing
     * if , - if previous not } print, remove last item on stack
     * if } - print, remove last item on stack
     */
    public static List<String> printGroupCombinations(final String input) {
        LinkedList<Character> stack = new LinkedList<Character>();
        List<String> groups = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                continue;
            }
            if (input.charAt(i) == ',') {
                if (i > 0 && input.charAt(i - 1) != '}') {
                    groups.add(stackToString(stack));
                }
                stack.removeLast();
                continue;
            }
            if (input.charAt(i) == '}') {
                groups.add(stackToString(stack));
                stack.removeLast();
                continue;
            }
            stack.add(input.charAt(i));
        }
        stackToString(stack);
        groups.add(stackToString(stack));
        return groups;
    }

    private final static String stackToString(LinkedList<Character> stack) {
        String result = "";
        for (Character c : stack) {
            result+=c;
        }
        return result;
    }
}
