import Figures.Figure;
import Figures.Pawn;
import Figures.Knight;
import Figures.Rook;
import Figures.Bishop;
import Figures.Queen;
import Figures.King;


public class Board {

    private char colorGame;
    private Figure fields[][] = new Figure[8][8];
    public void setColorGame(char colorGame)
    {
        this.colorGame = colorGame;
    }
    public  char getColorGame()
    {
        return colorGame;
    }

//****размещение фигур на доске*****///
    public void init(){
        this.fields[1] = new Figure[]{
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
        };
        this.fields[6] = new Figure[] {
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
        };
        this.fields[0] = new Figure[]{
                new Rook("R", 'w'), new Knight("N", 'w'),
                new Bishop("B", 'w'), new Queen("Q", 'w'),
                new King("K", 'w'), new Bishop("B", 'w'),
                new Knight("N", 'w'),new Rook("R", 'w')
        };
        this.fields[7] = new Figure[]{
                new Rook("R", 'b'), new Knight("N", 'b'),
                new Bishop("B", 'b'), new Queen("Q", 'b'),
                new King("K", 'b'), new Bishop("B", 'b'),
                new Knight("N", 'b'), new Rook("R", 'b')
        };
    }
//***********************//

    public String getCell(int row, int col){
        Figure figure = this.fields[row][col];
        if (figure ==null){
            return "    ";
        }
        return  " " + figure.getColor() + figure.getName()+ " ";
    }


//*****отпечатка доски*******//
    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for (int row = 7; row > -1 ; row --){
            System.out.print(row);
            for (int col=0; col<8; col++){
                System.out.print("|"+getCell(row, col));
            }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }

        for(int col=0; col< 8; col++){
            System.out.print("    "+col);
        }
    }

    public boolean move_figure(int row, int col, int row1, int col1) {
        Figure figure = this.fields[row][col];

        // Проверяем, что фигура присутствует и что это её цвет хода
        if (figure != null && figure.getColor() == this.colorGame) {
            // Проверка на обычный ход
            if (figure.canMove(row, col, row1, col1) && this.fields[row1][col1] == null) {
                this.fields[row1][col1] = figure;
                this.fields[row][col] = null;
                return true;
            }
            // Проверка на атаку
            else if (figure.canAttack(row, col, row1, col1) && this.fields[row1][col1] != null
                    && this.fields[row1][col1].getColor() != figure.getColor()) {
                this.fields[row1][col1] = figure;
                this.fields[row][col] = null;
                return true;
            }
        }
        return false;
    }
    // фигуры кроме коня не могут перепрыгивать через другие фигуры, поэтому делаем проверку, свободен ли путь
    public boolean path_free(int row, int col, int row1, int col1) {
        if (row == row1) { // горизонтальное перемещение
            int step = (col1 > col) ? 1 : -1;
            for (int c = col + step; c != col1; c += step) {
                if (fields[row][c] != null) return false;
            }
        } else if (col == col1) { // вертикальное перемещение
            int step = (row1 > row) ? 1 : -1;
            for (int r = row + step; r != row1; r += step) {
                if (fields[r][col] != null) return false;
            }
        } else if (Math.abs(row1 - row) == Math.abs(col1 - col)) { // диагональное перемещение
            int rowStep = (row1 > row) ? 1 : -1;
            int colStep = (col1 > col) ? 1 : -1;
            int r = row + rowStep, c = col + colStep;
            while (r != row1 && c != col1) {
                if (fields[r][c] != null) return false;
                r += rowStep;
                c += colStep;
            }
        }
        return true;
    }

}
