
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dataset {
    private double[][] X;
    private double[] y;

    public Dataset() {
        // Initialize X with some test values
        this.X = new double[][] {
                {1.0, 2.0},
                {2.0, 3.0},
                {3.0, 4.0}
        };

        // Initialize y with some test values
        this.y = new double[] {0.0, 1.0, 1.0};
    }

    public double[][] getX() {
        return X;
    }

    public double[] gety() {
        return y;
    }
}