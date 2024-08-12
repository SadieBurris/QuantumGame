public class Swap extends Gate {
    public void doOperation(Qubit q, Qubit other) {
        String tempSymbol = q.toString();
        q.setSymbol(other.toString());
        other.setSymbol(tempSymbol);
    }
}
