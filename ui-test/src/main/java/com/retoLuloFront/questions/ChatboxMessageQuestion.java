package com.retoLuloFront.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.awaitility.Awaitility;

import java.util.concurrent.TimeUnit;

import static com.retoLuloFront.userInterfaces.ChatBoxUI.CHATBOX_MESSAGE;

public class ChatboxMessageQuestion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        Awaitility.await().atMost(30, TimeUnit.SECONDS).until(() ->
                !Text.of(CHATBOX_MESSAGE).answeredBy(actor).isEmpty()
        );

        return Text.of(CHATBOX_MESSAGE).answeredBy(actor);
    }

    public static Question<String> text() {
        return new ChatboxMessageQuestion();
    }
}
