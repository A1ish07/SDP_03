public class RasterRenderer implements Renderer {

    @Override
    public String renderCircle(int radius) {
        return "Raster circle radius=" + radius;
    }

    @Override
    public String renderSquare(int side) {
        return "Raster square side=" + side;
    }
}