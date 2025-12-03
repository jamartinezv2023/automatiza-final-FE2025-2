Feature: Gestión de turnos
  Como usuario administrador de FleetGuard360
  Quiero gestionar los turnos
  Para organizar las rutas de transporte escolar

  Background:
    Dado que Jose abre la aplicación de FleetGuard360
    Y inicia sesión como administrador válido

  @ruta_feliz
  Scenario: Crear un turno válido
    Cuando crea un turno para la ruta "Ruta Centro" el lunes de 06:00 a 14:00
    Entonces el sistema muestra un mensaje de éxito "Turno creado correctamente"

  @excepcion
  Scenario: Intentar crear un turno con duración mayor a 8 horas
    Cuando crea un turno para la ruta "Ruta Centro" el lunes de 06:00 a 16:00
    Entonces el sistema muestra un mensaje de error "El turno no puede exceder las 8 horas"
