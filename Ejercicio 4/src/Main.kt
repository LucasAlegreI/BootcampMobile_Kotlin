//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val newReloj = Reloj(100,0,0)
    println(newReloj.toString())
    newReloj.tickDecremento()
    newReloj.tickDecremento()
    println(newReloj.toString())
    newReloj.tickDecremento()
    println(newReloj.toString())
    println(newReloj.restaReloj(Reloj(11,10,10)))
    println(newReloj.toString())
    newReloj.addReloj(Reloj(5,10,10))
    println(newReloj.toString())
}
