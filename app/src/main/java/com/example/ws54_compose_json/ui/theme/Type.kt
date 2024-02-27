import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ws54_compose_json.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.avertastd)),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    ),

    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.avertastd)),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    ),

    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.avertastd)),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
    ),
)

val widgetLabelSmall = TextStyle(
    fontFamily = FontFamily(Font(R.font.avertastd)),
    color = Color.White,
    fontSize = 20.sp,
)

val labelSmall = TextStyle(
    fontFamily = FontFamily(Font(R.font.avertastd)),
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
)
val Averta = FontFamily(Font(R.font.avertastd))