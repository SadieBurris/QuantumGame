import java.util.Scanner;
import javax.swing.JFrame;

public class GameController {
    private QuantumGrid current;
    private QuantumGrid wanted;
    private Scanner input;
    private String[] lastCoords;
    private Not not;
    private Hadamard hadamard;
    private Swap swap;
    private Gate selectedGate;
    private JFrame frame;

    public GameController() {
        current = new QuantumGrid();
        wanted = new QuantumGrid();
        input = new Scanner(System.in);
        not = new Not();
        hadamard = new Hadamard();
        swap = new Swap();
        selectedGate = not;
        frame = new JFrame("Quantum Game");
        frame.setSize(600, 600);  
        frame.add(new FrameDraw(this));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);
    }

    public void play(String command) {
        String lastInput = command.strip().toLowerCase();
        switch(lastInput) {
            case "n", "not", "x", "not gate": selectedGate = not; break;
            case "h", "hadamard", "hadamard gate", "h gate": selectedGate = hadamard; break;
            case "swap", "s": selectedGate = swap; break;
            default: 
                lastCoords = lastInput.split(" ");
                if(selectedGate.equals(swap)) {
                    current.apply2Qs(selectedGate, Integer.parseInt(lastCoords[0]), Integer.parseInt(lastCoords[1]), Integer.parseInt(lastCoords[2]), Integer.parseInt(lastCoords[3]));
                } else {
                    current.apply(selectedGate, Integer.parseInt(lastCoords[0]), Integer.parseInt(lastCoords[1]));
                }
        }
    }

    public String getSelectedGate() {
        return selectedGate.equals(swap) ? "swap" : selectedGate.equals(not) ? "not" : selectedGate.equals(hadamard) ? "hadamard" : "error";
    }

    public QuantumGrid[] getGrids() {
        return new QuantumGrid[]{current, wanted};
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
        System.out.println(selectedGate.equals(not) ? "Not" : selectedGate.equals(hadamard) ? "Hadamard" : "Swap");
        System.out.println();
    }

    public static void main(String[] args) {
        GameController game = new GameController();
        //game.play();
    }
}
