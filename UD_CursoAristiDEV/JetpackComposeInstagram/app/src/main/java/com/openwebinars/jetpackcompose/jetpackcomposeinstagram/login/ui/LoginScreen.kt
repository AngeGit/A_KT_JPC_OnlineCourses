package com.openwebinars.jetpackcompose.jetpackcomposeinstagram.login.ui


import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.openwebinars.jetpackcompose.jetpackcomposeinstagram.R


@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        val isLoading:Boolean by loginViewModel.isLoading.observeAsState(initial=false)

        if(isLoading){
           LoadingProgressBar()
        }else{
            Header(Modifier.align(Alignment.TopEnd))
            Body(Modifier.align(Alignment.Center), loginViewModel)
            Footer(Modifier.align(Alignment.BottomCenter))
        }

    }

}
@Composable
fun Header(modifier: Modifier) {
        val activity: Activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close app",
        modifier = modifier.clickable { activity.finish() }
    )
}
@Composable
fun Body(modifier: Modifier,loginViewModel: LoginViewModel) {
   // var email by rememberSaveable { mutableStateOf("") }
    val email:String by loginViewModel.email.observeAsState(initial="") //escucha el valor _email (el mutableLiveData)
    //var passwd by rememberSaveable { mutableStateOf("") }
    val pass:String by  loginViewModel.pass.observeAsState(initial="")
   // var isLoginEnabled by rememberSaveable { mutableStateOf(false) }
    val isLoginEnabled: Boolean by loginViewModel.enabledLogin.observeAsState(initial=false)

    Column(
        modifier = modifier
    ) {
        ImageLogo(Modifier.align(CenterHorizontally))
        Spacer(Modifier.size(16.dp))
        EmailBox(email) {
            loginViewModel.onLoginChanged(it,pass)
        }
        Spacer(Modifier.size(4.dp))
        PassBox(pass) {
            loginViewModel.onLoginChanged(email,it)
        }
        Spacer(Modifier.size(8.dp))
        ForgotPassWord(Modifier.align(Alignment.End))
        Spacer(Modifier.size(16.dp))
        LoginButton(isLoginEnabled, loginViewModel)
        Spacer(Modifier.size(16.dp))
        LoginDivider()
        Spacer(Modifier.size(32.dp))
        SocialLogin()
    }
}
//region Body
@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "logo",
        modifier = modifier
    )
}
@Composable
fun EmailBox(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email", color = Color(0xffE5E5E5)) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0XFFB2B2B2),
            backgroundColor = Color(0XFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}
@Composable
fun PassBox(pass: String, onTextChanged: (String) -> Unit) {
    var passVisibility by remember{ mutableStateOf(false)}
    TextField(
        value = pass,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password", color = Color(0xffE5E5E5)) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0XFFB2B2B2),
            backgroundColor = Color(0XFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val imagen = if (passVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passVisibility=!passVisibility }) {
                Icon(imageVector = imagen, contentDescription = "show password")
            }
        }, visualTransformation = if(passVisibility){
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()
        }
    )
}
@Composable
fun ForgotPassWord(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xff4EA8E9),
        modifier = modifier
    )
}
@Composable
fun LoginButton(loginEnabled: Boolean, loginViewModel: LoginViewModel) {
    Button(
        onClick = {loginViewModel.onLoginSelected()},
        enabled = loginEnabled,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4EA8E9),
            disabledBackgroundColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    )
    {
        Text(text = "Log in")
    }
}
@Composable
fun LoginDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            Modifier
                .background(Color(0xffF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            Modifier.padding(horizontal = 18.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color(0xffE5E5E5)
        )
        Divider(
            Modifier
                .background(Color(0xffF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}
@Composable
fun SocialLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Social login facebook",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continua as Angie",
            Modifier.padding(horizontal = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color(0xff4EA8E9)
        )

    }
}
//endregion body
@Composable
fun Footer(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Divider(
            modifier = Modifier
                .background(Color(0xffF9F9F9))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(Modifier.size(24.dp))
        SignUp()
    }
}
//region Footer
@Composable
fun SignUp() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Don't have an account?",
            fontSize = 12.sp,
            color = Color(0xffE5E5E5)
        )
        Text(
            text = "Sign up.",
            Modifier.padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff4EA8E9)
        )
        Spacer(Modifier.size(24.dp))
    }
}
//endregion Footer

@Composable
fun LoadingProgressBar() {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(200.dp),
            color = Color(0xFF78C8F9),
            strokeWidth = 8.dp
        )
    }
}

