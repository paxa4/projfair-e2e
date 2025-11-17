import org.testng.annotations.*;

public class CandidateTests extends A_BaseTest {
    @BeforeClass
    void login(){
        app.mainPage.open();
        //app.mainPage.login();
        app.mainPage.mockLogin(false);
    }
}
