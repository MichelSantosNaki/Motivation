package micheldev.com.motivation.infra

class MotivationConstants  private constructor() { // centralizas as chaves para não se perder ao longo do dev do app

    object KEY{
        val  PERSON_NAME = "name" // se precisar trocar a key , só troca aqui e não precisa sair catando ao longo do app
    }

    object PHARSEFILTER{
        val ALL = 1
        val HAPPY = 1
        val MORNIG = 1
    }
}