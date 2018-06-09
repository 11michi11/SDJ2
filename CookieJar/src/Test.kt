import java.util.*

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val width = input.nextInt() // the number of cells on the X axis
    val height = input.nextInt() // the number of cells on the Y axis
    val array = Array(height) { Array(width) { '.' } }
    if (input.hasNextLine()) {
        input.nextLine()
    }
    for (i in 0 until height) {
        val line = input.nextLine().toCharArray() // width characters, each either 0 or .
        for (j in line.indices)
            array[i][j] = line[j]
    }

    for (i in 0 until height)
        for (j in 0 until width) {
            if (array[i][j] == '0') {
                var result = "$j $i"
                var flag = true

                var count = j + 1

                while (count < width) {
                    if (i >= height)
                        break
                    if (array[i][count] == '0') {
                        result += " $count $i"
                        flag = false
                        break
                    }
                    count++
                }
                if (flag)
                    result += " -1 -1"

                flag = true
                count = i + 1

                while (count < height) {
                    if (j >= width)
                        break
                    if (array[count][j] == '0') {
                        result += " $j $count"
                        flag = false
                        break
                    }
                    count++
                }
                if (flag)
                    result += " -1 -1"

                println(result)
            }
        }

    // Write an action using println()
    // To debug: System.err.println("Debug messages...");


    // Three coordinates: a node, its right neighbor, its bottom neighbor
    // println("0 0 1 0 0 1")
}