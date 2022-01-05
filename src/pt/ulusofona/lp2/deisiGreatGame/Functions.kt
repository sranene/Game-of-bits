package pt.ulusofona.lp2.deisiGreatGame

enum class CommandType{
    GET,
    POST
}

fun router() : Function1<CommandType,Function2<GameManager,List<String>,String?>?>{
    return ::command
}

fun command(type: CommandType?) : Function2<GameManager,List<String>,String?>? {
    if(type == CommandType.GET){
        return ::commandGet
    }else if (type == CommandType.POST){
        return :: commandPost
    }
    return null
}

fun commandGet(game: GameManager, args :List<String>) : String? {
    when(args[0]){
        "PLAYER" -> return::getPlayer.invoke(game,args)
        "PLAYERS_BY_LANGUAGE" -> return::getPlayersByLanguage.invoke(game,args)
        "POLYGLOTS" -> return::getPolyglots.invoke(game,args)
        "MOST_USED_POSITIONS" -> return::mostUsedPositions.invoke(game,args)
        "MOST_USED_ABYSSES" -> return::mostUsedAbysses.invoke(game,args)
    }
    return null
}

fun commandPost(game: GameManager, args : List<String>) : String? {
    when(args[0]){
        "MOVE" -> return::postMove.invoke(game,args)
        "ABYSS" -> return::postAbyss.invoke(game,args)
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
    game.getProgrammers(true).filter{ it.languages.contains(args[1])}
                                         .forEach{ result += "," + it.name }

    result = result.replaceFirstChar { "" }
    return result
}

fun getPolyglots(game: GameManager,args : List<String>) : String?{
    val lista = arrayListOf<Programmer>()
    var result = "";

    game.getProgrammers(true).filter{it.languages.size > 1}
                                         .forEach{lista.add(it)}

    lista.sortedWith{s1,s2 -> s1.languages.size - s2.languages.size}
         .forEach { result += "\n" + it.name + ":" + it.languages.size }

    result = result.replaceFirstChar { "" }
    return result
}

fun mostUsedAbysses(game: GameManager,args : List<String>) : String?{
    return null
}

fun mostUsedPositions(game: GameManager,args : List<String>) : String?{
    return null
}

fun postMove(game: GameManager,args : List<String>) : String?{
    return null
}

fun postAbyss(game: GameManager,args : List<String>) : String?{
    return null
}
