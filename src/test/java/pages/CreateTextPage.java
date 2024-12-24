package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;

public class CreateTextPage {

    private SelenideElement community = $("._pill_opwej_4", 1);
    private SelenideElement createTextButton = $("._fakeForm_1trhq_4");
    private SelenideElement createText = $("._description_to9o0_3");
    private SelenideElement telegram = $("._link_1wiak_3");
    private SelenideElement sendTextButton =$("._button_4ofwg_6", 2);
    private SelenideElement checkField =$("._input_1wff9_45");

    private final String linkTelegram = "https://journal.tinkoff.ru/community-rules";

    @Step("Открыть страницу")
    public CreateTextPage openPage() {
        open("/");
        return this;
    }

    @Step("Переходим в Сообщество")
    public CreateTextPage goToCommunity() {
        community.click();
        return this;
    }

    @Step("Переходим в форму написания статьи")
    public CreateTextPage goToCreateText() {
        createTextButton.click();
        return this;
    }

    @Step("Проверяем что мы на нужной странице")
    public CreateTextPage checkText() {
        createText.shouldHave(text(TEXT));
        return this;
    }

    @Step("Проверяем наличие ссылки на Правила")
    public CreateTextPage checkLinkRules() {
        telegram.shouldHave(href(linkTelegram));
        return this;
    }


    @Step("Переходим в форму написания статьи")
    public CreateTextPage clickSendTextButton() {
        sendTextButton.click();
        return this;
    }

    @Step("Проверяем, что обязательные незаполненые поля подсвечены")
    public CreateTextPage checkLightField() {
        checkField.shouldHave(Condition.cssValue("border-bottom-color", "rgba(219, 33, 19, 1)"));;
        return this;
    }

}
