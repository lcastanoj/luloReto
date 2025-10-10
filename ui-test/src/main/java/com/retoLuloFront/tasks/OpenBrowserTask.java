package com.retoLuloFront.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenBrowserTask implements Task {
    private final String url;

    public OpenBrowserTask(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static OpenBrowserTask url(String url) {
        return instrumented(OpenBrowserTask.class, url);
    }
}