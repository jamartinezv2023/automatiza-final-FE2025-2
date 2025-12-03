package com.fabricaescuela.automatizacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EsperarUnMomento implements Interaction {

    private final long milisegundos;

    public EsperarUnMomento(long milisegundos) {
        this.milisegundos = milisegundos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static EsperarUnMomento de(long milisegundos) {
        return instrumented(EsperarUnMomento.class, milisegundos);
    }
}
