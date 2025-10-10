package com.retoLuloFront.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ChatBoxUI {
    public static final Target FIRST_IFRAME = Target.the("iframe que contiene el iframe del chatbox")
            .locatedBy("//iframe[@style='width: 100%; height: 100%;']");
    public static final Target SECOND_IFRAME = Target.the("iframe que contiene el chatbox")
            .locatedBy("(//iframe[contains(@title, 'chat widget')])[1]");
    public static final Target THIRD_IFRAME = Target.the("iframe que contiene el chatbox")
            .locatedBy("//iframe[@width='100%']");

    public static final Target CHATBOX_BUTTON = Target.the("Botón del chatbox")
            .locatedBy("//button[@type='button']");


    public static final Target INTERACTS_BUTTON = Target.the("botón que interactua con el chatbox")
            .locatedBy("//button[contains(text(), 'Tengo problemas con mi compra')]");

    public static final Target CHATBOX_MESSAGE = Target.the("mensaje de respuesta del chatbox")
            .locatedBy("//*[contains(text(), 'Lamento que estés teniendo problemas con tu compra.')]");
}
