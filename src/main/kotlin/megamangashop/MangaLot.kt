package org.example.montaine.guillaume.megamangashop

import de.huxhorn.sulky.ulid.ULID

data class MangaLot(val Id: String = ULID().nextULID()) {
    var quantite = 0
    var prix = 0.0
    fun calculateLot(quantite: Int, prix: Double): Double {
        this.quantite = quantite
        this.prix = prix
        return quantite * prix
    }
}