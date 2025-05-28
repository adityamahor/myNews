package com.example.my_news.presentation.common

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import com.example.my_news.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar (
    modifier: Modifier = Modifier,
    text: String,
    readOnly: Boolean,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    onClick: (()-> Unit)? = null
){

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val isClicked = interactionSource.collectIsPressedAsState().value

    val focusRequester = remember {
        FocusRequester()
    }

    // screen launch when focusRequester activate
    LaunchedEffect(Unit){
        focusRequester.requestFocus()
    }

    LaunchedEffect(isClicked) {
        if(isClicked){
            onClick?.invoke()
        }
    }


    Box (modifier = modifier){

        TextField(
            modifier = Modifier.fillMaxWidth().focusRequester(
                focusRequester
            ),
            value = text,
            onValueChange = onValueChange,
            readOnly = readOnly,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    tint = Color.Gray
                )
            },
            placeholder = {
                Text(text = "Search", style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedContainerColor = colorResource(R.color.whitelight),
                unfocusedContainerColor = colorResource(R.color.whitelight),
                disabledContainerColor = colorResource(R.color.whitelight)
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch()
                }
            ),
            textStyle = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.SemiBold,
                color = Color.Black),
            interactionSource = interactionSource
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun prevSearch() {

    SearchBar(text = "", onValueChange = {}, readOnly = false, onSearch = {})

}