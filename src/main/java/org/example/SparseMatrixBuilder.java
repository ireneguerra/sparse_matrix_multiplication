package org.example;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrixBuilder {
    private int numRows;
    private int numCols;
    private Map<Integer, Map<Integer, Long>> data;

    public SparseMatrixBuilder(int numRows) {
        this.numRows = numRows;
        this.numCols = numRows;
        this.data = new HashMap<>();
    }

    public void set(int row, int col, long value) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        data.computeIfAbsent(row, k -> new HashMap<>()).put(col, value);
    }

    public SparseMatrix toMatrix() {
        return new SparseMatrix(numRows, numCols, data);
    }
}
