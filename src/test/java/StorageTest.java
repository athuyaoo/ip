import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class StorageTest {
    @Test
    public void loadEmptyFile() {
        Storage storage = new Storage(Paths.get(System.getProperty("user.dir")));
        assertEquals(storage.load().size(), 0);
    }
}
