package Figures;

public class Pawn extends Figure {

    private boolean isFirstStep = true;

    public Pawn(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1) {
        // ход на 2 клетки
        if (this.isFirstStep) {
            if ((this.getColor() == 'w' && row1 == row + 2 && col == col1 && row == 1) ||
                    (this.getColor() == 'b' && row1 == row - 2 && col == col1 && row == 6)) {
                this.isFirstStep = false;
                return true;
            }
        }
        // ход на 1 клетку
        if ((this.getColor() == 'w' && row1 == row + 1 && col == col1) ||
                (this.getColor() == 'b' && row1 == row - 1 && col == col1)) {
            this.isFirstStep = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1) {
        switch (this.getColor()) {
            case 'w':
                if (Math.abs(row - row1) == 1 && Math.abs(col - col1) == 1) {
                    return true;
                }
                ;
                break;
            case 'b':
                if (Math.abs(row - row1) == 1 && Math.abs(col - col1) == 1) {
                    return true;
                }
                ;
                break;
        }

        return false;
    }
}
