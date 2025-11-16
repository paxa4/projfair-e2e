import org.testng.annotations.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;

public class SupervisorTests extends A_BaseTest {
    @BeforeClass
    void login(){
        app.mainPage.open();
        //app.mainPage.login();
        app.mainPage.mockLogin(true);
    }
    @Test
    void checkProposals() {
        //app.proposalListPage.open();
        app.mainPage.dropdownMenu.click();
        app.mainPage.dropdownMenuRoute.find(exactText("Мои заявки")).click();
        app.proposalListPage.proposalCardsList.shouldHave(sizeGreaterThan(0));
    }
    @Test
    void checkProjects() {
        //app.projectsListPage.open();
        app.mainPage.dropdownMenu.click();
        app.mainPage.dropdownMenuRoute.find(exactText("Мои проекты")).click();
        app.projectsListPage.projectsList.shouldHave(sizeGreaterThan(0));
    }

    @Test
    void rejectionReason() {
        //app.proposalListPage.open();
        app.mainPage.dropdownMenu.click();
        app.mainPage.dropdownMenuRoute.find(exactText("Мои заявки")).click();
        app.proposalListPage.rejectionReasonButton.should(exist);
        app.proposalListPage.rejectionReasonButton.click();
        app.proposalListPage.rejectionModal.shouldBe();
        app.proposalListPage.rejectionReasonText.shouldBe(visible).shouldNotHave(exactText(""));
    }
}
