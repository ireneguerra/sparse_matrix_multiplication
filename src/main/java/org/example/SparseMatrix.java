package org.example;

import java.util.Map;
import java.util.HashMap;

public class SparseMatrix {
    private int numRows;
    private int numCols;
    private Map<Integer, Map<Integer, Long>> data;

    public SparseMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.data = new HashMap<>();
    }

    public SparseMatrix(int numRows, int numCols, Map<Integer, Map<Integer, Long>> data) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.data = data;
    }

    public long get(int row, int col) {
        if (data.containsKey(row) && data.get(row).containsKey(col)) {
            return data.get(row).get(col);
        }
        return 0;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }
}
