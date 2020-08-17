package encryptdecrypt;

public class AlgorithmContext {
    private Strategy strategy;

    public AlgorithmContext() {
        this.strategy = new UnicodeStrategy();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String decrypt(String message, int key){
        return strategy.decrypt(message, key);
    }

    public String encrypt(String message, int key){
        return strategy.encrypt(message, key);
    }
}
