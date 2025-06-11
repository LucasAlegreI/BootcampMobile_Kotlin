//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    print(if (nextBig(11111)==null) "Es nulo" else nextBig(11111))
}
fun nextBig(num:Int):Int? = num.toString().toList().sortedDescending().joinToString("").toInt().let{if (it == num)null else it}
