package cipher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import cipher.CaesarCipher;

public class CaesarCipherTest {
    // @Test
    // public void testChar() {
    //     CaesarCipher cipher = new CaesarCipher(2);

    //     cipher.encrypt("Test");
    // }

    @Test
    public void testEncryption() {
        CaesarCipher cipher = new CaesarCipher(2);

        String result = cipher.encrypt("Test");

        assertEquals("Vguv", result);
    }
}