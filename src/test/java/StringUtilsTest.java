import org.example.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void reverseStringTest() {
        assertEquals("dcba", stringUtils.reverseString("abcd"));
        assertEquals("olleh", stringUtils.reverseString("hello"));
        assertNull(stringUtils.reverseString(null));
    }

    @Test
    void isPalindromeTest() {
        assertTrue(stringUtils.isPalindrome("A man, a plan, a canal, Panama"));
        assertTrue(stringUtils.isPalindrome("racecar"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    void countVowelsTest() {
        assertEquals(2, stringUtils.countVowels("hello"));
        assertEquals(5, stringUtils.countVowels("abcdefghijklmnopqrstuvwxyz"));
        assertEquals(0, stringUtils.countVowels("1234567890"));
        assertEquals(0, stringUtils.countVowels(null));
    }

    @AfterEach
    void tearDown() {
        stringUtils = null;
        // Mengatur stringUtils menjadi null setelah setiap pengujian
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Pengujian selesai.");
        // Pesan yang dicetak setelah semua pengujian selesai
    }
}
