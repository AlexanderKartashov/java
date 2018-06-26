package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private final List<IReverseStratrgy> _strategies = new ArrayList<>();

    @BeforeEach
    void setUp(){
        _strategies.add(new RawLoop());
        _strategies.add(new StringBuilderReverser());
        _strategies.add(new CollectionsReverser());
    }

    @Test
    void reverseNull(){
        for (IReverseStratrgy strategy: _strategies) {
            test(null, null, strategy);
        }
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void reverse(String input, String expected) {
        test(input, expected, new CollectionsReverser());
        test(input, expected, new RawLoop());
        test(input, expected, new StringBuilderReverser());
    }

    void test(String input, String expected, IReverseStratrgy strategy) {
        final Solution s = new Solution(strategy);
        assertEquals(expected, s.reverse(input));
    }

    static Stream<Arguments> stringProvider() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("a", "a"),
                Arguments.of("abc", "cba")
        );
    }
}