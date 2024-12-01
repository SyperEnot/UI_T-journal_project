import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SearchPage;
import static data.TestData.*;

@Owner("yorohov")
@Story("Tinkoff journal tests")
@Tag("journal-tests")
public class SearchTests extends TestBase {

    SearchPage searchPage = new SearchPage ();

    @Test
    @DisplayName("Проверка поиска по слову")
    void searchResultsShouldNotBeEmpty() {
        searchPage.openPage();
        searchPage.goToSearch();
        searchPage.inputValue(VALID);
        searchPage.checkSearchNotNull();
    }

    @Test
    @DisplayName("Раздел первой карточки релевантен поисковому запросу")
    void searchResultsShouldContainExpectedCategory() {
        searchPage.openPage();
        searchPage.goToSearch();
        searchPage.inputValue(INVALID);
        searchPage.checkCategory();
    }

    @Test
    @DisplayName("Проверка нотифкации при отсутсвии результатов поиска")
    void checkNotificationTextTest() {
        searchPage.openPage();
        searchPage.goToSearch();
        searchPage.inputValue(NOTFOUND);
        searchPage.checkNoResult();
    }
}
