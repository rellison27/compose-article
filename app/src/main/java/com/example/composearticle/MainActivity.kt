package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article(
                        headerText = stringResource(R.string.header_text),
                        intro = stringResource(R.string.intro_text),
                        tutorialText = stringResource(R.string.tutorial_text)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleText(header: String, intro: String, tutorialText: String, modifier: Modifier = Modifier)
{
    Text(
        text = header,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
    )
    Text(
        text = intro,
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        textAlign = TextAlign.Justify
    )
    Text(
        text = tutorialText,
        modifier = Modifier
            .padding(16.dp),
        textAlign = TextAlign.Justify

        )
}

@Composable
fun Article(headerText: String, intro: String, tutorialText: String, modifier: Modifier = Modifier) {

    Column {
        HeaderImage()
        ArticleText(
            header = headerText,
            intro = intro,
            tutorialText = tutorialText
        )
    }
}

@Composable
fun HeaderImage() {
    val image = painterResource(id = R.drawable.bg_compose_background)

    Image(
        painter = image,
        contentDescription = null
    )
}


@Preview(showBackground = true)
@Composable
fun ArticlePreview()
{
    ComposeArticleTheme {
        Article(
            headerText = stringResource(R.string.header_text),
            intro = stringResource(R.string.intro_text),
            tutorialText = stringResource(R.string.tutorial_text)
        )
    }
}