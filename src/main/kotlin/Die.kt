class Die {
    var value = 0
    var isLocked = false
    var lockedDices= 0

    fun rollDie(){
        if(!this.isLocked){
            this.value = (1..6).random()
        }
    }
    fun lockDie(){
        if(!this.isLocked){
            isLocked=true
            lockedDices++
        }
    }
    fun unlockDie(){
        if(isLocked){
            isLocked=false
            lockedDices--
        }
    }
}