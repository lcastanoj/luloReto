package com.retoLuloFront.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.retoLuloFront.userInterfaces.ChatBoxUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class UserGoToTheChatboxTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FIRST_IFRAME, isPresent()).forNoMoreThan(30).seconds(),
                Switch.toFrame(FIRST_IFRAME.resolveFor(actor))
        );

        actor.attemptsTo(
                WaitUntil.the(SECOND_IFRAME, isPresent()).forNoMoreThan(30).seconds(),
                Switch.toFrame(SECOND_IFRAME.resolveFor(actor))
        );

        actor.attemptsTo(
                WaitUntil.the(CHATBOX_BUTTON, isPresent()).forNoMoreThan(30).seconds(),
                JavaScriptClick.on(CHATBOX_BUTTON)
        );
    }

    public static UserGoToTheChatboxTask button() {
        return instrumented(UserGoToTheChatboxTask.class);
    }
}

