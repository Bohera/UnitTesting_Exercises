package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest{
    private Database database;
    private static final Integer[] NUMBERS = {5, 8, 21, 68, 81, -5};

    @Before
    public void prepare() throws OperationNotSupportedException {
        Integer[] numbers = NUMBERS;
        database = new Database(numbers);
    }

    @Test
    public void testCreateDatabase() throws OperationNotSupportedException {

        Integer[] dbElements = database.getElements();

        Assert.assertEquals(NUMBERS.length, dbElements.length);

        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals(NUMBERS[i], dbElements[i]);
        }

        //Assert.assertArrayEquals(NUMBERS, dbElements);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithLessThan1Argument() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        new Database(emptyArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThan16Arguments() throws OperationNotSupportedException {
        Integer[] bigIntegerArray = new Integer[17];
        new Database(bigIntegerArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddWithNullArgumentShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddSuccess() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.add(12);
        Integer[] dbElements = database.getElements();
        int lastElementFromDB = dbElements[dbElements.length - 1];

        Assert.assertEquals(12, lastElementFromDB);
        Assert.assertEquals(initialSize + 1, dbElements.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFail() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.remove();
        Integer[] currentElements = database.getElements();

        Assert.assertEquals(initialSize - 1, currentElements.length);

        int secondToLastBeforeDelete = NUMBERS[NUMBERS.length - 2];
        int lastElementAfterDelete = currentElements[currentElements.length - 1];

        Assert.assertEquals(secondToLastBeforeDelete, lastElementAfterDelete);
    }

}