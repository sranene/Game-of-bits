package pt.ulusofona.lp2.deisiGreatGame

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

var abyssesAndTools = arrayOf(
    arrayOf("1", "0", "2"),
    arrayOf("1", "1", "3"),
    arrayOf("1", "2", "4"),
    arrayOf("1", "3", "5"),
    arrayOf("1", "4", "6"),
    arrayOf("1", "5", "7"),
    arrayOf("0", "0", "8"),
    arrayOf("0", "1", "9"),
    arrayOf("0", "2", "10"),
    arrayOf("0", "3", "11"),
    arrayOf("0", "4", "12"),
    arrayOf("0", "5", "13"),
    arrayOf("0", "6", "14"),
    arrayOf("0", "7", "15"),
    arrayOf("0", "8", "16"),
    arrayOf("0", "9", "17"),
    arrayOf("0", "2", "18")
)

var playerInfo = arrayOf(
    arrayOf("28", "sra nene", "PHP; Java", "Purple"),
    arrayOf("31", "rob roche", "Java; C++; Python; Portugues", "Blue"),
    arrayOf("16", "Alb erto", "Beck", "Brown")
)

var languages1 = arrayOf("PHP", "Java")
var languages2 = arrayOf("Java", "C++", "Python", "Portugues")
var languages3 = arrayOf("Beck")

var tree1 = TreeSet(Arrays.asList(*languages1))
var tree2 = TreeSet(Arrays.asList(*languages2))
var tree3 = TreeSet(Arrays.asList(*languages3))

var sranene = Programmer("sra nene", 28, tree1, ProgrammerColor.PURPLE)
var robroche = Programmer("rob roche", 31, tree2, ProgrammerColor.BLUE)
var alberto = Programmer("Alb erto", 16, tree3, ProgrammerColor.BROWN)

internal class TestFunctions {
    private val manager: GameManager = GameManager()
    @Test
    fun test01GetPlayer() {

        manager.createInitialBoard(playerInfo, 30, abyssesAndTools)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)

        var result = commandGetFn?.invoke(manager, listOf("PLAYER", "sra"))
        assertEquals("28 | sra nene | 1 | No tools | Java; PHP | Em Jogo", result)

        result = commandGetFn?.invoke(manager, listOf("PLAYER", "Andre"))
        assertEquals("Inexistent player", result)
    }

    @Test
    fun test01GetPlayersByLanguage() {

        manager.createInitialBoard(playerInfo, 30, abyssesAndTools)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)

        var result = commandGetFn?.invoke(manager, listOf("PLAYERS_BY_LANGUAGE", "Java"))
        assertEquals("sra nene,rob roche", result)

        result = commandGetFn?.invoke(manager, listOf("PLAYERS_BY_LANGUAGE", "Beck"))
        assertEquals("Alb erto", result)

    }

    @Test
    fun test01GetPolyglots() {

        manager.createInitialBoard(playerInfo, 30, abyssesAndTools)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)

        val result = commandGetFn?.invoke(manager, listOf("POLYGLOTS", ""))
        assertEquals("sra nene:2\n" +
                "rob roche:4", result)

    }

    @Test
    fun test01GetMostUsedPositions() {

        manager.createInitialBoard(playerInfo, 30, abyssesAndTools)

        manager.reactToAbyssOrTool()

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)

        val result = commandGetFn?.invoke(manager, listOf("POLYGLOTS", ""))
        assertEquals("sra nene:2\n" +
                "rob roche:4", result)

    }

}


