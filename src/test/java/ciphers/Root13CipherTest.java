package ciphers;

import ciphers.impl.Root13Cipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Root13CipherTest {
    protected final String textWithNoAlphabeticLetters = "112312[]][";
    protected final String textWithAlphabeticLetters = "abcdd";
    protected final String expectedTextforAlphabeticLetters = "nopqq";
    protected final String mixedTest = "123sf//";
    protected final String expectedTextForMixedText = "123fs//";
    protected Cipher root13Cipher = new Root13Cipher();
    @DisplayName("Testing correction on encoding with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabetLettersAreEncoded() {
        String encoded = root13Cipher.encode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, encoded);
    }
    @DisplayName("Testing correction on encoding with alphabetic letters ")
    @Test
    public void testIfEncodingModifyTextWithAlphabeticChars() {
        String encoded = root13Cipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(expectedTextforAlphabeticLetters, encoded );
    }
    @DisplayName("Testing correction on decoding with alphabetic letters ")
    @Test
    public void testIfMixAlphabetLettersAreDecoding() {
        String decoded = root13Cipher.decode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, decoded );
    }
    @DisplayName("Testing correction of decode test with mix alphabetic letters")
    @Test
    public void testIfDecodingModifyTextWithAlphabeticChars(){
        String decode = root13Cipher.decode(mixedTest);
        Assertions.assertEquals(expectedTextForMixedText, decode);  //decode czyli z testu wartość actual
    }
}

