public class QuantumGrid {
    private Qubit[][] grid;

    public QuantumGrid() {
        grid = new Qubit[5][5];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                grid[i][j] = Qubit.randomQubit();
            }
        }
    }

    public void apply(Gate gate, int row, int col) {
        grid[row][col] = gate.doOperation(grid[row][col]);
    }

    public void apply2Qs(Gate gate, int row1, int col1, int row2, int col2) {
        gate.doOperation(grid[row1][col1], grid[row2][col2]);
    }

    public boolean equals(QuantumGrid other) {
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(!other.grid[row][col].toString().equals(grid[row][col].toString())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printLineBreak() {
        for(int i = 0; i < grid[0].length * 4; i++) {
            if(i % 4 == 0) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    public void print() {
        printLineBreak();
        for(Qubit[] row : grid) {
            System.out.print("| ");
            for(Qubit q : row) {
                System.out.print(q + " | ");
            }
            System.out.println();
            printLineBreak();
        }
        System.out.println();
    }
}