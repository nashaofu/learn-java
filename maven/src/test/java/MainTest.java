import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MainTest {
  @Test
  void testFact() {
    assertEquals(1, Main.fact(1));
    assertEquals(2, Main.fact(2));
    assertEquals(6, Main.fact(3));
    assertEquals(3628800, Main.fact(10));
    assertEquals(2432902008176640000L, Main.fact(20));
  }
}
