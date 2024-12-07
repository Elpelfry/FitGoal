package edu.ucne.fitgoal.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {

    @Serializable
    data object PerfilScreen : Screen()

    @Serializable
    data object RelojScreen : Screen()

    @Serializable
    data object CalculadoraScreen : Screen()

    @Serializable
    data object HomeScreen : Screen()

    @Serializable
    data object LoginScreen : Screen()

    @Serializable
    data object RegisterScreen : Screen()

    @Serializable
    data object VerifyScreen : Screen()

    @Serializable
    data object OlvidarContrasenaScreen : Screen()

    @Serializable
    data object MainNavHostScreen : Screen()

    @Serializable
    data object AuthNavHostScreen : Screen()

    @Serializable
    data object CrearRutinaScreen : Screen()

    @Serializable
    data object CalendarioScreen : Screen()

    @Serializable
    data object AguaDiariaScreen : Screen()

    @Serializable
    data object EjerciciosScreen : Screen()

    @Serializable
    data object PlantillaScreen : Screen()

    @Serializable
    data object ProgresoListScreen: Screen()

    @Serializable
    data object Home: Screen()
    @Serializable
    data object EditarPerfilScreen: Screen()
}