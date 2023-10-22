package org.example;

import java.util.*;

public class CCSConversor {
    List<Integer> col_ptr = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    List<Double> value = new ArrayList<>();


    public CCSMatrix convert(List<COOMatrix> matrix) {
        List<Integer> colCOO = new ArrayList<>();
        List<Integer> orderedCol = new ArrayList<>();
        List<Integer> rowCOO = new ArrayList<>();
        List<Double> valueCOO = new ArrayList<>();
        for (COOMatrix cooMatrix : matrix) {
            colCOO.add(cooMatrix.getCol());
            rowCOO.add(cooMatrix.getRow());
            valueCOO.add(cooMatrix.getValue());
            orderedCol.add(cooMatrix.getCol());
        }
        Collections.sort(orderedCol);
        Set<Integer> orderedSet = new HashSet<>(orderedCol);
        List<Integer> orderedList = new ArrayList<>(orderedSet);

        for (int col : orderedList) {
            List<Integer> positions = new ArrayList<>();
            int pos = 0;
            for (int col2 : colCOO) {
                if (col == col2) {
                    positions.add(pos);

                }
                pos++;
            }
            TreeMap<Integer, Double> rowValue = new TreeMap<>();
            for (int position : positions) {
                rowValue.put(rowCOO.get(position), valueCOO.get(position));
            }
            for (Map.Entry<Integer, Double> entry : rowValue.entrySet()) {
                row.add(entry.getKey());
                value.add(entry.getValue());
            }

        }
        int ptr = 0;
        int row_before = row.get(0);
        col_ptr.add(ptr);
        for (int row : row) {
            if(row_before > row){
                col_ptr.add(ptr);
            }
            ptr+=1;
            row_before = row;
        }
        col_ptr.add(ptr);
        return new CCSMatrix(col_ptr, row, value);
    }
}