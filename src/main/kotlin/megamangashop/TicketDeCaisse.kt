
package org.example.montaine.guillaume.megamangashop

import de.huxhorn.sulky.ulid.ULID;


data class TicketDeCaisse(val Id: String = ULID().nextULID() ) {

    private var totalTtc: Double = 0.0
    private var totalHT: Double = 0.0
    private val taxe: Double = 0.0
    private val remise: Double = 0.0
    private var lots : MutableList<MangaLot> = mutableListOf()

    fun calculateLot(): Double {
        totalHT = 0.0
        for (lot in lots) {
            totalHT += lot.calculateLot()
        }
        return totalHT
    }

    fun ajouterLot(quantite: Int, prix: Double) {
        val lot = MangaLot(quantite, prix)
        lots.add(lot)
    }

    fun afficherTicket(): String {
        return "Ticket de caisse n°$Id \n" +

                "Taxe : $taxe \n" +
                "Remise : $remise" +
                "Total TTC : $totalTtc"
    }
}