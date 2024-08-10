public class Not extends Gate {
    public Qubit doOperation(Qubit input) {
        switch(input.toString()) {
            case "0": return new Qubit("1");
            case "1": return new Qubit("0");
            case "+": return new Qubit("+");
            case "-": return new Qubit("-");
            default:
                System.out.println("Error in not gate operation with input: " + input.toString());
                return new Qubit();
        }
    }
}
