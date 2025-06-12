fun main() {
    repeat(10) {
        val pokerController = PokerController()
        println(pokerController.handsToString())
        println(pokerController.checkWinner())
    }
}
enum class Suit {
    CORAZON,DIAMANTE,PICA,TREBOL
}
data class Card(val value:Int,val suit:Suit) {
    private val stringValue: String = valueToString(value)
    override fun toString(): String = "$stringValue $suit"

    companion object {
        fun valueToString(newValue: Int): String =
            when (newValue) {
                11 -> "J"
                12 -> "Q"
                13 -> "K"
                14 -> "A"
                else -> newValue.toString()
            }
    }
}

class Deck(){
    private val cards : MutableList<Card> = mutableListOf()
    init{
        for (i in 2..14){
            Suit.entries.forEach { cards.add(Card(i,it))}
        }
        cards.shuffle()
    }
    fun takeCards(nTake : Int): List<Card> = cards.take(nTake).also{cards.removeAll(it)}
    override fun toString() : String = cards.joinToString(" | ")
}
enum class GameType(){
    CARTAALTA(), PAR(),DOBLEPAR(),TRIO(),ESCALERA(),COLOR(),FULLHOUSE(),POKER(),ESCALERACOLORIDA()
}
class Hand(val cards : List<Card>){
    val gameType : GameType
    val highCards : List<Int>
    init {
        val isColor = cards.map { it.suit }.toSet().size == 1
        val isEscalera: Boolean = cards.sortedBy { it.value }.zipWithNext { a, b -> a.value == b.value - 1 }
            .all { it } || (cards.map { it.value }.contains(14) && cards.map { it.value }.sorted().take(4) == listOf(2,3,4,5))
        val repeated: Map<Int, Int> = cards.groupingBy { it.value }.eachCount()
        val repeatedList = repeated.map {it.value}.sortedDescending()
        gameType = when {
            isColor && isEscalera -> GameType.ESCALERACOLORIDA
            repeatedList == listOf(4,1) -> GameType.POKER
            repeatedList == listOf(3,2) -> GameType.FULLHOUSE
            isColor -> GameType.COLOR
            isEscalera -> GameType.ESCALERA
            repeatedList == listOf(3,1,1)-> GameType.TRIO
            repeatedList == listOf(2,2,1) -> GameType.DOBLEPAR
            repeatedList == listOf(2,1,1,1) -> GameType.PAR
            else -> GameType.CARTAALTA
        }
        highCards  = repeated.toList().sortedWith(compareByDescending<Pair<Int,Int>>{ it.second }.thenByDescending { it.first }).flatMap {(num,count)-> List(count){num} }
    }
    override fun toString(): String = "$cards tenes $gameType"
}
class PokerController (){
    private val deck = Deck()
    private val hand1 = Hand(deck.takeCards(5))
    private val hand2 = Hand(deck.takeCards(5))

    fun handsToString() : String = "$hand1 | $hand2"

    fun checkWinner() : String{
        return if (hand1.gameType.ordinal == hand2.gameType.ordinal) hand1.highCards.zip(hand2.highCards).firstOrNull{it.first != it.second}?.let{(x,y)->if(x>y) "Ganador jugador 1, desempata ${Card.valueToString(x)} frente a ${Card.valueToString(y)}"
            else if(x<y) "Ganador jugador 2, desempata ${Card.valueToString(y)} frente a ${Card.valueToString(x)}" else ""}?: "Empate" else if(hand1.gameType.ordinal > hand2.gameType.ordinal) "Ganador jugador 1 con ${hand1.gameType.name}"
            else "Ganador jugador 2 con ${hand2.gameType.name}"
    }
}