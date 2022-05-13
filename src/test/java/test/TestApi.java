package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.DataHelper;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.getAuthInfo;
import static data.DataHelper.getInvalidAuthInfo;

public class TestApi {
    @BeforeEach
    public void setUp() {
        open("http://localhost:9999");
    }


    @AfterAll
    static void cleanUp() {
        DataHelper.clearDB();
    }

    @Test
    void successEnter() {
        var validUser = getAuthInfo();
        var loginPage = new LoginPage();
        var verificationPage = loginPage.validLogin(validUser);
        var verifyInfo = DataHelper.getVerificationCodeFor();
        var dashboardPage = verificationPage.validVerify(verifyInfo);
        dashboardPage.getHeading();
    }


    @Test
    void wrongEnterPasswordThreeTimes() {
        var invalidUser = getInvalidAuthInfo();
        var loginPage = new LoginPage();
        loginPage.login(invalidUser);
        loginPage.cleanFields();
        loginPage.login(invalidUser);
        loginPage.cleanFields();
        loginPage.login(invalidUser);
        loginPage.blockNotification();
    }
}
