public class Qubit {
    private String symbol;

    public Qubit(String symbol) {
        this.symbol = symbol;
    }

    public Qubit() {
        this("0");
    }

    public String toString() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public static Qubit randomQubit() {
        int num = (int) (Math.random() * 4);
        switch(num) {
            case 0:
                return new Qubit("0");
            case 1:
                return new Qubit("1");
            case 2:
                return new Qubit("+");
            default:
                return new Qubit("-");
        }
    }
}
