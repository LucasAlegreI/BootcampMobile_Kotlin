import kotlin.math.abs
class Reloj (horas: Int=12,minutos: Int=0,segundos: Int=0) {
    var horas = horas
        set(value){
            field = value.coerceIn(0, 23)
        }
    var minutos = minutos
        set(value){
            field = value.coerceIn(0, 59)
        }
    var segundos = segundos
        set(value){
            field = value.coerceIn(0, 59)
        }
    init{
        this.horas = horas
        this.minutos = minutos
        this.segundos = segundos
    }
    constructor(secondsFromMidnight:Int):this(){
        val triple = setReloj(secondsFromMidnight)
        horas = triple.first
        minutos = triple.second
        segundos = triple.third
    }
    override fun toString(): String {
        return "$horas:$minutos:$segundos"
    }
    fun setReloj(newSegundos: Int): Triple<Int,Int,Int> {
        return Triple((newSegundos % 86400)/3600,(newSegundos % 86400)%3600/60,(newSegundos % 86400)%3600%60)
    }
    fun relojToSeconds(reloj:Reloj):Int=reloj.segundos+(reloj.minutos*60)+(reloj.horas*3600)

    fun tick(){
        val triple=setReloj(relojToSeconds(this)+1)
        horas=triple.first
        minutos=triple.second
        segundos=triple.third
    }
    fun addReloj(newReloj:Reloj){
        val triple = setReloj((relojToSeconds(newReloj)+relojToSeconds(this))%86400)
        horas=triple.first
        minutos = triple.second
        segundos = triple.third
    }
    fun tickDecremento(){
        val triple = setReloj(relojToSeconds(this)-1)
        horas=triple.first
        minutos = triple.second
        segundos = triple.third
    }
    fun restaReloj(newReloj:Reloj):Reloj{
        val triple = setReloj(abs(relojToSeconds(newReloj)-relojToSeconds(this)))
        return Reloj(triple.first,triple.second,triple.third)
    }
}