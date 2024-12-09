
package org.mangashop.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.example.montaine.guillaume.megamangashop.MangaLot
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

class TestPrixBasique : BehaviorSpec({

    context("A partir d'une quantité  et d'un prix de manga je veux un prix total") {

        given("Une quantité et un prix") {

            val quantite = 3
            val prix = 10.0

            When("je calcule le prix total") {
                val lot = MangaLot(quantite, prix)
                val total = lot.calculatePrixLot()

                Then("le prix total est le bon") {
                    total shouldBe 30.0
                }
            }
        }
        given("Une quantité negative et un prix")
        {

            val quantite = -3
            val prix = 10.0
            val lot = MangaLot(quantite,prix)
            When("je calcule le prix total") {
                try{
                    lot.calculatePrixLot()
                } catch (e: IllegalArgumentException) {
                    Then("une exception est levée") {
                        e.message shouldBe "La quantité ne doit pas être negative"
                    }
                }
            }
        }
        given("Je donne un prix negatif"){

            val quantite = 3
            val prix = -10.0
            val lot = MangaLot(quantite, prix)
            When("je calcule le prix total") {
                try{
                    lot.calculatePrixLot()
                } catch (e: IllegalArgumentException) {
                    Then("une exception est levée") {
                        e.message shouldBe "Le prix ne doit pas être negatif"
                    }
                }
            }
        }
        given ("Je donne une quantité a 0")
        {

            val quantite = 0
            val prix = 10.0
            val lot = MangaLot(quantite, prix)
            When("je calcule le prix total") {
                val total = lot.calculatePrixLot()

                Then("le prix total est 0") {
                    total shouldBe 0.0
                }
            }
        }
    }

}
)


