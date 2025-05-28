package com.example.myjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpack.ui.theme.BlueA
import com.example.myjetpack.ui.theme.BlueB
import com.example.myjetpack.ui.theme.Pink40
import com.example.myjetpack.ui.theme.Pinky
import com.example.myjetpack.ui.theme.Purple40
import com.example.myjetpack.ui.theme.Purple80

val cards = listOf(

    Card(
        cardType = "VISA",
        cardNumber = "5593 4756 4983 3247",
        cardName = "Business",
        balance = 48.467,
        color = getGradient(Purple80, Purple40),
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "234 5856 4983 3247",
        cardName = "Savings",
        balance = 8.467,
        color = getGradient(Pink40, Purple40),
    ),
    Card(
        cardType = "VISA",
        cardNumber = "2346 4756 4983 3247",
        cardName = "School",
        balance = 4.467,
        color = getGradient(Pink40, Pinky),
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "5593 4756 4983 3247",
        cardName = "Trips",
        balance = 8948.467,
        color = getGradient(BlueB, BlueA),
    ),
)


fun getGradient(
    startColor: Color,
    endColor:Color,
):Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

@Preview
@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size){index ->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(
    index:Int
){
    val card = cards [index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size -1){
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id= R.drawable.visa)
    if (card.cardType == "MASTER CARD"){
        image = painterResource(id= R.drawable.master)
    }

    Box(modifier= Modifier
        .padding(start = 16.dp, end=lastItemPaddingEnd)
    ){
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
                )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}