package com.fabricaescuela.automatizacion.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GestionTurnosPage {

    public static final Target SELECT_RUTA =
            Target.the("selector de ruta").located(By.id("rutaSelect")); // ajusta al ID real

    public static final Target SELECT_DIA =
            Target.the("selector de día").located(By.id("diaSelect"));

    public static final Target INPUT_HORA_INICIO =
            Target.the("hora de inicio").located(By.id("horaInicio"));

    public static final Target INPUT_HORA_FIN =
            Target.the("hora de fin").located(By.id("horaFin"));

    public static final Target BOTON_CREAR_TURNO =
            Target.the("botón crear turno").located(By.id("btnCrearTurno"));

    public static final Target MENSAJE_ALERTA =
            Target.the("mensaje de alerta").located(By.id("mensaje"));

    public static final Target LISTA_TURNOS =
            Target.the("lista de turnos").located(By.id("tablaTurnos"));
}
