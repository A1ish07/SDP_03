public class Main {

    public static void main(String[] args) {

        Shape circle = new Circle("C1",2, new VectorRenderer());
        System.out.println(circle.execute());
    }
}