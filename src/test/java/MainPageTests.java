import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import static data.TestData.FLOW_MENU_LIST;

@Owner("yorohov")
@Story("Tinkoff journal tests")
@Tag("journal-tests")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage ();

    @Test
    @DisplayName("Проверка списка потоков в меню")
    void checkMenuContentTest() {
        mainPage.openPage()
                .checkFlows(FLOW_MENU_LIST);
    }

    @Test
    @DisplayName("Проверка перехода по нажатию кнопки \"Смотреть всё\" на страницу потоков")
    void checkAppointmentPageTest() {
        mainPage.openPage()
                .clickOnFlowButton();
        mainPage.checkFlowsTitle();
    }

    @Test
    @DisplayName("Проверка наличия ссылки на Телеграмм")
    void checkTelegramLinkTest() {
        mainPage.openPage();
        mainPage.checkLinkTelegram();
    }
}
