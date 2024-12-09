package org.example.montaine.guillaume.megamangashop

data class Boutique(val Pays: String) {
    fun creerTicket(quantite: Int, prix: Double): TicketDeCaisse {
        return TicketDeCaisse()

    }


}

