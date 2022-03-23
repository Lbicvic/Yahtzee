import kotlin.random.Random

fun main(args: Array<String>) {
    var die = List(6){Die()}
    var game = Game(die)
    game.start()
    game.checkForCombinations()
}
