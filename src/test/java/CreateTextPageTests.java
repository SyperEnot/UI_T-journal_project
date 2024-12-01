import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import pages.CreateTextPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("yorohov")
@Story("Tinkoff journal tests")
@Tag("journal-tests")
public class CreateTextPageTests extends TestBase {

    CreateTextPage createPage = new CreateTextPage ();

    @Test
    @DisplayName("Проверка текста страницы создания поста")
    void CreateTextPageTest(){
        createPage.openPage()
                .goToCommunity()
                .goToCreateText()
                .checkText();
    }

    @Test
    @DisplayName("Проверка наличие ссылки на Правила")
    void checkRulesLinkTest() {
        createPage.openPage()
                .goToCommunity()
                .goToCreateText()
                .checkLinkRules();
    }

    @Test
    @DisplayName("Проверка выделения незаполненного поля e-mail")
    void checkLightEmailTest (){
        createPage.openPage()
                .goToCommunity()
                .goToCreateText()
                .clickSendTextButton()
                .checkLightField();
    }

}
