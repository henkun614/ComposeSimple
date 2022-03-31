package com.henk.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.github.ahmadaghazadeh.editor.processor.language.Language
import com.henk.compose.databinding.CodeBinding

class MText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(modifier = Modifier.padding(10.dp)) {
                item {
                    Text(text = "这是一个最简单的text组件")
                    Text(text = "一号标题", style = MaterialTheme.typography.h1)
                    Text(text = "二号标题", style = MaterialTheme.typography.h2)
                    Text(text = "三号标题", style = MaterialTheme.typography.h3)
                    Text(text = "四号标题", style = MaterialTheme.typography.h4)
                    Text(text = "五号标题", style = MaterialTheme.typography.h5)
                    Text(text = "六号标题", style = MaterialTheme.typography.h6)

                    Spacer(modifier = Modifier.size(30.dp))//提供一段空白占位
                    Text(text = "大号正文", style = MaterialTheme.typography.body1)
                    Text(text = "小号正文", style = MaterialTheme.typography.body2)

                    Spacer(modifier = Modifier.size(30.dp))
                    Text(text = "红色加粗，间距7", style = TextStyle(color = Color.Red, fontWeight = FontWeight.Bold, letterSpacing = 7.sp))

                    Spacer(modifier = Modifier.size(20.dp))
                    Text(text = "maxLines属性，超出之后会断掉的奥，maxLines属性，超出之后会断掉的奥maxLines属性，超出之后会断掉的奥", maxLines = 1 )

                    Spacer(modifier = Modifier.size(20.dp))
                    Text(text = "左对齐", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Left)
                    Text(text = "居中", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                    Text(text = "右对齐", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Right)

                    Spacer(modifier = Modifier.size(20.dp))
                    Text(text = "lineHeight设置行高".repeat(5), modifier = Modifier.fillMaxWidth(), lineHeight = 30.sp)//repeat重复

                    Spacer(modifier = Modifier.size(20.dp))
                    Text(text = "点我", modifier = Modifier
                        .clickable(onClick = {
                            Toast
                                .makeText(this@MText, "哎呦", Toast.LENGTH_LONG)
                                .show()
                        })
                        .fillMaxWidth(), lineHeight = 30.sp)

                    Spacer(modifier = Modifier.size(20.dp))

                }

            }

        }
    }
}