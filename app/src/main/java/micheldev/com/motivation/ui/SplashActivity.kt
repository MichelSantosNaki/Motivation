package micheldev.com.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.*
import micheldev.com.motivation.R
import micheldev.com.motivation.infra.MotivationConstants
import micheldev.com.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var msecurityPreference: SecurityPreferences // apenas instaniando, pois ainda não há context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (supportActionBar != null) supportActionBar!!.hide()

        btn_salvar.setOnClickListener(this)
        msecurityPreference = SecurityPreferences(this)

        verifyName()

    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.btn_salvar) handSave()

    }

    private fun verifyName(){
        val name = msecurityPreference.getString(MotivationConstants.KEY.PERSON_NAME)
        if (name != ""){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
    }


    private fun handSave() {
        val name = edttext_name.text.toString()
        if (name != "") {
            msecurityPreference.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Digite seu nome", Toast.LENGTH_SHORT).show()
        }
    }
}