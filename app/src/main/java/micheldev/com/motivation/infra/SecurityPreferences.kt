package micheldev.com.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

        private val msharedPreferences =
            context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key : String, value : String){
            msharedPreferences.edit().putString(key,value).apply()
        }


}