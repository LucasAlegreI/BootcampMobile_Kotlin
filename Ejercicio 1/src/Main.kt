//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlin.random.Random
var playing = true
fun main() {
    val torosYVacasGame = TorosYVacasGame()
    while (playing){
        print("Ingrese un numero de 4 digitos: ")
        val input = readln()
        if (input.length>4)
        {
            println ("Invalido, vuelve a intentarlo")
            continue
        }

        val (toros,vacas)= torosYVacasGame.compareNumbers(input)
        println("$toros Toros y  $vacas Vacas")
        if (toros == 4 ) {
            print ("!Felicidades! el numero secreto era: ${torosYVacasGame.secretAsString()}")
            return
        }
    }
}
class TorosYVacasGame () {
    val numbers = mutableListOf<Int>()

    init {
        for (i in 1..4) {
            var newNumber = 0
            do {
                newNumber = Random.nextInt(if (i == 1) 1 else 0, 10)
            }while (numbers.contains(newNumber))
            numbers.add(newNumber)
        }
    }
    fun secretAsString(): String = numbers.joinToString(" | ")

    fun compareNumbers(newNumbers: String): Pair<Int,Int>{
        var toros = 0
        var vacas = 0
        for ((i,c) in newNumbers.withIndex()) {
            if (c.isDigit()) {
                if (c.digitToInt() == numbers[i]) {
                    toros++
                } else if (numbers.contains(c.digitToInt())) {
                    vacas++
                }
            }
        }
        return toros to vacas
    }
}