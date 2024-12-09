
package org.example.montaine.guillaume

import org.example.montaine.guillaume.megamangashop.MangaLot

fun main() {

    println("\u001B[1mBienvenue dans le calcul de votre commande\u001B[0m\n")
    println("Veuillez rentrer le nombre de lots différents que vous avez dans votre commande :")
    val nbLot = readln().toInt()
    for (i in 1..nbLot) {
        println("Entrez la quantité de manga du lot $i")
        val quantite = readln().toInt()
        println("Entrez le prix unitaire du manga")
        val prix = readln().toDouble()
        val lot = MangaLot(quantite,prix)
        val total = lot.calculateLot()
        println("Le total du lot $i est de $total")
    }
}