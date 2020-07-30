package micheldev.com.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*
import micheldev.com.motivation.R
import micheldev.com.motivation.infra.MotivationConstants
import micheldev.com.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {
    private lateinit var msecurityPreference: SecurityPreferences // apenas instaniando, pois ainda não há context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        msecurityPreference = SecurityPreferences(this)
       txt_Name.text = msecurityPreference.getString(MotivationConstants.KEY.PERSON_NAME) // atribui ao txt_name o que tem salvo no sharedPreference


    }
}