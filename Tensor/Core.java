package Tensor;

public class Core {
    public static void throwError(String error) {
        System.out.println(error);
        int a = 8 / 0;
    }

    public static Tensor tensor(float scalar) {
        return new Tensor().setScalar(scalar);
    }

    public static Tensor tensor(float[] vector) {
        Tensor tensor = new Tensor(vector.length);

        for (int i = 0; i < vector.length; i++) {
            tensor.get(i).setScalar(vector[i]);
        }

        return tensor;
    }

    public static Tensor tensor(float[][] matrix) {
        int rows = matrix.length,
                cols = matrix[0].length;

        Tensor tensor = new Tensor(rows, cols);

        for (int i = 0; i < rows; i++) {
            tensor.set(tensor(matrix[i]), i);
        }

        return tensor;
    }

    public static Tensor tensor(float[][][] image) {
        int rows = image[0].length,
                cols = image[0][0].length,
                channels = image.length;

        Tensor tensor = new Tensor(channels, rows, cols);

        for (int i = 0; i < channels; i++) {
            tensor.set(tensor(image[i]), i);
        }

        return tensor;
    }

    public static Tensor tensor(float[][][][] array4) {
        int rows = array4[0][0].length,
                cols = array4[0][0][0].length,
                channels = array4[0].length,
                d = array4.length;

        Tensor tensor = new Tensor(d, channels, rows, cols);

        for (int i = 0; i < d; i++) {
            tensor.set(tensor(array4[i]), i);
        }

        return tensor;
    }

}