package edu.ucne.fitgoal.presentation.auth

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.captionBarPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import edu.ucne.fitgoal.R
import edu.ucne.fitgoal.presentation.components.BackGroundImage
import edu.ucne.fitgoal.presentation.components.LoadingIndicator
import edu.ucne.fitgoal.presentation.components.ModalError
import edu.ucne.fitgoal.presentation.components.ShowComponent
import edu.ucne.fitgoal.presentation.components.TextFielComponent
import edu.ucne.fitgoal.ui.theme.DarkGreen
import edu.ucne.fitgoal.ui.theme.ExDarkGreen

@Composable
fun DatosUsuarioScreen(
    authViewModel: AuthViewModel = hiltViewModel(),
    onCerrarSesion: () -> Unit,
    onGoHome: () -> Unit
) {
    val uiState by authViewModel.uiState.collectAsStateWithLifecycle()
    val onEvent = authViewModel::onEvent
    val activity = LocalContext.current as? Activity
    LaunchedEffect(uiState.isDatosLLenos) {
        if (uiState.isDatosLLenos) {
            onGoHome()
        }
    }

    ShowComponent(
        uiState.esNuevo,
        whenContentIsTrue = {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                BackGroundImage(id = R.drawable.registrarse_background)
                LazyColumn(
                    modifier = Modifier.captionBarPadding().systemBarsPadding()
                        .fillMaxWidth()
                        .padding(top = 90.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item{
                        Image(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "Nombre",
                                modifier = Modifier.align(Alignment.Start)
                                    .padding(horizontal = 20.dp),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                            TextFielComponent(
                                "Delfry",uiState.nombre,
                                KeyboardType.Text,
                                ImeAction.Next,
                                uiState.nombreError != "",
                                uiState.nombreError
                            ){
                                onEvent(AuthEvent.NombreChanged(it))
                            }
                            Text(
                                text = "Apellidos",
                                modifier = Modifier.align(Alignment.Start)
                                    .padding(horizontal = 20.dp),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                            TextFielComponent(
                                "Paulino Ortega",
                                uiState.apellido,
                                KeyboardType.Text,
                                ImeAction.Next,
                                uiState.apellidoError != "",
                                uiState.apellidoError
                            ){
                                onEvent(AuthEvent.ApellidoChanged(it))
                            }
                            Text(
                                text = "Edad",
                                modifier = Modifier.align(Alignment.Start)
                                    .padding(horizontal = 20.dp),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                            TextFielComponent("25",
                                uiState.edad.toString(),
                                KeyboardType.Number,
                                ImeAction.Next,
                                uiState.edadError != "",
                                uiState.edadError
                            ){
                                onEvent(AuthEvent.EdadChanged(it))
                            }
                            Text(
                                text = "Altura",
                                modifier = Modifier.align(Alignment.Start)
                                    .padding(horizontal = 20.dp),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                            TextFielComponent("5.4",
                                uiState.altura.toString(),
                                KeyboardType.Number,
                                ImeAction.Next,
                                uiState.alturaError != "",
                                uiState.alturaError
                            ){
                                onEvent(AuthEvent.AlturaChanged(it))
                            }
                            Text(
                                text = "Peso Inicial",
                                modifier = Modifier.align(Alignment.Start)
                                    .padding(horizontal = 20.dp),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                            TextFielComponent("100",
                                uiState.pesoInicial.toString(),
                                KeyboardType.Number,
                                ImeAction.Next,
                                uiState.pesoInicialError != "",
                                uiState.pesoInicialError
                            ){
                                onEvent(AuthEvent.PesoInicialChanged(it))
                            }
                            Text(
                                text = "Peso Ideal",
                                modifier = Modifier.align(Alignment.Start)
                                    .padding(horizontal = 20.dp),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                            TextFielComponent("150",
                                uiState.pesoIdeal.toString(),
                                KeyboardType.Number,
                                ImeAction.Done,
                                uiState.pesoIdealError != "",
                                uiState.pesoIdealError
                            ){
                                onEvent(AuthEvent.PesoIdealChanged(it))
                            }
                            Text(
                                text = "Peso Actual",
                                modifier = Modifier.align(Alignment.Start)
                                    .padding(horizontal = 20.dp),
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold
                            )
                            TextFielComponent("100",
                                uiState.pesoActual.toString(),
                                KeyboardType.Number,
                                ImeAction.Done,
                                false,
                                "",
                                readOnly = true
                            )

                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = { onEvent(AuthEvent.UpdateUsuario)},
                                colors = ButtonDefaults.buttonColors(DarkGreen),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 70.dp, vertical = 5.dp),
                                shape = RoundedCornerShape(16.dp),
                                contentPadding = PaddingValues(12.dp),
                                enabled = !uiState.isLoading
                            ) {
                                Text(
                                    text = "CONTINUAR",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 60.dp),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = { activity?.let { onEvent(AuthEvent.Logout(it, onCerrarSesion)) } },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.logout),
                            contentDescription = null,
                            tint = ExDarkGreen,
                            modifier = Modifier.size(50.dp)
                        )
                    }
                    Text(
                        text = "Cerrar Sesión",
                        color = ExDarkGreen,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(top = 3.dp)
                    )
                }
            }
            ShowComponent(
                value = uiState.isLoading,
                whenContentIsTrue = {
                    LoadingIndicator()
                }
            )
            ShowComponent(
                value = uiState.isModalErrorVisible,
                whenContentIsTrue = {
                    ModalError(
                        error = uiState.error,
                        onclick = {onEvent(AuthEvent.CloseErrorModal)}
                    )
                }
            )
        }
    )
}