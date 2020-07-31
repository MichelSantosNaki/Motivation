package micheldev.com.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*
import micheldev.com.motivation.R
import micheldev.com.motivation.infra.MotivationConstants
import micheldev.com.motivation.infra.SecurityPreferences
import micheldev.com.motivation.repository.Moxk

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var msecurityPreference: SecurityPreferences // apenas instaniando, pois ainda não há context
    private var mPrhaseFilter : Int = MotivationConstants.PHARSEFILTER.ALL // inicial com o filtro ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // desativar a ActionBar
        if(supportActionBar!=null)supportActionBar!!.hide()


        msecurityPreference = SecurityPreferences(this)
        txt_Name.text =
            msecurityPreference.getString(MotivationConstants.KEY.PERSON_NAME) // atribui ao txt_name o que tem salvo no sharedPreference

        //Lógica de inicialização
        ic_all.setColorFilter(resources.getColor(R.color.colorAccent)) // Colore o iconte all
        handleNewPhrase() // chama uma frase ao inicializar

        btn_newPhrase.setOnClickListener(this) // ativa o click no botão
        ic_all.setOnClickListener(this)
        ic_happy.setOnClickListener(this)
        ic_morning.setOnClickListener(this)


    }

    override fun onClick(view: View) { // função on clique
        val id = view.id // pega o id
        val listFilter = listOf(R.id.ic_all, R.id.ic_happy, R.id.ic_morning) // lista com os filtros dos icones

        if (id == R.id.btn_newPhrase) { // filtro para chamar a função de nova frase
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id) // filtro para chamar a função dos filts
        }

    }

    private fun handleFilter(id: Int) {
        //coloca inicialmente todas as cores dos icones em branco
        ic_all.setColorFilter(resources.getColor(R.color.white))
        ic_happy.setColorFilter(resources.getColor(R.color.white))
        ic_morning.setColorFilter(resources.getColor(R.color.white))

        //faz um when para cada id e troca o when do icone selecionado
        when (id) {
            R.id.ic_all -> {
                ic_all.setColorFilter(resources.getColor(R.color.colorAccent))
                mPrhaseFilter = MotivationConstants.PHARSEFILTER.ALL // atualizando mprhasefilter
            }
            R.id.ic_happy -> {
                ic_happy.setColorFilter(resources.getColor(R.color.colorAccent))
                mPrhaseFilter = MotivationConstants.PHARSEFILTER.HAPPY


            }
            R.id.ic_morning -> {
                ic_morning.setColorFilter(resources.getColor(R.color.colorAccent))
                mPrhaseFilter = MotivationConstants.PHARSEFILTER.MORNIG

            }

        }
    }

    private fun handleNewPhrase() {
            txt_phrase.text = Moxk().getPhrase(mPrhaseFilter)
    }
}
