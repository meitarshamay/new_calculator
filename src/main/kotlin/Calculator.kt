import kotlin.math.pow

object Calculator {

    fun calculate(input :String ,parameters:  List<Pair<String,String>>): String {
        val fixedInput = input.replaceParams(parameters)
        return Calculator.toCalculate(fixedInput)
    }


    fun toCalculate(input :String) :String = when{
        input.contains('+') -> input.split("+").map{ toCalculate(it)}.doOperation('+')
        input.contains('-') -> input.split("-").map{ toCalculate(it)}.doOperation('-')
        input.contains('*') -> input.split("*").map{ toCalculate(it)}.doOperation('*')
        input.contains('/') -> input.split("/").map{ toCalculate(it)}.doOperation('/')
        input.contains('^') -> input.split("^").map{ toCalculate(it)}.doOperation('^')


        else -> input

    }

    fun fh(){}


}

fun List<String>.doOperation (operation : Char) : String {
    val num = when (operation){
        '+' ->  this.map{it.toDouble()}.sum()
        '-' ->  this.map{it.toDouble()}.fold(2*this.first().toDouble()){acc, currentNum -> acc - currentNum}
        '*' ->  this.map{it.toDouble()}.fold(1.0){acc, currentNum -> acc*currentNum}
        '/' ->  this.map{it.toDouble()}.fold(this.first().toDouble().pow(2)){acc, currentNum -> acc/currentNum}
        '^' ->  this.map{it.toDouble()}.foldIndexed(this.first().toDouble()){index, acc,currenNum ->
            if(index==0)
                currenNum
            else
                acc.pow(currenNum)
        }
        else -> 0.0

    }
    return num.toString()

}

fun String.replaceParams(params: List<Pair<String,String>>) : String{
    var strWithoutOps  = this.split("+","-","/","*","^").joinToString ( separator=" ", prefix  = "", postfix = " ")

    for (element in params){
        strWithoutOps= strWithoutOps.replace((element.first+" ") ,(element.second+" "))
    }

    val operation = this.filter { ch -> ch in "+^*-/" }

    for(op in operation)
        strWithoutOps= strWithoutOps.replaceFirst(' ' ,op)

    return strWithoutOps.dropLast(1)

}
