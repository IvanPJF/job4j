package ru.job4j.tictactoe;

public class Show extends BaseShow {

    private static final String LS = System.lineSeparator();

    public Show(IBoard board) {
        super(board);
    }

    /**
     * Create and draw a board in the console.
     *
     * @return Board in string format.
     */
    @Override
    public String drawBoard() {
        StringBuilder buildBoard = new StringBuilder();
        int allWidth = buildHead(buildBoard);
        buildDelimiter(buildBoard, allWidth);
        ICell firstCellInRow = null;
        for (ICell cell : board.allCells()) {
            if (firstCellInRow == null) {
                firstCellInRow = cell;
            }
            if (cell.getX() != firstCellInRow.getX()) {
                buildNumberRowDelimiter(buildBoard, allWidth, firstCellInRow);
                firstCellInRow = cell;
            }
            buildFormatCell(buildBoard, cell, false);
        }
        if (firstCellInRow != null) {
            buildNumberRowDelimiter(buildBoard, allWidth, firstCellInRow);
        }
        String result = buildBoard.toString();
        System.out.println(result);
        return result;
    }

    /**
     * Creates a board head.
     * @param sb
     * @return The width of the board.
     */
    private int buildHead(StringBuilder sb) {
        ICell firstCell = null;
        for (ICell cell : board.allCells()) {
            if (firstCell == null) {
                firstCell = cell;
            }
            if (cell.getX() == firstCell.getX()) {
                buildFormatCell(sb, cell, true);
            } else {
                break;
            }
        }
        return sb.length();
    }

    /**
     * Formats a cell as a string with the specified sides and label.
     * @param sb
     * @param cell Cell for formatting.
     * @param isHead True - for the head of the board, else - False
     */
    private void buildFormatCell(StringBuilder sb, ICell cell, boolean isHead) {
        String side = "|";
        String mark = cell.getMark();
        if (isHead) {
            side = " ";
            mark = String.valueOf(cell.getY());
        }
        sb.append(String.format("%1$s %2$s %1$s", side, mark));
    }

    /**
     * Creates a string separator between board lines.
     * @param sb
     * @param allWidth The width of the board.
     */
    private void buildDelimiter(StringBuilder sb, int allWidth) {
        sb.append(LS);
        sb.append("=".repeat(Math.max(0, allWidth)));
        sb.append(LS);
    }

    /**
     * Creates a string line number.
     * @param sb
     * @param allWidth The width of the board.
     * @param firstInRow Line number.
     */
    private void buildNumberRowDelimiter(StringBuilder sb, int allWidth, ICell firstInRow) {
        sb.append(String.format(" %s", firstInRow.getX()));
        buildDelimiter(sb, allWidth);
    }
}
