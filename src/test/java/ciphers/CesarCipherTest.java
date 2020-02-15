package ciphers;

import ciphers.impl.CesarCipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {
    protected final String textWithNoAlphabeticLetters = "112312[]][";
    protected final String textWithAlphabeticLetters = "abcdd";
    protected final String expectedTextforAlphabeticLetters = "defgg";
    protected final String mixedTest = "123sf//";
    protected final String expectedTextForMixedText = "123pc//";
    protected Cipher cesarCipher = new CesarCipher();
    @DisplayName("Testing correction on encoding with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabetLettersAreEncoded() {
        String encoded = cesarCipher.encode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, encoded);
    }
    @DisplayName("Testing correction on encoding with alphabetic letters ")
    @Test
    public void testIfEncodingModifyTextWithAlphabeticChars() {
        String encoded = cesarCipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(expectedTextforAlphabeticLetters, encoded );
    }
    @DisplayName("Testing correction on decoding with alphabetic letters ")
    @Test
    public void testIfMixAlphabetLettersAreDecoding() {
        String decoded = cesarCipher.decode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, decoded );
    }
    @DisplayName("Testing correction of decode test with mix alphabetic letters")
    @Test
    public void testIfDecodingModifyTextWithAlphabeticCgars(){
        String decode = cesarCipher.decode(mixedTest);
        Assertions.assertEquals(expectedTextForMixedText, decode);
    }
}







