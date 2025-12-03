package com.fabricaescuela.automatizacion.questions;

import com.fabricaescuela.automatizacion.ui.GestionTurnosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElMensajeMostrado implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return GestionTurnosPage.MENSAJE_ALERTA.resolveFor(actor).getText();
    }

    public static ElMensajeMostrado es() {
        return new ElMensajeMostrado();
    }
}
