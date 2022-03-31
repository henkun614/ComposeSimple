package com.henk.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.henk.compose.databinding.ListBinding
import com.henk.compose.ui.theme.ComposeSimpleTheme

class MainActivity : ComponentActivity(),ItemClick {
    private var beans= mutableListOf<Bean>(
        Bean("Text",MText().javaClass),
        Bean("Button",MButton().javaClass),
        Bean("Card",MCard().javaClass),
        Bean("Image",MCard().javaClass),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSimpleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(this,beans)
                }
            }
        }
    }

    override fun click(bean: Bean) {
        val intent = Intent(this,bean.router)
        startActivity(intent)
    }
}

@Composable
fun Greeting(itemClick: ItemClick,beans:MutableList<Bean>) {
    AndroidViewBinding(factory = (ListBinding::inflate)){
        list.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter=ItemAdapter(itemClick,beans)
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeSimpleTheme {
//        Greeting()
//    }
//}

