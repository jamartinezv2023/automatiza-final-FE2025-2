package com.fabricaescuela.automatizacion.tasks;

import com.fabricaescuela.automatizacion.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesionComoAdmin implements Task {

    private final String usuario;
    private final String password;

    public IniciarSesionComoAdmin(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.INPUT_USUARIO),
                Enter.theValue(password).into(LoginPage.INPUT_PASSWORD),
                Click.on(LoginPage.BOTON_LOGIN)
        );
    }

    public static IniciarSesionComoAdmin conCredenciales(String usuario, String password) {
        return instrumented(IniciarSesionComoAdmin.class, usuario, password);
    }
}
