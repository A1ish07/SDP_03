# Assignment 3: Bridge Pattern

- **Name:** Alimbayev Alisher
- **Group:** SE-2528
- **Topic:** A
- **Repository:** https://github.com/A1ish07/SDP_03
- **Base commit (working I1/I2 version):** `3bf2d76`

## Role map

| Role | Class | Source path |
|---|---|---|
| Abstraction | `Shape` | `src/Shape.java` |
| A1 (refined abstraction) | `Circle` (radius 2) | `src/Circle.java` |
| A2 (refined abstraction) | `Square` (side 3) | `src/Square.java` |
| Implementor | `Renderer` | `src/Renderer.java` |
| I1 | `VectorRenderer` | `src/VectorRenderer.java` |
| I2 | `RasterRenderer` | `src/RasterRenderer.java` |
| I3 (extension) | `AsciiRenderer` | `src/AsciiRenderer.java` |
| Client | `Main` | `src/Main.java` |

## Where the Bridge is

- **Bridge field:** `protected Renderer renderer` in `src/Shape.java` (an interface-typed reference set through the constructor).
- **execute():** declared abstract in `Shape`; implemented in `Circle` (`renderer.renderCircle(radius)`) and `Square` (`renderer.renderSquare(side)`).
- **setImplementation(Renderer):** `src/Shape.java`, replaces the stored `renderer` on the same object.
- **T5 check:** method `checkRuntimeSwitch()` in `src/Main.java`.

## How to run

From the project root:

```
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected results

<img width="672" height="208" alt="image" src="https://github.com/user-attachments/assets/e6feefbf-4c16-4d66-af20-a8795d36f132" />


## Extension (I3)

`AsciiRenderer` was added in a separate commit after the base commit `3bf2d76`. Only the new class `src/AsciiRenderer.java` and `src/Main.java` (checks T6-T7) changed. `Shape`, `Circle`, `Square`, `Renderer`, `VectorRenderer` and `RasterRenderer` are unchanged. The diff is in `extension.diff`, created with:

```
git diff 3bf2d76 HEAD -- src > extension.diff
```
