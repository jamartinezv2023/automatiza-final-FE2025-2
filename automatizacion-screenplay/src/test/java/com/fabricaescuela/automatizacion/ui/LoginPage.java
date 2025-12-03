package com.fabricaescuela.automatizacion.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final String URL_LOGIN = "http://localhost:3000/login"; // ajusta si es diferente

    public static final Target INPUT_USUARIO =
            Target.the("campo usuario").located(By.id("username")); // ajusta al ID real

    public static final Target INPUT_PASSWORD =
            Target.the("campo contraseña").located(By.id("password")); // ajusta al ID real

    public static final Target BOTON_LOGIN =
            Target.the("botón iniciar sesión").located(By.cssSelector("button[type='submit']"));
}
