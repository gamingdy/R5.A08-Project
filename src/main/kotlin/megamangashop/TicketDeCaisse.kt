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

    fun calculRemise(): Double {
        if (totalHT < 150) {
            return 0.0
        } else if (totalHT < 200) {
            return totalHT * 0.02
        } else if (totalHT < 300) {
            return totalHT * 0.03
        } else if (totalHT < 500) {
            return totalHT * 0.05
        }

        return totalHT * 0.1
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

    private fun calculerTaxe(): Double {
        return calculerPrixAvecRemise() * taxe
    }

    private fun calculerPrixAvecRemise(): Double {
        return totalHT - remise
    }

    fun afficherTicket(): String {
        var stringResult = "\u001B[1mTicket de caisse n°$Id \u001B[0m\n\n"
        for (lot in lots) {
            stringResult += lot.afficherLot() + "\n"
        }
        stringResult += "Total HT : %.2f €\n".format(totalHT)
        if (remise > 0) {
            stringResult += "Remise : - %.2f €\n".format(remise)
            stringResult += "Total HT après remise : %.2f €\n".format(calculerPrixAvecRemise())
        }
        stringResult += "TVA : + %.2f €\n".format(calculerTaxe())
        stringResult += "\u001B[1mTotal TTC : %.2f €\u001B[0m\n".format(totalTtc)
        return stringResult
    }
}