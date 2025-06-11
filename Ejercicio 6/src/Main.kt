//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    repeat (5) {
        println("Elige y escribe piedra, papel o tijera")
        var hand: HandType = HandType.PAPEL
        if (runCatching { hand = HandType.valueOf(readln().uppercase()) }.isSuccess){
            val gameController = GameController(hand, HandType.entries.random())
            println(gameController.toString())
            println(gameController.checkWinner())
        }
    }
}
enum class HandType(){
    PIEDRA, PAPEL, TIJERA;
    companion object{
        val map:Map<HandType,HandType> = mapOf(HandType.PIEDRA to HandType.TIJERA, HandType.TIJERA to HandType.PAPEL, HandType.PAPEL to HandType.PIEDRA)
    }

}
class GameController(val hand1:HandType,val hand2:HandType){
    override fun toString(): String = "${hand1.name} - ${hand2.name}"
    fun checkWinner():String{
        return if(hand1 == hand2) "Empate" else if (HandType.map[hand1]==hand2) "Gano jugador 1" else "Gano jugador 2"
    }
}