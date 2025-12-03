package com.fabricaescuela.automatizacion.tasks;

import com.fabricaescuela.automatizacion.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirLaAplicacion implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(LoginPage.URL_LOGIN)
        );
    }

    public static AbrirLaAplicacion enLogin() {
        return instrumented(AbrirLaAplicacion.class);
    }
}
