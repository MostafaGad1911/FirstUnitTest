package mostafa.projects.firstunittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import mostafa.projects.firstunittest.LoginValidator.NotEmpty
import mostafa.projects.firstunittest.LoginValidator.StrongPassword
import mostafa.projects.firstunittest.LoginValidator.isValidEmail

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var emailEdt: EditText
    lateinit var passwordEdt: EditText
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        emailEdt = findViewById(R.id.emailEdt)
        passwordEdt = findViewById(R.id.passEdt)
        loginBtn = findViewById(R.id.loginBtn)

        loginBtn.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.loginBtn -> {
                var mail = emailEdt.text.toString().trim()
                var pass = passwordEdt.text.toString().trim()

                if (!mail.NotEmpty()) {
                    Toast.makeText(this, "Enter your email", Toast.LENGTH_SHORT).show()
                } else if (!pass.NotEmpty()) {
                    Toast.makeText(this, "Enter your password", Toast.LENGTH_SHORT).show()
                } else if (!mail.isValidEmail()) {
                    Toast.makeText(this, "Your email is invalid", Toast.LENGTH_SHORT).show()
                } else if (!pass.StrongPassword()) {
                    Toast.makeText(
                        this,
                        "Password must contain at least 8 characters , including Upper/Lower characters and numbers",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "Validation passed successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    // todo call login api
                }

            }
        }
    }
}