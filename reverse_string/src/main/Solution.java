package main;

public class Solution {
    public Solution(IReverseStratrgy reverser) {
        _reverser = reverser;
    }

    public String reverse(String input) {
        if (input == null) {
            return null;
        }

        return _reverser.reverse(input);
    }

    private final IReverseStratrgy _reverser;
}
