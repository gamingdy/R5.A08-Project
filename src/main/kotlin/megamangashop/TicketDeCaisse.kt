package org.example.montaine.guillaume.megamangashop

import de.huxhorn.sulky.ulid.ULID;


data class TicketDeCaisse(val Id: String = ULID().nextULID(), val pays: Pays) {

    private var totalTtc: Double = 0.0
    var totalHT: Double = 0.0
    private val taxe: Double = pays.tva
    val remise: Double = 0.0
    private var lots: MutableList<MangaLot> = mutableListOf()

    private fun calculateTotalHT(): Double {
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
        calculateTotalHT()
        return lot
    }

    fun calculerTotalTTC(): Double {
        totalTtc = calculateTotalHT() * (1 + taxe)
        return totalTtc
    }

    fun afficherTicket(): String {
        var stringResult = "Ticket de caisse n°$Id \n"
        for (lot in lots) {
            stringResult += lot.afficherLot() + "\n"
        }
        stringResult += "Total HT : $totalHT €\n"
        stringResult += "Remise : $remise €\n"
        stringResult += "TVA : $taxe\n"
        stringResult += "Total TTC : $totalTtc €\n"
        return stringResult
    }
}