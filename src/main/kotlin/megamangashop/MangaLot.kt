package org.example.montaine.guillaume.megamangashop

import de.huxhorn.sulky.ulid.ULID

data class MangaLot(val quantite: Int, val prix: Double) {

    fun calculateLot(): Double {
        if(quantite < 0) {
            throw IllegalArgumentException("La quantité ne doit pas être negative")
        }
        if(prix < 0) {
            throw IllegalArgumentException("Le prix ne doit pas être negatif")
        }
        return quantite * prix
    }
}