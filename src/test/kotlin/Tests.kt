import Calculator.calculate
import org.junit.Assert
import org.junit.Test
import kotlin.math.pow

class Tests {


    @Test
    fun checkAdd (){
        val string ="1+6"

        val a = Calculator.toCalculate(string)

        Assert.assertEquals((1+6).toDouble().toString(), a)
    }

    @Test
    fun checkSub (){
        val string ="1-6"

        val a = Calculator.toCalculate(string)

        Assert.assertEquals((1-6).toDouble().toString(), a)
    }

    @Test
    fun checkMul (){
        val string ="1*6"

        val a = Calculator.toCalculate(string)

        Assert.assertEquals((1*6).toDouble().toString(), a)
    }

    @Test
    fun checkDiv (){
        val string ="1/6"

        val a = Calculator.toCalculate(string)

        Assert.assertEquals((1.0/6.0).toString(), a)
    }


    @Test
    fun checkPow (){
        val string ="1^6"

        val a = Calculator.toCalculate(string)

        Assert.assertEquals((1.0.pow(6.0)).toString(), a)
    }

    @Test
    fun checkCalculator1 (){
        val string ="1+6/3+4*2+0.7+0.3+0.0002*4"

        val a = Calculator.toCalculate(string)

        Assert.assertEquals((1+6/3+4*2+0.7+0.3+0.0002*4).toString(), a)
    }


    @Test
    fun checkCalculator2 (){
        val string ="1^6^5"

        val a = Calculator.toCalculate(string)

        Assert.assertEquals(1.0.toString(), a)
    }


    @Test
    fun checkCalculator3 (){
        val string ="1^6-14.5+50+2^4"

        val a = Calculator.toCalculate(string)
        Assert.assertEquals((1.0.pow(6.0)- 14.5 + 50 + 2.0.pow(4.0)).toString(), a)

    }

    @Test
    fun checkCalWithParameters(){
        val paramsValues : List<Pair<String,String>> = listOf( Pair("tt","1.3"), Pair("X","5"), Pair("Y","7"), Pair("y","8"))
        val str = "tt+X-Y*y+y"
        val new= calculate(str, paramsValues)
        Assert.assertEquals((1.3+5-7*8+8).toString(), new)
    }

}