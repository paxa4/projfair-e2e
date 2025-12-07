import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import app.pages.student.StudentPage;
import static com.codeborne.selenide.Condition.exactText;

public class StudentTest extends A_BaseTest {

    private StudentPage studentPage = new StudentPage();

    @BeforeClass
    void openApp() {
        app.mainPage.open();
        app.mainPage.mockLogin(false);
    }
    @Test
    void checkMyApplications() {
        app.mainPage.dropdownMenu.click();
        app.mainPage.dropdownMenuRoute.find(exactText("Мои заявки")).click();
        studentPage.closeModal();
        studentPage.checkCardsVisible();
    }

    @Test
    void studentLoginAndEditApplications() {
        app.mainPage.dropdownMenu.click();
        app.mainPage.dropdownMenuRoute.find(exactText("Мои заявки")).click();
        studentPage.clickEditApplications();
        studentPage.deleteParticipationCard();
        studentPage.deleteApplication();
        studentPage.saveChanges();
    }
    @Test
    void participateInProject() {
        studentPage.openAllProjects();
        studentPage.participateInProject();
        studentPage.clickPriorityHigh();
        studentPage.clickPriorityMedium();
        studentPage.clickPriorityLow();
        studentPage.submitParticipation();
        studentPage.closeParticipationModal();
    }

}
