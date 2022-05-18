import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckNameToEmbossTest {
    private final String message;
    private final String name;
    private final boolean expected;

    public CheckNameToEmbossTest(String message, String name, boolean expected){
        this.message = message;
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"пробел в середине, длина 15", "Тимоти Шаламере", true},
                {"без пробелов", "ТимотейШевроле", false},
                {"без пробела, длина 2", "Ти", false},
                {"пробел в середине, длина 3", "Т и", true},
                {"длина 19 символов", "Тимотияц Шаламеревы", true},
                {"длина 20 символов", "Тимотияц Шаламеревыы", false},
                {"длина 23 символов", "Тимотияц Швыйаламеревыы", false},
                {"пробел в начале", " ТимотиШаламере", false},
                {"пробел в конце", "ТимотиШаламере ", false},
                {"несколько пробелов", "Тимоти Шала мере", false},
        };
    }
    
    @Test
    public void checkNameToEmboss() {
            Account account = new Account(name);
            boolean actual = account.checkNameToEmboss();
            assertEquals(message, expected, actual);
        }
}
