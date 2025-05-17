import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class SILab2Test {

    @Test
    void testEveryStatement() {
        List<Item> emptyList = new ArrayList<>();
        assertEquals(0, SILab2.checkCart(emptyList, "1234567890123456"));

        List<Item> invalidName = List.of(new Item(null, 1, 100, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(invalidName, "1234567890123456"));

        List<Item> discountItem = List.of(new Item("item1", 1, 100, 0.4));
        assertEquals(60, SILab2.checkCart(discountItem, "1234567890123456"));

        List<Item> noDiscountItem = List.of(new Item("item1", 1, 100, 0));
        assertEquals(100, SILab2.checkCart(noDiscountItem, "1234567890123456"));

        List<Item> validItem = List.of(new Item("item1", 1, 100, 0));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(validItem, "123456789012345a"));

        assertThrows(RuntimeException.class, () -> SILab2.checkCart(validItem, "123"));
    }

    @Test
    void testMultipleCondition() {
        Item item1 = new Item("item1", 3, 150, 0.0);
        assertEquals(450, SILab2.checkCart(List.of(item1), "1234567890123456"));

        Item item2 = new Item("item2", 12, 150, 0.0);
        assertEquals(1770, SILab2.checkCart(List.of(item2), "1234567890123456"));

        Item item3 = new Item("item3", 3, 150, 0.15);
        assertEquals(352.5, SILab2.checkCart(List.of(item3), "1234567890123456"));

        Item item4 = new Item("item4", 30, 100, 0.15);
        assertEquals(2520, SILab2.checkCart(List.of(item4), "1234567890123456"));

        Item item5 = new Item("item5", 3, 500, 0.0);
        assertEquals(1470, SILab2.checkCart(List.of(item5), "1234567890123456"));

        Item item6 = new Item("item6", 18, 450, 0.0);
        assertEquals(8070, SILab2.checkCart(List.of(item6), "1234567890123456"));

        Item item7 = new Item("item7", 3, 400, 0.25);
        assertEquals(870, SILab2.checkCart(List.of(item7), "1234567890123456"));

        Item item8 = new Item("item8", 20, 450, 0.25);
        assertEquals(6720, SILab2.checkCart(List.of(item8), "1234567890123456"));
    }
}