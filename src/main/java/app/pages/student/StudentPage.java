package app.pages.student;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class StudentPage {


    public SelenideElement closeModalButton = $("img.close-icon");
    public SelenideElement editApplicationsButton = $$("button.edit-btn").findBy(exactText("Редактировать заявки"));
    public SelenideElement deleteParticipationCardButton = $("[data-test='participation-card-btn-delete']");
    public SelenideElement confirmDeleteButton = $("[data-test='delete-participation-modal-btn-delete']");
    public SelenideElement saveChangesButton = $$("button.btn").findBy(exactText("сохранить изменения"));


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
}
