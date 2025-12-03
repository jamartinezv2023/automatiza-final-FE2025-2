package com.fabricaescuela.automatizacion.tasks;

import com.fabricaescuela.automatizacion.ui.GestionTurnosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrearTurno implements Task {

    private final String ruta;
    private final String dia;
    private final String horaInicio;
    private final String horaFin;

    public CrearTurno(String ruta, String dia, String horaInicio, String horaFin) {
        this.ruta = ruta;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(ruta).from(GestionTurnosPage.SELECT_RUTA),
                SelectFromOptions.byVisibleText(dia).from(GestionTurnosPage.SELECT_DIA),
                Enter.theValue(horaInicio).into(GestionTurnosPage.INPUT_HORA_INICIO),
                Enter.theValue(horaFin).into(GestionTurnosPage.INPUT_HORA_FIN),
                Click.on(GestionTurnosPage.BOTON_CREAR_TURNO)
        );
    }

    public static CrearTurno para(String ruta, String dia, String horaInicio, String horaFin) {
        return instrumented(CrearTurno.class, ruta, dia, horaInicio, horaFin);
    }
}
