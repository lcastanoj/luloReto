package com.retoLuloFront.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static com.retoLuloFront.userInterfaces.ChatBoxUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class InteractsWithChatboxTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        String mainWindow = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        actor.attemptsTo(
                WaitUntil.the(THIRD_IFRAME, isPresent()).forNoMoreThan(30).seconds(),
                Switch.toFrame(THIRD_IFRAME.resolveFor(actor))
        );

        actor.attemptsTo(
                WaitUntil.the(INTERACTS_BUTTON, isPresent()).forNoMoreThan(30).seconds(),
                Click.on(INTERACTS_BUTTON)
        );
    }

    public static InteractsWithChatboxTask chat() {
        return new InteractsWithChatboxTask();
    }

    private void waitForNewWindow(WebDriver driver, Set<String> oldWindows) {
        int attempts = 0;
        while (driver.getWindowHandles().size() == oldWindows.size() && attempts < 5) {
            try {
                Thread.sleep(1000);
                attempts++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
