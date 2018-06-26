package main;

public class StringBuilderReverser implements IReverseStratrgy {
    @Override
    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
