package app.pages.student;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class StudentPage {

    public SelenideElement closeModalButton = $("img.close-icon");
    public SelenideElement editApplicationsButton = $$("button.edit-btn").findBy(exactText("Редактировать заявки"));
    public SelenideElement deleteParticipationCardButton = $("[data-test='participation-card-btn-delete']");
    public SelenideElement confirmDeleteButton = $("[data-test='delete-participation-modal-btn-delete']");
    public SelenideElement saveChangesButton = $$("button.btn").findBy(exactText("сохранить изменения"));
    public ElementsCollection cards = $$("[data-test='participation-card']");
    public SelenideElement allProjectsLink = $$("a").findBy(exactText("Все проекты"));
    public SelenideElement participateButton = $("[data-test='project-card-btn-participate']");
    public SelenideElement priorityHigh = $("[data-test='participation-modal-priority-high']");
    public SelenideElement priorityMedium = $("[data-test='participation-modal-priority-medium']");
    public SelenideElement priorityLow = $("[data-test='participation-modal-priority-low']");
    public SelenideElement submitButton = $("[data-test='participation-modal-btn-submit']");
    public SelenideElement backToProjectsButton = $("[data-test='participation-success-modal-btn-home']");

    public void closeModal() {
        closeModalButton.shouldBe(visible).click();
    }
    public void clickEditApplications() {
        editApplicationsButton.shouldBe(visible).click();
    }
    public void deleteParticipationCard() {
        deleteParticipationCardButton.shouldBe(visible).click();
    }
    public void deleteApplication() {
        confirmDeleteButton.shouldBe(visible).click();
    }
    public void saveChanges() {
        saveChangesButton.shouldBe(visible).click();
    }
    public void checkCardsVisible() {
        cards.first().shouldBe(visible);
    }
    public void openAllProjects() {
        allProjectsLink.shouldBe(visible).click();
    }
    public void participateInProject() {
        participateButton.shouldBe(visible).click();
    }
    public void clickPriorityHigh() {
        priorityHigh.shouldBe(visible).click();
    }
    public void clickPriorityMedium() {
        priorityMedium.shouldBe(visible).click();
    }
    public void clickPriorityLow() {
        priorityLow.shouldBe(visible).click();
    }
    public void submitParticipation() {
        submitButton.shouldBe(visible).click();
    }
    public void closeParticipationModal() {
        backToProjectsButton.shouldBe(visible).click();
    }
}
