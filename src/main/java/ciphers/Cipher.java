package ciphers;

public interface Cipher {
    String encode (String texttoEncode);
    String decode (String textToDecode);
}
