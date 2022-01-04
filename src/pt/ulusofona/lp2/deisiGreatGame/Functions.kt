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

     return null
 }




 fun mostUsedAbysses(game: GameManager,args : List<String>) : String?{
    return null
 }

 fun mostUsedPositions(game: GameManager,args : List<String>) : String?{
    return null
 }

 fun getPolyglots(game: GameManager,args : List<String>) : String?{
    return null
 }

 fun getPlayersByLanguage(game: GameManager,args: List<String>) : String?{
    return null
 }

 fun comandoPost(game: GameManager, args : List<String>) : String? {
     when(args[0]){
         "MOVE" -> return::postMove.invoke(game,args)
         "ABYSS" -> return::postAbyss.invoke(game,args)
     }
     return null
 }

