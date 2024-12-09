package org.example.montaine.guillaume.megamangashop

enum class Pays(val tva: Double) {
    France(0.2),
    Espagne(0.182),
    Belgique(0.17),
}

data class Boutique(val pays: Pays) {
    fun creerTicket(): TicketDeCaisse {
        return TicketDeCaisse(pays=pays)
    }


}

