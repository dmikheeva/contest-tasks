import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PetyaVasyaNumbersTest {

    @ParameterizedTest
    @MethodSource("argsProvider")
    void main() {
        PetyaVasyaNumbers petyaVasyaNumbers = new PetyaVasyaNumbers();
    }

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of()
        );
    }
}