
package org.example.montaine.guillaume.megamangashop

import de.huxhorn.sulky.ulid.ULID;


data class TicketDeCaisse(val Id: String = ULID().nextULID(), val pays:Pays ) {

    private var totalTtc: Double = 0.0
    private var totalHT: Double = 0.0
    private val taxe: Double = pays.tva
    private val remise: Double = 0.0
    private var lots : MutableList<MangaLot> = mutableListOf()

    fun calculateLot(): Double {
        totalHT = 0.0
        for (lot in lots) {
            totalHT += lot.calculateLot()
        }
        return totalHT
    }

    fun ajouterLot(quantite: Int, prix: Double): MangaLot {
        val lot = MangaLot(quantite, prix)
        lots.add(lot)
        return lot
    }

    fun calculerTotalTTC(): Double {
        totalTtc = totalHT * (1 + taxe)
        return totalTtc
    }

    fun afficherTicket(): String {
        return "Ticket de caisse n°$Id \n" +

                "Taxe : $taxe \n" +
                "Remise : $remise" +
                "Total TTC : $totalTtc"
    }
}