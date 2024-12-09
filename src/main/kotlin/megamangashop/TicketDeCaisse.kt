
package org.example.montaine.guillaume.megamangashop

import de.huxhorn.sulky.ulid.ULID;


data class TicketDeCaisse(val Id: String = ULID().nextULID() ) {

    val TotalTtc: Double = 0.0
    val Taxe: Double = 0.0
    val Remise: Double = 0.0

    fun calculateLot(quantite: Int, prix: Double): Double {
        return quantite * prix
    }

    fun afficherTicket(): String {
        return "Ticket de caisse n°$Id \n" +

                "Taxe : $Taxe \n" +
                "Remise : $Remise" +
                "Total TTC : $TotalTtc"
    }
}