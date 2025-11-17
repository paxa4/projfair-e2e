package app;

import app.pages.LoginPage;
import app.pages.MainPage;
import app.pages.director.ProjectReportsPage;
import app.pages.supervisor.ProjectsListPage;
import app.pages.supervisor.ProposalListPage;

public class App {

    public LoginPage loginPage;
    public MainPage mainPage;

    public ProposalListPage proposalListPage;
    public ProjectsListPage projectsListPage;

    public ProjectReportsPage projectReportsPage;

    public App() {

        mainPage = PageBuilder.buildMainPage();
        loginPage = PageBuilder.buildLoginPage();
        proposalListPage = PageBuilder.buildProposalListPage();
        projectsListPage = PageBuilder.buildProjectsListPage();
        projectReportsPage = PageBuilder.buildProjectReportsPage();

    }
}
