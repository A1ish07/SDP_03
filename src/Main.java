public class Main {

    private static int passed = 0;
    private static int total = 0;

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    private static void runDemo() {
        checkCombination("T1", new Circle("C1", 2, new VectorRenderer()),
                new VectorRenderer(), "VECTOR circle radius=2");
        checkCombination("T2", new Circle("C1", 2, new RasterRenderer()),
                new RasterRenderer(), "RASTER circle radius=2");
        checkCombination("T3", new Square("S1", 3, new VectorRenderer()),
                new VectorRenderer(), "VECTOR square side=3");
        checkCombination("T4", new Square("S1", 3, new RasterRenderer()),
                new RasterRenderer(), "RASTER square side=3");
        checkRuntimeSwitch();

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void checkCombination(String checkId, Shape shape,
                                         Renderer renderer, String expected) {
        String actual = shape.execute();
        String classes = shape.getClass().getSimpleName()
                + " + " + renderer.getClass().getSimpleName();
        boolean ok = expected.equals(actual);
        record(ok);
        System.out.println(checkId + " " + status(ok) + " | " + classes
                + " | result=" + actual + (ok ? "" : " | expected=" + expected));
    }

    private static void checkRuntimeSwitch() {
        Circle original = new Circle("C1", 2, new VectorRenderer());
        String idBefore = original.getId();
        int radiusBefore = original.getRadius();

        String before = original.execute();
        Shape afterSwitch = switchImplementation(original, new RasterRenderer());
        String after = afterSwitch.execute();

        boolean sameObject = (afterSwitch == original);
        boolean stateUnchanged = idBefore.equals(original.getId())
                && radiusBefore == original.getRadius();
        boolean resultsOk = "VECTOR circle radius=2".equals(before)
                && "RASTER circle radius=2".equals(after);
        boolean ok = sameObject && stateUnchanged && resultsOk;
        record(ok);

        System.out.println("T5 " + status(ok) + " | sameObject=" + sameObject
                + " | stateUnchanged=" + stateUnchanged);
        System.out.println("  before=" + before + " | after=" + after);
        if (!ok) {
            System.out.println("  expected before=VECTOR circle radius=2"
                    + " | after=RASTER circle radius=2");
        }
    }

    private static Shape switchImplementation(Shape shape, Renderer newRenderer) {
        shape.setImplementation(newRenderer);
        return shape;
    }

    private static void record(boolean ok) {
        total++;
        if (ok) {
            passed++;
        }
    }

    private static String status(boolean ok) {
        return ok ? "PASS" : "FAIL";
    }
}