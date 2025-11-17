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
    void downloadUndelivieredReportsXLSX() {
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        //app.projectReportsPage.open();
        app.mainPage.dropdownMenu.click();
        app.mainPage.dropdownMenuRoute.find(exactText("Отчёты")).click();
        $(byText("Все отчёты")).click();
        app.projectReportsPage.filterAccordion.click();
        if (!app.projectReportsPage.notDelivieredReportsCheckBox.isSelected()) {
            app.projectReportsPage.notDelivieredReportsCheckBox.click();
        } else if (app.projectReportsPage.delivieredReportsCheckBox.isSelected()) {
            app.projectReportsPage.delivieredReportsCheckBox.click();
        }
        app.projectReportsPage.notDelivieredReportsCheckBox.shouldBe(checked);
        app.projectReportsPage.projectReportsList.shouldHave(sizeGreaterThan(0));
        File file = app.projectReportsPage.file.download();
        assertTrue(file.exists());
    }
    @Test
    void downloadUndelivieredReportsXLSXAlternative() { // альтернативный сценарий для проверки что нельзя выгрузить отчеты если фильтр стоит на "Сдано"
        //app.projectReportsPage.open();
        app.projectReportsPage.filterAccordion.click();
        if (!app.projectReportsPage.delivieredReportsCheckBox.isSelected()) {
            app.projectReportsPage.delivieredReportsCheckBox.click();
        }
        app.projectReportsPage.delivieredReportsCheckBox.shouldBe(checked);
        app.projectReportsPage.projectReportsList.shouldHave(sizeGreaterThan(0));
        app.projectReportsPage.uploadDisabled.should(exist);
    }
}
