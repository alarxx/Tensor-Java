package Tensor;

import static Tensor.Core.tensor;

public class Main {
    public static void main(String[] args) {
        System.out.println("1)--Native multidimensional array--\n");
        //                        col row depth
        float[][][] arr = new float[3][2][2];
        arr[2][1][1] = 123f;

        for(int i=0; i<2; i++){

            // вывод матрицы
            for(int j=0; j<3; j++){
                for(int k=0; k<2; k++){
                    // сначала берем row, потом идем по калоннам
                    // в индексах же представлено наоборот
                    // то есть мы меняем местами j и k
                    // этот swap и реализован в Tensor
                    System.out.print(arr[j][k][i] + " ");
                }
                System.out.println();
            }

            System.out.println();
        }


        System.out.println("2)--Own multi-dimensional array--\n");

        Tensor marr = new Tensor(2, 3, 2);
        marr.set(tensor(123f), 1, 2, 1);
        System.out.println(marr + "\n");


        System.out.println("--Example of filling--\n");

        marr.fill(12f);
        System.out.println(marr + "\n");


        System.out.println("3)--Example of manual filling --\n");

        int rows = 2, cols = 3, channels = 3;

        Tensor t = new Tensor(channels, rows, cols);

        for(int d=0, v=0; d<channels; d++){
            for(int r=0; r<rows; r++){
                for(int c=0; c<cols; c++, v++){
                    t.set(tensor(v), d, r, c);
                }
            }
        }

        System.out.println(t + "\n");


        System.out.println("--Matrix change example --\n");

        Tensor newMat = new Tensor(rows, cols);
        newMat.fill(2);
        System.out.println("first matrix with this\n");
        System.out.println(newMat + "\n");
        t.set(newMat, 0);
        System.out.println("Result of change\n");
        System.out.println(t + "\n");


        System.out.println("--Row change example --\n");

        Tensor newRow = new Tensor(cols);
        newRow.fill(23f);

        t.set(newRow, 0, 0);

        System.out.println("printed with for each\n");
        for(Tensor mat: t){
//            System.out.println("Next Mat");
            for(Tensor row: mat){
//                System.out.println("Next Row");
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
