package org.example;

//C:\\Users\\irene\\IdeaProjects\\sparse_matrix_multiplication\\

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Controller {
    MatrixReader reader = new MatrixReader();
    List<COOMatrix> matrix = new ArrayList<>();

    public void controller() {
        try {
            matrix = reader.matrixReader("src\\main\\resources\\mc2depi.mtx");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("leida");
        CRSConversor crsConversor = new CRSConversor();
        CRSMatrix crsMatrix = crsConversor.convert(matrix);
        System.out.println("convertida a crs");
        CCSConversor ccsConversor = new CCSConversor();
        CCSMatrix ccsMatrix = ccsConversor.convert(matrix);
        System.out.println("convertida a ccs");
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        long startTime = System.currentTimeMillis();
        SparseMatrix sparseMatrix = matrixMultiplication.multiply(crsMatrix, ccsMatrix);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ms");
       /* System.out.println(sparseMatrix);
        for (int i = 0; i < sparseMatrix.getNumRows(); i++) {
            for (int j = 0; j < sparseMatrix.getNumCols(); j++) {
                System.out.print(sparseMatrix.get(i, j) + " ");
            }
            System.out.println();
        }
*/

    }

}
