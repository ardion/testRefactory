package com.example.testrefactory

fun main(){
    var deret = arrayOf(4 ,9 ,7 ,5 ,8 ,9 ,3)
    sorting(deret)
}

fun sorting(deret: Array<Int>){
    var jml = 1
    do {
        for (i in 0..deret.size-2){
            if (deret[i]>deret[i+1]){
                var c = deret[i]
                deret[i] = deret[i+1]
                deret[i+1] = c
                println("$jml. [${deret[i]} , ${deret[i+1]}] -> ${deret.joinToString()}")
                jml=jml+1
            }
        }

    }while (deret.sorted().joinToString() != deret.joinToString())
    println("Jumlah swap : ${jml - 1}")

}