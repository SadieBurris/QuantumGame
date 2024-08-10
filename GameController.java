import java.util.Scanner;

public class GameController {
    private QuantumGrid current;
    private QuantumGrid wanted;
    private Scanner input;
    private String[] lastCoords;
    private Not not;
    private Hadamard hadamard;
    private Gate selectedGate;

    public GameController() {
        current = new QuantumGrid();
        wanted = new QuantumGrid();
        input = new Scanner(System.in);
        not = new Not();
        hadamard = new Hadamard();
        selectedGate = not;
    }

    public void play() {
        draw();
        String lastInput = input.nextLine().strip().toLowerCase();
        switch(lastInput) {
            case "n", "not", "x", "not gate": selectedGate = not; break;
            case "h", "hadamard", "hadamard gate", "h gate": selectedGate = hadamard; break;
            default: 
                lastCoords = lastInput.split(" ");
                current.apply(selectedGate, Integer.parseInt(lastCoords[0]), Integer.parseInt(lastCoords[1]));
        }
        play();
    }

    public void draw() {
        for(int i = 0; i < 100; i++) {
            System.out.println();
        }
        System.out.println();
        System.out.println("Wanted:");
        wanted.print();
        System.out.println("Current:");
        current.print();
        System.out.println("Game Over: " + current.equals(wanted));
        System.out.print("Gate: ");
        System.out.println(selectedGate.equals(not) ? "Not" : "Hadamard");
        System.out.println();
    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.play();
    }
}
