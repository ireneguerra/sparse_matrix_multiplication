package org.example;

import java.util.ArrayList;
import java.util.List;

public class CRSConversor {
    List<Integer> row_ptr = new ArrayList<>();
    List<Integer> col = new ArrayList<>();
    List<Double> value = new ArrayList<>();


    public CRSMatrix convert(List<COOMatrix> matrix) {
        int ptr = 0;
        row_ptr.add(ptr);
        int row = matrix.get(0).getRow();
        for (COOMatrix cooMatrix : matrix) {
            col.add(cooMatrix.getCol());
            value.add(cooMatrix.getValue());
            if (cooMatrix.getRow() != row) {
                row_ptr.add(ptr);
                row = cooMatrix.getRow();
            }
            ptr+=1;
        }
        row_ptr.add(ptr);
        return new CRSMatrix(row_ptr, col, value);
    }

}
