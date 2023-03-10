package algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @ParameterizedTest
    @MethodSource("heapSortArgsProvider")
    void testHeapSort(int[] src, int[] expected) {
        assertArrayEquals(expected, HeapSort.heapSort(src));
    }

    static Stream<Arguments> heapSortArgsProvider() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{2, 1}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 3, 2}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{2, 1, 3}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{512, 42, 1, 89, 159, 28, 649, 218},
                        new int[]{1, 28, 42, 89, 159, 218, 512, 649}),
                Arguments.of(new int[]{3, 3, 3}, new int[]{3, 3, 3}),
                Arguments.of(new int[]{ -1, -4, -6 }, new int[]{ -6, -4, -1 }),
                Arguments.of(new int[]{ -5, 14, -8, 0, 2 }, new int[]{ -8, -5, 0, 2, 14 })
        );
    }
}