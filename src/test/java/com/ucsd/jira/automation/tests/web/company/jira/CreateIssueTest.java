package com.ucsd.jira.automation.tests.web.company.jira;

import com.pwc.core.framework.listeners.Retry;
import com.ucsd.jira.automation.data.Constants;
import com.ucsd.jira.automation.frameworksupport.Groups;
import com.ucsd.jira.automation.frameworksupport.JiraTestCase;
import org.testng.annotations.Test;

import static com.pwc.logging.service.LoggerService.*;


public class CreateIssueTest extends JiraTestCase {

    @Override
    public void beforeMethod() {
    }

    @Override
    public void afterMethod() {
    }

    // @Issue("STORY-1234")
    @Test(retryAnalyzer = Retry.class, groups = {Groups.ACCEPTANCE_TEST})
    public void testCreateIssue() {

        FEATURE("Create Jira Issue ");
        SCENARIO("User logs in and create Jira issue");

        GIVEN("I am a valid user");
        webElementVisible(Constants.NEW_TEST_HEADING);

        WHEN("I navigate with the left plus sign Global item icon");
        webAction(Constants.CREATE_ISSUE_BUTTON);
        // redirect(Constants.HOME_URL);

        THEN("Input Summary and Description of the issue");
       // String test_text = Constants.SUMMARY_TEXT + "UCSD" ;
       // webAction(Constants.SUMMARY_INPUT, test_text);
        webAction(Constants.SUMMARY_INPUT, Constants.SUMMARY_TEXT);
        webAction(Constants.DESCRIPTION_TEXT_AREA, Constants.DESCRIPTION_TEXT);
        webAction(Constants.CREATE_ISSUE_SUBMIT);

       // webAction(Constants.ISSUE_TYPE_COMBOBOX, Constants.ISSUE_TYPE_BUG);

        waitForElementToDisappear(Constants.REMOVE_BLANKET);
       webAction(Constants.SEARCH_ISSUE_BUTTON);
       webAction(Constants.SEARCH_AREA_INPUT,Constants.SEARCH_TEXT);
        System.out.println("im at the end");

        //assertEquals("Verify text", test_text);


        //  GIVEN("I have a known issue number=%s to search for", issueNumber);

        //    WHEN("I search for a Jira issue number");
        //    JiraIssue jiraIssue = findRecentIssue(issueNumber);
//        THEN("The correct Jira issue was found or created");
        //     assertEquals("Verify Issue Number", jiraIssue.getMetadata(), issueNumber);



        //redirect(Constants.HOME_URL);


    }
}