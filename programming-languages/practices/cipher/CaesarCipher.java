package cipher;

public class CaesarCipher {
    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    public String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char letter : text.toCharArray()) {
            if (Character.isLetter(letter)) {
                char base = Character.isLowerCase(letter) ? 'a' : 'A';

                char encryptedCharacter = (char) ((letter - base + this.shift) % 26 + base);

                encrypted.append(encryptedCharacter);
            } else {
                encrypted.append(letter);
            }
        }

        System.out.println(encrypted.toString());
        return encrypted.toString();
    }
}
