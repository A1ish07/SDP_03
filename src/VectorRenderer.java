public class VectorRenderer implements Renderer {

    @Override
    public String renderCircle(int radius) {
        return "Vector circle radius=" + radius;
    }

    @Override
    public String renderSquare(int side) {
        return "Vector square side=" + side;
    }
}