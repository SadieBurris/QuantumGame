public class Hadamard extends Gate {
    public Qubit doOperation(Qubit input) {
        switch(input.toString()) {
            case "0": return new Qubit("+");
            case "1": return new Qubit("-");
            case "+": return new Qubit("0");
            case "-": return new Qubit("1");
            default:
                System.out.println("Error in hadamard gate with input " + input.toString());
                return new Qubit();
        }
    }
}
