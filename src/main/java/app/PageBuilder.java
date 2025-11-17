package app;

import app.pages.LoginPage;
import app.pages.MainPage;
import app.pages.director.ProjectReportsPage;
import app.pages.supervisor.ProjectsListPage;
import app.pages.supervisor.ProposalListPage;

public class PageBuilder {

    public static LoginPage buildLoginPage() {
        return new LoginPage("/");
    }

    public static MainPage buildMainPage() {
        return new MainPage("/");
    }

    public static ProposalListPage buildProposalListPage() {
       return new ProposalListPage("/profile/project-proposals");
    }

    public static ProjectReportsPage buildProjectReportsPage() {
        return new ProjectReportsPage("/profile/inst-project-reports/all/1");
    }

    public static ProjectsListPage buildProjectsListPage() {
        return new ProjectsListPage("/profile/projects");
    }

}
