import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@Epic("Проверка на валидацию имени")
public class CheckNameToEmbossTest {
    private final String message;
    private final String name;
    private final boolean expected;

    public CheckNameToEmbossTest(String message, String name, boolean expected){
        this.message = message;
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Проверяем есть ли пробел в середине, с длиной 15", "Тимоти Шаламере", true},
                {"Проверяем имя без пробелов", "ТимотейШевроле", false},
                {"Проверяем имя с длиной 2 символа", "Ти", false},
                {"Проверяем имя с длиной 3 символа", "Т и", true},
                {"Проверяем имя с длиной 19 символов", "Тимотияц Шаламеревы", true},
                {"Проверяем имя с длиной 20 символов", "Тимотияц Шаламеревыы", false},
                {"Проверяем имя с длиной 23 символов", "Тимотияц Швыйаламеревыы", false},
                {"Проверяем имя с пробелом в начале", " ТимотиШаламере", false},
                {"Проверяем имя с пробелом в конце", "ТимотиШаламере ", false},
                {"Проверяем имя с несколькими пробелами", "Тимоти Шала мере", false},
                {"Проверяем пустое имя", "", false},
                {"Проверяем пустое имя", null, false},
        };
    }

    @Step("Compare result")
    public void compareExpectedAndActual(String message, boolean expected, boolean actual) {
        assertEquals(message, expected, actual);
    }

    @Step("Create account")
    public Account createAccount(String name) {
        return new Account(name);
    }

    @Step("Get check name to emboss")
    public boolean getCheckNameToEmboss(Account account) {
        return account.checkNameToEmboss();
    }

    @Test
    @DisplayName("проверяем имя с разными параметрами")
    public void checkNameToEmboss() {
            Account account = createAccount(name);
            boolean actual = getCheckNameToEmboss(account);
            compareExpectedAndActual(message, expected, actual);
        }
}
