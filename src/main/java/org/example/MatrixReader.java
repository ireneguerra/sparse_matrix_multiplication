package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {
    List<COOMatrix> matrix = new ArrayList<>();

    public List<COOMatrix> matrixReader(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int numRows = 0;
        int numCols = 0;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("%")) {
                continue;
            }

            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 2) {
                //numRows = Integer.parseInt(parts[0]);
                //numCols = Integer.parseInt(parts[1]);
                break;
            }
        }

        while ((line = reader.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 3) {
                int row = Integer.parseInt(parts[0]) - 1;
                int col = Integer.parseInt(parts[1]) - 1;
                double value = Double.parseDouble(parts[2]);
                matrix.add(new COOMatrix(row, col, value));
            }
        }
        reader.close();
        return matrix;
    }


}
