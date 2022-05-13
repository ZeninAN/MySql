package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id='dashboard']");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public void getHeading() {
        heading.shouldHave(Condition.text("  Личный кабинет"));
    }
}
