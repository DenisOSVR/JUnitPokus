import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class MyHistoryTest {
    @TempDir
    private Path tmpDir;

    @Test
    void readTest() {
        MyHistory h = new MyHistory(tmpDir + "\\readTest");
        assertThrows(IOException.class, () -> h.read());
    }

    @Test
    void saveTest() {
        MyHistory h = new MyHistory(tmpDir + "\\saveTest");
        try {
            h.save();
        } catch (IOException e) {
            assertTrue(false);
        }
    }

    @Test
    void saveReadTest() {
        MyHistory a = new MyHistory(tmpDir + "\\saveReadTest");
        try {
            a.save();
        } catch (IOException e) {
            assertTrue(false);
        }

        try {
            MyHistory b = new MyHistory(tmpDir + "\\saveReadTest");
            b.read();
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
