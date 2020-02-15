import ciphers.Cipher;
import ciphers.impl.CesarCipher;

public class Test {
    public static void main(String[] args) {
//        System.out.println((int)('A') + 3);
//        char d = 68;
//        System.out.println((char)(d + 4));
        Cipher cesarCipher = new CesarCipher();
        String example = cesarCipher.encode ("hjdk5482DADShfkjsghkjs");
        System.out.println(example);
        String decoded = cesarCipher.decode("fdsgfsgfdgf555DGFDS123456789");
        System.out.println(decoded);
    }
}