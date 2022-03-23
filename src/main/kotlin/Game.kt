import java.util.*

class Game (var dice : List<Die>){
    var throws=1


    fun start(){
        println("Game starts")
        println("--------------------------------------------")
        rollDices()
        showUnlockedDices()
        println("do you want to lock some of the dices?y or n")

        while(throws <=3) {
            lockDices()
            if (throws < 3) {
                println("-------------------------------------------- \n" + "Next throw" + "\n--------------------------------------------")
                rollDices()
                println("do you want to lock some of the dices? y or n")
                showUnlockedDices()
                throws++
            } else if (throws == 3) {
                println("you had 3 throws, no throws left")
                showDiceValues()
                throws++
            }
        }
    }
    private fun rollDices() =  dice.forEach(){it.rollDie()}
    private fun lockDices() {
        if (readLine()?.lowercase()== "y") {
            println("to choose a dice write its ID (example : 1,2,3 )")
            dice.forEach(){ it.unlockDie()}
            pickDice()
            println("Locked dices:")
            showLockedDices()
        }
    }
    private fun showUnlockedDices() = dice.forEach{ if(!it.isLocked){println(it.value)} }

    private fun showLockedDices() = dice.forEach { if(it.isLocked){println(it.value)} }

    private fun showDiceValues() = dice.forEach{ println( it.value)}

    private fun pickDice(){
        var input : String = readLine() ?: ""
        if (input.isNotEmpty()){
            val  lockedDice= input.split(",").map{ it.toInt() -1}
            lockedDice.forEach(){
                index -> if(index <6){
                    dice[index].lockDie()
                }
            }
        }
    }
    private fun getOne(values : List<Int>) : Int = values.filter { it == 1 }.count()
    private fun getTwo(values : List<Int>) : Int = values.filter { it == 2 }.count()
    private fun getThree(values : List<Int>) : Int = values.filter { it == 3 }.count()
    private fun getFour(values : List<Int>) : Int = values.filter { it == 4 }.count()
    private fun getFive(values : List<Int>) : Int = values.filter { it == 5 }.count()
    private fun getSix(values : List<Int>) : Int = values.filter { it == 6 }.count()

    fun checkForCombinations(){
        val dices = mutableListOf<Int>()
        dice.forEach{dices.add(it.value)}
        dices.sort()
        isJamb(dices)
        isPoker(dices)
        isThreeOfKind(dices)
        isStraight(dices)
    }

    private fun isJamb(dices : List<Int>){
        if(dices.first() == dices.last()){
            println("you got Yamb!!!")
        }
    }

    private  fun isPoker(dices : List<Int>){
        if(getOne(dices)== 4 || getTwo(dices) == 4 || getThree(dices) == 4 || getFour(dices) == 4 || getFive(dices) == 4 || getSix(dices) == 4) {
            println("You got Poker!!!")
        }
    }
    private  fun isThreeOfKind(dices : List<Int>){
        if(getOne(dices)== 3 || getTwo(dices) == 3 || getThree(dices) == 3 || getFour(dices) == 3 || getFive(dices) == 3 || getSix(dices) == 3) {
            println("You got Three of Kind!!!")
        }
    }
    private fun isStraight(dices : List<Int>){
        if(dices.containsAll(listOf(1,2,3,4,5))){
         println("You got Small Straight !!!")
        }
        else if(dices.containsAll(listOf(1,2,3,4,5,6))){
            println("You got High Straight")
        }
    }
}