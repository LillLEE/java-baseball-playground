package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void stringSplitTest() {
        String str1;
        String str2;
        String[] splitNumber1;
        String[] splitNumber2;

        str1 = "1,2";
        str2 = "1";
        splitNumber1 = str1.split(",");
        splitNumber2 = str2.split(",");

        assertThat(splitNumber1).contains("1", "2");
        assertThat(splitNumber2).containsExactly("1");
    }

    @Test
    @DisplayName("SubString Value Return Test")
    void subStringTest() {
        String str1;
        String str2;
        String subString;
        int charAt_Index;

        str1 = "(1,2)";
        str2 = "abc";
        subString = str1.substring(1, 4);
        charAt_Index = str2.charAt(2);

        assertThat(subString).contains("1,2");
    }


    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


}
