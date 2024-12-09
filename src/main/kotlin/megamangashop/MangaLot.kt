package org.example.montaine.guillaume.megamangashop

import de.huxhorn.sulky.ulid.ULID

data class MangaLot(val quantite: Int, val prix: Double) {

    fun calculatePrixLot(): Double {
        return quantite * prix
    }
}