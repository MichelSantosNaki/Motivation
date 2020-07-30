package micheldev.com.motivation.infra

import android.content.Context
import android.content.SharedPreferences
//Shared prefence, usado para salvar coisas peqenas, aqui usado para  salvar o nome que a pessoa utiliza
//e depois usar em outras actives
class SecurityPreferences(context: Context) { //sharedPreferenc  precisa de um context

    private val msharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE) // crio um SharedPrefence para poder salvar algo, aqui usado para uma STR que será o nome da pessoa

    fun storeString(key: String, value: String) {
        msharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String{
        return  msharedPreferences.getString(key,"") ?: "" // ?: siginifica que se for nulo, retorna um str vazia!
    }


}