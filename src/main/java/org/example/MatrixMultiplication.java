package org.example;

public class MatrixMultiplication {
    public SparseMatrix multiply(CRSMatrix a, CCSMatrix b){
        SparseMatrixBuilder builder = new SparseMatrixBuilder(a.getSize());

        for (int i = 0; i < a.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                int ii = a.getRow_ptr().get(i);
                int iEnd = a.getRow_ptr().get(i + 1);
                int jj = b.getCol_ptr().get(j);
                int jEnd = b.getCol_ptr().get(j + 1);
                long s = 0;
                while (ii < iEnd && jj < jEnd) {
                    int aa = a.getCol().get(ii);
                    int bb = b.getRow().get(jj);
                    if (aa == bb) {
                        s += a.getValue().get(ii) * b.getValue().get(jj);
                        ii++;
                        jj++;
                    } else if (aa < bb) {
                        ii++;
                    } else {
                        jj++;
                    }
                    if (s != 0) {
                        builder.set(i, j, s);
                    }
                }

            }
        }
        return builder.toMatrix();
    }
}
