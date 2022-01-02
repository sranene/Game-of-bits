 package pt.ulusofona.lp2.deisiGreatGame

enum class CommandType{
    GET,
    POST
}

fun router() : Function1<CommandType,Function2<GameManager,List<String>,Int>?>{
    return ::depoisDoRouter
}

 fun depoisDoRouter(type: CommandType?) : Function2<GameManager,List<String>,Int>? {
     if(type == CommandType.GET){
         return ::comandoGet
     }else if (type == CommandType.POST){
         return :: comandoPost
     }
     return null
 }

 fun comandoGet(game: GameManager, args :List<String>) : Int {
     return 1
 }

 fun comandoPost(game: GameManager, args : List<String>):Int {
    return 0
 }

