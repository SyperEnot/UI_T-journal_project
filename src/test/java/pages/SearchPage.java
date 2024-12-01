package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.*;

public class SearchPage {

    private SelenideElement searchButton = $("._loupe_wvz82_55");
    private SelenideElement searchField = $("._input_wvz82_21");
    private ElementsCollection resultSearch = $$("._root_1m2dt_3");
    private SelenideElement category = $("._root_1m2dt_3");
    private SelenideElement noResult = $("._title_4r1in_1");

    @Step("Открыть страницу")
    public SearchPage openPage() {
        open("/");
        return this;
    }

    @Step("Переходим в поиск")
    public SearchPage goToSearch() {
        searchButton.click();
        return this;
    }

    @Step("Вводим значение для поиска")
    public SearchPage inputValue(String testData) {
        searchField.setValue(testData).pressEnter();
        return this;
    }

    @Step("Проверяем, что найдены результаты")
    public SearchPage checkSearchNotNull() {
        resultSearch.shouldBe(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверяем раздел")
    public SearchPage checkCategory() {
        category.shouldHave(text(INVALID));
        return this;
    }

    @Step("Проверяем, что ничего не обнаружено")
    public SearchPage checkNoResult() {
        noResult.shouldHave(text(RESP));
        return this;
    }
}
