package encryptdecrypt;

interface Strategy {
    String decrypt(String message, int key);
    String encrypt(String message, int key);
}
