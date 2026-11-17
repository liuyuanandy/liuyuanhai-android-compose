package com.liuyuanhai.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liuyuanhai.compose.ui.theme.LiuyuanhaiandroidcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()//让 Activity 内容可以绘制到状态栏和导航栏区域的后面
        setContent {//设置布局
            LiuyuanhaiandroidcomposeTheme {//使用主题
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->//scaffold 显示内容区域

                    GreetingText(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)//设置Greeting的内容避开状态栏和导航栏遮挡区域（设置后不会被遮挡）
                    )
                }
            }
        }
    }
}

@Composable //可组合函数
fun GreetingText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable //可组合函数
fun GreetingImage() {
    Image(
        painter = painterResource(R.drawable.image_test),
        contentDescription = "Contact profile picture",
        modifier = Modifier
            // Set image size to 40 dp
            .size(40.dp)
            // Clip image to be shaped as a circle
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)//使用Material Design Color
    )
}
@Composable //可组合函数
fun GreetingColumn(name: String) {
    Column {//垂直排列元素
        Text(
            text = "Hello $name!",
        )
        Text(
            text = "Hello $name!",
        )
    }

}
@Composable //可组合函数
fun GreetingRow(name: String) {
    Row{//水平排列元素
        Text(
            text = "Hello $name!",
        )
        Text(
            text = "Hello $name!",
        )
    }
}
@Composable //可组合函数
fun GreetingRow2(name: String) {
    Row(modifier = Modifier.padding(all = 8.dp)){//水平排列元素
        Image(
            painter = painterResource(R.drawable.image_test),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column() {
            Text(
                text = "Hello $name!",
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Hello $name!",
                fontSize = 13.sp
            )
        }
    }
}
@Composable //可组合函数
fun GreetingMaterialDesign(name: String) {
    Column() {
        Row(modifier = Modifier.padding(all = 8.dp)){//水平排列元素
            Image(
                painter = painterResource(R.drawable.image_test),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)//使用Material Design Color
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column() {
                Text(
                    text = "Hello $name!",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.primary//使用Material Design Color
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Hello $name!",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.secondary//使用Material Design Color
                )
            }
        }
        Row(modifier = Modifier.padding(all = 8.dp)){//水平排列元素
            Image(
                painter = painterResource(R.drawable.image_test),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)//使用Material Design Color
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Hello $name!",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall//使用 Material Design Typography 样式
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Hello $name!",
                    style = MaterialTheme.typography.bodyMedium//使用 Material Design Typography 样式
                )
            }
        }
        // shape
        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 3.dp) {//使用 Material Design shape
            Text(
                text = "Hello $name!",
                modifier = Modifier.padding(all = 4.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }




}
@Composable //可组合函数
fun GreetingHorizontalList(messages: List<String>) {
    LazyRow{
        items(messages.size) { message ->
            GreetingImage()
        }
    }
}
@Composable //可组合函数
fun GreetingVerticalList(messages: List<String>) {

    LazyColumn {
        items(messages.size) { message ->
            GreetingRow2(messages.get(message))
        }
    }
}
@Preview(name = "Light Mode")//预览界面
@Preview(//启用深色主题
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable//可组合函数
fun GreetingPreview() {
    LiuyuanhaiandroidcomposeTheme {
//        GreetingText("Android")
//        GreetingColumn("Android")
//        GreetingRow("Android")
//        GreetingImage("Android")
//        GreetingRow2("Android")
//        GreetingMaterialDesign("Android")

        val titles:ArrayList<String>  = ArrayList<String>()
        for(i in 0..20){
            titles.add("title $i")
        }
//        GreetingVerticalList(titles)
        GreetingHorizontalList(titles)
    }
}