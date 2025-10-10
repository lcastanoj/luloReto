package com.retoLuloFront.stepDef;

import com.retoLuloFront.questions.ChatboxMessageQuestion;
import com.retoLuloFront.tasks.InteractsWithChatboxTask;
import com.retoLuloFront.tasks.OpenBrowserTask;
import com.retoLuloFront.tasks.UserGoToTheChatboxTask;
import com.retoLuloFront.utils.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.containsString;

public class LuloXFrontStepDef {
    @Before
    public void setUp() {
        setTheStage(new OnlineCast());

        WebDriver customDriver = DriverFactory.getDriver();
        theActorCalled("user").whoCan(BrowseTheWeb.with(customDriver));
    }

    @Given("the user navigates to the LuloX website {string}")
    public void theUserNavigatesToTheLuloXWebsite(String url) {
        theActorInTheSpotlight().wasAbleTo(
                OpenBrowserTask.url(url)
        );
    }

    @When("the user sees the chatbox and clicks on the chatbox to open it")
    public void theUserSeesTheChatboxAndClicksOnTheChatboxToOpenIt() {
        theActorInTheSpotlight().attemptsTo(UserGoToTheChatboxTask.button());
    }

    @And("the user interacts with the chatbox")
    public void theUserInteractsWithTheChatbox() {
        theActorInTheSpotlight().attemptsTo(InteractsWithChatboxTask.chat());
    }

    @Then("the user receives a response from the chat")
    public void theUserReceivesAResponseFromTheChat() {
        theActorInTheSpotlight().should(
                seeThat(ChatboxMessageQuestion.text(), containsString("Lamento que estés teniendo problemas con tu compra."))
        );
    }
}
