package mostafa.projects.firstunittest

import android.os.Build
import android.text.TextUtils
import android.util.Patterns
import androidx.annotation.RequiresApi
import java.util.regex.Pattern

object LoginValidator {
    val EMAIL_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun String.NotEmpty():Boolean{
        return !this.isEmpty()
    }


    fun String.StrongPassword():Boolean{
        val PASSWORD_REGEX = """(?=.*[A-Z]).{8,}""".toRegex()
        return this.matches(PASSWORD_REGEX)
    }



    fun String.isValidEmail(): Boolean {
        return this != null && EMAIL_PATTERN.matcher(this).matches()
    }


    fun String.PersianToEnglish(): String {
        var result = ""
        var en = '0'
        for (ch in this) {
            en = ch
            when (ch) {
                '۰' -> en = '0'
                '۱' -> en = '1'
                '۲' -> en = '2'
                '۳' -> en = '3'
                '۴' -> en = '4'
                '۵' -> en = '5'
                '۶' -> en = '6'
                '۷' -> en = '7'
                '۸' -> en = '8'
                '۹' -> en = '9'
            }
            result = "${result}$en"
        }
        return result
    }

}