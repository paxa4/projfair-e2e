package app.pages.director;

import app.pages.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProjectReportsPage extends BasePage {
    public ElementsCollection projectReportsList = $$("[data-test^='institute-director-project-reports-projectReport-']");
    public SelenideElement filterAccordion = $("[data-test='institute-director-project-reports-filter-accordion']");
    public SelenideElement notDelivieredReportsCheckBox = $("[data-test='institute-director-project-reports-not-delivered'] input.checkbox");
    public SelenideElement delivieredReportsCheckBox = $("[data-test='institute-director-project-reports-delivered'] input.checkbox");
    public SelenideElement file = $("[data-test='institute-director-project-reports-upload-report']");
    public SelenideElement downloadDisabled = $("[data-test='institute-director-project-reports-upload-disabled']");
    public ProjectReportsPage(String pageUrl) {
        super(pageUrl);
    }
}
