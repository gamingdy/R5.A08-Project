package org.example.montaine.guillaume.megamangashop

enum class Pays(val tva: Double) {
    France(0.2),
}

data class Boutique(val pays: Pays) {
    fun creerTicket(): TicketDeCaisse {
        return TicketDeCaisse()
    }


}

