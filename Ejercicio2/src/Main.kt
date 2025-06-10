//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    ejercicio10()
}
fun ejercicio1(){
    val num1 = 15
    val num2 = 15
    print("Suma: ${num1 + num2}, resta: ${num1 - num2}, Multiplicacion: ${num1 * num2}, Division: ${num1 / num2}, Modulo: ${num1 % num2}")
}
fun ejercicio2(){
    val num1 = 13
    val num2 = 13
    print(if (num1 > num2) "Numero 1 es mayor" else if (num1<num2) "Numero 2 es mayor" else "Son Iguales")
}
fun ejercicio3(){
    val name = "Lucas"
    print("Bienvenido $name")
}
fun ejercicio4(){
    print("Introduce tu nombre: ")
    val name = readln()
    print("Bienvenido $name")
}
fun ejercicio5(){
    print("Introduce un numero: ")
    val num = readln().toInt()
    print (if (num % 2 == 0) "El numero introducido es par" else "El numero introducido es impar")
}
fun ejercicio6(){
    print ("Introduzca el precio del producto: ")
    val num = readln().toDouble()
    println("El precio final es de: ${num+(num/10)}")
}
fun ejercicio7(){
    (1..100).forEach { if ( it % 2 == 0 || it % 3 == 0) print(" $it ")  }
}
fun ejercicio8(){
    var num = 0
    do{
        println("Introduce un numero: ")
        val input = readln()
        num = input.toIntOrNull() ?: -1
    }while(num<0)
    print ("El numero introducido es: $num")
}
fun ejercicio9() {
    val password = "password"
    repeat(3) {
        println("Introduzca la contraseña: ")
        val newPassword = readln()
        if (newPassword == password) {
            println("Correcto!")
            return
        }
        println("Fallaste jaja!!")
    }
}
fun ejercicio10(){
    val diasLaborales = listOf("lunes","martes","miercoles","jueves","viernes")
    val diasNoLaborales = listOf("sabado","domingo")
    val input = readln().lowercase()
    println(if (diasLaborales.contains(input)) "Es dia laboral" else if (diasNoLaborales.contains(input)) "No es dia laboral" else "Dato introducido incorrecto" )
}