package encryptdecrypt;

public class UnicodeStrategy implements Strategy {
    @Override
    public String decrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char characterTranslated = (char) (message.charAt(i) - key);
            builder.append(characterTranslated);
        }
        return builder.toString();
    }

    @Override
    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char characterTranslated = (char) (message.charAt(i) + key);
            builder.append(characterTranslated);
        }
        return builder.toString();
    }
}
