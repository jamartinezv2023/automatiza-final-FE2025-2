package com.fabricaescuela.automatizacion.stepdefinitions;

import com.fabricaescuela.automatizacion.interactions.EsperarUnMomento;
import com.fabricaescuela.automatizacion.questions.ElMensajeMostrado;
import com.fabricaescuela.automatizacion.tasks.AbrirLaAplicacion;
import com.fabricaescuela.automatizacion.tasks.CrearTurno;
import com.fabricaescuela.automatizacion.tasks.IniciarSesionComoAdmin;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class GestionTurnosStepDefinitions {

    private Actor jose;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        jose = OnStage.theActorCalled("Jose");
        jose.can(BrowseTheWeb.with(driver));
    }

    @Dado("que Jose abre la aplicación de FleetGuard360")
    public void queJoseAbreLaAplicacion() {
        jose.attemptsTo(
                AbrirLaAplicacion.enLogin(),
                EsperarUnMomento.de(1000)
        );
    }

    @Dado("inicia sesión como administrador válido")
    public void iniciaSesionComoAdministradorValido() {
        jose.attemptsTo(
                IniciarSesionComoAdmin.conCredenciales("admin@demo.com", "Admin123"),
                EsperarUnMomento.de(1000)
        );
    }

    @Cuando("crea un turno para la ruta {string} el lunes de {string} a {string}")
    public void creaUnTurnoRutaLunes(String ruta, String horaInicio, String horaFin) {
        jose.attemptsTo(
            CrearTurno.para(ruta, "Lunes", horaInicio, horaFin),
            EsperarUnMomento.de(1500)
        );
    }

    @Entonces("el sistema muestra un mensaje de éxito {string}")
    public void elSistemaMuestraMensajeExito(String mensajeEsperado) {
        jose.attemptsTo(
                Ensure.that(ElMensajeMostrado.es()).isEqualTo(mensajeEsperado)
        );
    }

    @Entonces("el sistema muestra un mensaje de error {string}")
    public void elSistemaMuestraMensajeError(String mensajeEsperado) {
        jose.attemptsTo(
                Ensure.that(ElMensajeMostrado.es()).isEqualTo(mensajeEsperado)
        );
    }
}
