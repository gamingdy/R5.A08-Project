package org.example.montaine.guillaume.megamangashop

import de.huxhorn.sulky.ulid.ULID

data class MangaLot(val quantite: Int, val prix: Double) {

    fun calculateLot(): Double {
        return quantite * prix
    }
}