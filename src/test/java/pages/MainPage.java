package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.List;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private ElementsCollection flows = $("._flows_t97zd_4").$$("a");
    private final SelenideElement flowButton = $("._link_5o2zi_3");
    private final SelenideElement content = $("._heading_juhjt_1");
    private final SelenideElement telegram = $("[data-social='telegram']");

    private final String Title = "Потоки";
    private final String linkTelegram = "//t.me/addlist/YlFKTKFrX9wwYjQy";

    @Step("Открыть страницу")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Проверяем наличие потоков")
    public MainPage checkFlows(List<String> mainFlows) {
        flows.shouldHave(textsInAnyOrder(mainFlows));
        return this;
    }

    @Step("Кликнуть на кнопку перехода к потокам")
    public void clickOnFlowButton() {
        flowButton.click();
    }

    @Step("Проверить текст")
    public void checkFlowsTitle() {
        content.shouldHave(text(Title));
    }

    @Step("Проверяем наличие ссылки на Телеграмм")
    public void checkLinkTelegram() {
        telegram.shouldHave(href(linkTelegram));
    }
}
