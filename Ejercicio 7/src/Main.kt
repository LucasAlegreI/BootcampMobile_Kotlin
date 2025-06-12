import kotlin.random.Random
fun main() {
    repeat(10) {
        val newHand = Hand()
        println(newHand.dadosToString())
        println(newHand.handTypeToString())
    }
}
enum class HandType{
    GENERALA,POKER,FULLHOUSE,ESCALERA,NONE;
    companion object{
        val straights = listOf(listOf(1,2,3,4,5), listOf(2,3,4,5,6),listOf(1,3,4,5,6))
    }
}
class Hand(){
    val dados: List<Int>
    val handType: HandType
    init {
        dados = (1..5).map{ Random.nextInt(1, 7) }
        val repeated = dados.groupingBy { it }.eachCount().map {it.value}.sortedDescending()
        handType = when {
            HandType.straights.contains(dados.sorted()) -> HandType.ESCALERA
            repeated == listOf(5) -> HandType.GENERALA
            repeated == listOf(4,1) -> HandType.POKER
            repeated == listOf(3,2) -> HandType.FULLHOUSE
            else -> HandType.NONE
        }
    }
    fun dadosToString(): String = dados.toString()
    fun handTypeToString(): String = handType.toString()
}
