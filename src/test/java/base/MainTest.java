package base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    private static Stream<Arguments> checkMinimumAmountOfChangeEqualTo() {
        return Stream.of(
                Arguments.of(new int[] {5, 7, 1, 1, 2, 3, 22}, 20),
                Arguments.of(new int[] {2, 16, 8, 4}, 1),
                Arguments.of(new int[] {1, 2, 16, 8, 4}, 32)
        );
    }

    @ParameterizedTest
    @MethodSource
    void checkMinimumAmountOfChangeEqualTo(int[] coins, int expectedAmount) {
        // GIVEN
        Main main = new Main();

        // WHEN
        var actual = main.nonConstructibleChange(coins);

        // THEN
        assertEquals(expectedAmount, actual);
    }

}