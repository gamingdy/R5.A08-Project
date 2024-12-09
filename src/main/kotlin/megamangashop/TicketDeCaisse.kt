
package org.example.montaine.guillaume.megamangashop

import de.huxhorn.sulky.ulid.ULID;


data class TicketDeCaisse(val Id: String = ULID().nextULID() ) {

    private var totalTtc: Double = 0.0
    private var totalHT: Double = 0.0
    private val taxe: Double = 0.0
    private val remise: Double = 0.0
    private var lots : MutableList<MangaLot> = mutableListOf()

    fun calculateTotalHT(): Double {
        totalHT = 0.0
        for (lot in lots) {
            totalHT += lot.calculatePrixLot()
        }
        return totalHT
    }

    fun ajouterLot(quantite: Int, prix: Double): MangaLot {
        val lot = MangaLot(quantite, prix)
        lot.calculatePrixLot()
        lots.add(lot)
        return lot
    }

    fun afficherTicket(): String {
        return "Ticket de caisse n°$Id \n" +

                "Taxe : $taxe \n" +
                "Remise : $remise" +
                "Total TTC : $totalTtc"
    }
}