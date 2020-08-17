package encryptdecrypt;

public class ShiftStrategy implements Strategy {
    final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final String BIG_ALPHABET = ALPHABET.toUpperCase();
    final int LEN = ALPHABET.length();


    @Override
    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int alphabetIndex = ALPHABET.indexOf(message.charAt(i));
            int bigAlphabetIndex = BIG_ALPHABET.indexOf(message.charAt(i));
            if (alphabetIndex > -1) {
                char shifted = ALPHABET.charAt((alphabetIndex + key) % LEN);
                builder.append(shifted);
            } else if (bigAlphabetIndex > -1) {
                char shifted = BIG_ALPHABET.charAt((bigAlphabetIndex + key) % LEN);
                builder.append(shifted);
            } else {
                builder.append(message.charAt(i));
            }
        }
        return builder.toString();
    }

    @Override
    public String decrypt(String message, int key) {
        return encrypt(message, 26 - (key % 26));
    }
}
