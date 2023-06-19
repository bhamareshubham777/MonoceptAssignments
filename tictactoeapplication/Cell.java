package com.techlabs.tictactoeapplication;

public class Cell {
    private MarkType mark;

    public Cell() {
        mark = MarkType.EMPTY;
    }

    public boolean isEmpty() {
        return mark == MarkType.EMPTY;
    }

    public MarkType getMark() {
        return mark;
    }

    public void setMark(MarkType mark) throws CellAlreadyMarkedException {
        if (!isEmpty()) {
            throw new CellAlreadyMarkedException("Cell is already marked");
        }
        this.mark = mark;
    }
}