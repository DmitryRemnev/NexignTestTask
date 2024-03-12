import org.dmitry.testtask.trie.Trie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrieTest {
    Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();

        trie.insert("Волга");
        trie.insert("Волга");
        trie.insert("Обь");
    }

    @Test
    public void testCountTwo() {
        assertEquals(2, trie.countWords("Волга"));
    }

    @Test
    public void testCountOne() {
        assertEquals(1, trie.countWords("Обь"));
    }

    @Test
    public void testCountZero() {
        assertEquals(0, trie.countWords("Енисей"));
    }
}
