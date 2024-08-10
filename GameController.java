public class GameController {
    private QuantumGrid current;
    private QuantumGrid wanted;

    public GameController() {
        current = new QuantumGrid();
        wanted = new QuantumGrid();
    }

    public void play() {
        draw();
        current.apply(new Not(), 0, 0);
        draw();

    }

    public void draw() {
        for(int i = 0; i < 100; i++) {
            System.out.println();
        }
        System.out.println();
        System.out.println("Current:");
        current.print();
        System.out.println("Wanted:");
        wanted.print();
        System.out.println("Game Over: " + current.equals(wanted));
        System.out.println();
    }

    public static void main(String[] args) {
        GameController game = new GameController();
        game.play();
    }
}
