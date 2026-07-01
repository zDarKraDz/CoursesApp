package ru.konsli.feature_auth.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.konsli.core.ui.theme.buttonColor
import ru.konsli.core.ui.theme.buttonOkColor
import ru.konsli.core.ui.theme.buttonVkColor
import ru.konsli.core.ui.theme.dark
import ru.konsli.core.ui.theme.lightGray
import ru.konsli.core.ui.theme.linksColor
import ru.konsli.core.ui.theme.textColor

@Composable
fun AuthScreen(
    onLoginSuccess: () -> Unit,
    vm: AuthVIewModel = hiltViewModel()
){
    val state by vm.state.collectAsStateWithLifecycle()

    if(state.isAuthorized) onLoginSuccess()

    Scaffold(
        modifier = Modifier

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(color = dark)
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
            ,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Вход",
                color = textColor,
                fontSize = 28.sp
            )

            Column(
                modifier = Modifier
                    .padding(top = 32.dp)
            ) {
                Text(
                    text = "Email",
                    color = textColor,
                    fontSize = 16.sp
                )

                OutlinedTextField(
                    value = state.email,
                    onValueChange = vm::onEmailChange,
                    shape = RoundedCornerShape(32.dp),
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    label = {
                        Text(
                            text = "example@gmail.com"
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = lightGray,
                        unfocusedContainerColor = lightGray,

                        focusedBorderColor = lightGray,
                        unfocusedBorderColor = lightGray
                    )

                )

                if(state.isEmailError){
                    Text(
                        text = "Введите корректный email",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = "Пароль",
                    color = textColor,
                    fontSize = 16.sp
                )

                OutlinedTextField(
                    value = state.password,
                    onValueChange = vm::onPasswordChange,
                    shape = RoundedCornerShape(32.dp),
                    maxLines = 1,
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    label = {
                        Text(
                            text = "Введите пароль"
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = lightGray,
                        unfocusedContainerColor = lightGray,

                        focusedBorderColor = lightGray,
                        unfocusedBorderColor = lightGray
                    )
                )

                if(state.isPasswordError){
                    Text(
                        text = "Введите корректный пароль",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }


            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                ,
                onClick = {
                    vm.validateData()

                },
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
            ) {
                Text(
                    text = "Вход",
                    fontSize = 14.sp
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row() {
                    Text(
                        text = "Нет аккаунта?",
                        color = textColor
                    )

                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "Регистрация",
                        color = linksColor
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 14.dp),
                    text = "Забыл пароль",
                    color = linksColor
                )

            }

            HorizontalDivider(
                modifier = Modifier.padding(top = 32.dp),
                thickness = 2.dp,
                color = lightGray
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = buttonVkColor)
                ) {
                    Image(
                        painter = painterResource(ru.konsli.core.R.drawable.vk,),
                        contentDescription = null
                    )
                }

                Spacer(
                    modifier = Modifier.weight(0.1f)
                )
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = buttonOkColor)
                ) {
                    Image(
                        painter = painterResource(ru.konsli.core.R.drawable.ok,),
                        contentDescription = null
                    )
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview(){
    AuthScreen(
        onLoginSuccess = {}
    )
}