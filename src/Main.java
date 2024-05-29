public class Main {
    public static void main(String[] args) {
        Dataset dataset = new Dataset();
        KNearestNeighbor knn = new KNearestNeighbor(dataset, 2);
        double[] newPoint = new double[] {1.0, 2.0};
        System.out.println(knn.predict(newPoint));
        double[] newPoint2 = new double[] {3.0, 4.0};
        System.out.println(knn.predict(newPoint2));
        double[] newPoint3 = new double[] {2.0, 3.0};
        System.out.println(knn.predict(newPoint3));
    }
}