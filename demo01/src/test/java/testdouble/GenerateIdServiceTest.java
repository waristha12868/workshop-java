  
package testdouble;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateIdServiceTest {
    @Test
    @DisplayName("ID = XYZ7")
    public void case01() {
        GenerateIdService service = new GenerateIdService();
        String id = service.get();
        assertEquals("XYZ7", id);
    }
}
