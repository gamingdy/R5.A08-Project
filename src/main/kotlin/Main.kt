
package org.example.montaine.guillaume
import org.example.montaine.guillaume.megamangashop.MangaLot
import org.example.montaine.guillaume.megamangashop.Pays
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

fun main() {

    val Commande = TicketDeCaisse(pays= Pays.France)
    println("\u001B[1mBienvenue dans le calcul de votre commande\u001B[0m\n")
    println("Veuillez choisir le pays de livraison :")
    println("1 - France")
    println("2 - Espagne")
    println("3 - Allemagne")
    println("4 - Royaume-Uni")
    println("5 - Belgique")
    val choix = readln().toInt()
    var paysBoutique = Pays.France
    if (choix == 1) {
        paysBoutique = Pays.France
    //} else if (choix == 2) {
    //    val pays = Pays.Espagne
    //} else if (choix == 3) {
    //    val pays = Pays.Allemagne
    //} else if (choix == 4) {
    //    val pays = Pays.RoyaumeUni
    //} else if (choix == 5) {
    //    val pays = Pays.Belgique
    }
    val Boutique = Boutique(pays = paysBoutique)

    val Commande = Boutique.creerTicket()
    println("Veuillez rentrer le nombre de lots différents que vous avez dans votre commande :")
    val nbLot = readln().toInt()
    for (i in 1..nbLot) {
        println("Entrez la quantité de manga du lot $i :")
        val quantite = readln().toInt()
        println("Entrez le prix unitaire du manga :")
        val prix = readln().toDouble()
        val lot = Commande.ajouterLot(quantite, prix)
        val total = lot.calculatePrixLot()
        println("Le sous-total du lot $i est de \u001B[1m$total\u001B[0m\n")
    }
    val totalHT = Commande.calculateTotalHT()
    println("Le total de votre commande est de \u001B[1m$totalHT\u001B[0m")
}