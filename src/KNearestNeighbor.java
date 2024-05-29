import java.util.Arrays;
import java.util.PriorityQueue;

public class KNearestNeighbor {
    private double[][] X;
    private double[] y;
    private int k;

    public KNearestNeighbor(Dataset dataset, int k) {
        this.X = dataset.getX();
        this.y = dataset.gety();
        this.k = k;
    }

    public int predict(double[] newPoint) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int i = 0; i < X.length; i++) {
            double dist = euclideanDistance(X[i], newPoint);
            maxHeap.add(new double[]{dist, y[i]});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return vote(maxHeap);
    }

    private double euclideanDistance(double[] point1, double[] point2) {
        double sum = 0;
        for (int i = 0; i < point1.length; i++) {
            sum += Math.pow(point1[i] - point2[i], 2);
        }
        return Math.sqrt(sum);
    }

    private int vote(PriorityQueue<double[]> neighbors) {
        int[] counts = new int[(int) (Arrays.stream(y).max().getAsDouble() + 1)];
        while (!neighbors.isEmpty()) {
            counts[(int) neighbors.poll()[1]]++;
        }

        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            maxIndex = counts[i] > counts[maxIndex] ? i : maxIndex;
        }
        return maxIndex;
    }
}
