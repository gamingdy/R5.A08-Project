
package org.example.montaine.guillaume

import org.example.montaine.guillaume.megamangashop.MangaLot
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

fun main() {

    val Commande = TicketDeCaisse()
    println("\u001B[1mBienvenue dans le calcul de votre commande\u001B[0m\n")
    println("Veuillez rentrer le nombre de lots différents que vous avez dans votre commande :")
    val nbLot = readln().toInt()
    for (i in 1..nbLot) {
        println("Entrez la quantité de manga du lot $i :")
        val quantite = readln().toInt()
        println("Entrez le prix unitaire du manga :")
        val prix = readln().toDouble()
        val lot = Commande.ajouterLot(quantite, prix)
        val total = lot.calculateLot()
        println("Le sous-total du lot $i est de \u001B[1m$total \u001B[0m:")
    }
    val totalHT = Commande.calculateLot()
    println("Le total de votre commande est de\u001B[1m $totalHT\u001B[0m")
}