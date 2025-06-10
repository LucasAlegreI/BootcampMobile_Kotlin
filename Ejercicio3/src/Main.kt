//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlin.random.Random
fun main() {
    ejercicio4()
}
fun ejercicio1(){
    val randomList = (1..10).map { Random.nextInt(-5,6) }
    println (randomList.joinToString (" : "))
    println(randomList.sortedDescending())
}
fun ejercicio2(){
    val randomList:List<Int> =(1..100).map { Random.nextInt(-30,31) }
    println(randomList.joinToString(","))
    println( randomList.groupingBy { it }.eachCount().maxBy { it.value }.key)
    println((-30..30).filter{ it !in randomList }.joinToString ( " : " ))
}
fun ejercicio3(){
    val input = readln()
    println(if(input.trim().mapIndexed { index, s -> s==input[input.lastIndex - index] }.contains(false)) "No es palindromo" else "Es palindromo")
}
fun ejercicio4(){
    val input = readln()
    val array:Array<Int> = input.map {if (it.isDigit()) it.digitToInt() else { println("Solo se permiten numeros"); return; }}.toTypedArray()
    println(array.joinToString(","))
}