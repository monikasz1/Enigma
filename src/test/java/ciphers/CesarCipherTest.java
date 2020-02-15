package ciphers;

import ciphers.impl.CesarCipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {
    protected final String textWithNoAlphabeticLetters = "112312[]][";
    protected final String textWithAlphabeticLetters = "abcdd";
    protected final String expectedTextforAlphabeticLetters = "defgg";
    protected final String mixedTest = "123df//";
    protected final String expectedTextForMixedText = "123ds//";
    protected Cipher cesarCipher = new CesarCipher();

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded() {
        String encoded = cesarCipher.encode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, encoded);
    }

    @DisplayName("Testing correction of encoding text with alphabetic letters")
    @Test
    public void testIfEncodingModifyTextWithAlphabeticChars() {
        String encoded = cesarCipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(expectedTextforAlphabeticLetters, encoded);
    }
    @DisplayName("Testing correction of encoding text with mixed letters")
    @Test
    public void testIfEncodingModifyTextWithMixedText() {
        String decoded = cesarCipher.decode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(expectedTextforAlphabeticLetters, decoded);
    }

    @DisplayName("Testing correction of encoding text with alphabetic letters")
    @Test
    public void testIfEncodingModifyTextWithMixedText() {
        String decoded = cesarCipher.decode(mixedTest);
        Assertions.assertEquals(expectedTextForMixedText, decoded);
    }
}


