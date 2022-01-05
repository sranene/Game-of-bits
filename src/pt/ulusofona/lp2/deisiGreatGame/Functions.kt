package pt.ulusofona.lp2.deisiGreatGame

enum class CommandType{
    GET,
    POST
}

fun router() : Function1<CommandType,Function2<GameManager,List<String>,String?>?>{
    return ::depoisDoRouter
}

fun depoisDoRouter(type: CommandType?) : Function2<GameManager,List<String>,String?>? {
    if(type == CommandType.GET){
        return ::comandoGet
    }else if (type == CommandType.POST){
        return :: comandoPost
    }
    return null
}

fun comandoGet(game: GameManager, args :List<String>) : String? {
    when(args[0]){
        "PLAYER" -> return::getPlayer.invoke(game,args)
        "PLAYERS_BY_LANGUAGE" -> return::getPlayersByLanguage.invoke(game,args)
        "POLYGLOTS" -> return::getPolyglots.invoke(game,args)
        "MOST_USED_POSITIONS" -> return::mostUsedPositions.invoke(game,args)
        "MOST_USED_ABYSSES" -> return::mostUsedAbysses.invoke(game,args)
    }
    return null
}
fun getPlayer(game: GameManager,args : List<String>) : String? {

    return if(game.getProgrammers(true).filter { it.firstName == args[1]}.size == 1){
        game.getProgrammers(true).filter { it.firstName == args[1]}[0].toString()
    }else{
        "Inexistent player"
    }

}

fun getPlayersByLanguage(game: GameManager,args: List<String>) : String?{
    var result = ""
    game.getProgrammers(true).forEach { programmer -> if(programmer.languages.filter { it == args[1] }.size == 1){
        result += "," + programmer.name
    }
    }
    result = result.replaceFirstChar { "" }
    return result
}

fun getPolyglots(game: GameManager,args : List<String>) : String?{
    val lista = arrayListOf<String>()
    var result = "";
    game.getProgrammers(true).forEach { programmer -> programmer.languages.filter {programmer.languages.size > 1}
        lista.add(programmer.name + ":" + programmer.languages.size + "\n")
    }
    lista.reversed().forEach {
        result += it
    }
    return result
}

fun mostUsedAbysses(game: GameManager,args : List<String>) : String?{
    return null
}

fun mostUsedPositions(game: GameManager,args : List<String>) : String?{
    return null
}

fun comandoPost(game: GameManager, args : List<String>) : String? {
    when(args[0]){
        "MOVE" -> return::postMove.invoke(game,args)
        "ABYSS" -> return::postAbyss.invoke(game,args)
    }
    return null
}


fun postMove(game: GameManager,args : List<String>) : String?{
    return null
}

fun postAbyss(game: GameManager,args : List<String>) : String?{
    return null
}
