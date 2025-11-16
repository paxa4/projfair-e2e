import com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertTrue;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class DirectorTests extends A_BaseTest {
    @BeforeClass
    void login() {
        app.mainPage.open();
        //app.mainPage.login();
        app.mainPage.mockLogin(true);
    }

    @Test
    void uploadReport() {
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        //app.projectReportsPage.open();
        app.mainPage.dropdownMenu.click();
        app.mainPage.dropdownMenuRoute.find(exactText("Отчёты")).click();
        $(byText("Все отчёты")).click();
        app.projectReportsPage.filterAccordion.click();
        if (!app.projectReportsPage.checkbox.isSelected()) {
            app.projectReportsPage.checkbox.click();
        } else if (app.projectReportsPage.checkboxAlt.isSelected()) {
            app.projectReportsPage.checkboxAlt.click();
        }
        app.projectReportsPage.checkbox.shouldBe(checked);
        app.projectReportsPage.projectReportsList.shouldHave(sizeGreaterThan(0));
        File file = app.projectReportsPage.file.download();
        assertTrue(file.exists());
    }
    @Test
    void uploadReportAlt() {
        //app.projectReportsPage.open();
        app.projectReportsPage.filterAccordion.click();
        if (!app.projectReportsPage.checkboxAlt.isSelected()) {
            app.projectReportsPage.checkboxAlt.click();
        }
        app.projectReportsPage.checkboxAlt.shouldBe(checked);
        app.projectReportsPage.projectReportsList.shouldHave(sizeGreaterThan(0));
        app.projectReportsPage.uploadDisabled.should(exist);
    }
}
