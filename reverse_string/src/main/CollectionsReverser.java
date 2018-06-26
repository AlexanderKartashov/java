package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsReverser implements IReverseStratrgy {
    @Override
    public String reverse(String input) {
        final List<Character> chars = input.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Collections.reverse(chars);
        return chars.stream().map(Object::toString).collect(Collectors.joining());
    }
}
