package mostafa.projects.firstunittest

import mostafa.projects.firstunittest.LoginValidator.NotEmpty
import mostafa.projects.firstunittest.LoginValidator.PersianToEnglish
import mostafa.projects.firstunittest.LoginValidator.StrongPassword
import mostafa.projects.firstunittest.LoginValidator.isValidEmail
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginTestCases {

    @Test
    fun isFieldEmpty(){
        var value = "test"
        assert(value.NotEmpty())
    }

    @Test
    fun isEmailValid(){
        var mail = "gad@gmail.com"
        var valid = mail.PersianToEnglish().isValidEmail()
        assert(valid)
    }

    @Test
    fun isPasswordStrong(){
        var pass = "M!@212mmmm"
        assert(pass.StrongPassword())
    }

}