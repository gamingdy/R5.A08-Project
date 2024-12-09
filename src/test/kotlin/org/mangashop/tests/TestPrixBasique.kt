
package org.mangashop.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.example.montaine.guillaume.megamangashop.MangaLot
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

class TestPrixBasique : BehaviorSpec({

    context("A partir d'une quantité  et d'un prix de manga je veux un prix total") {

        given("Une quantité et un prix") {
            val lot = MangaLot()
            val quantite = 3
            val prix = 10.0

            When("je calcule le prix total") {

                val total = lot.calculateLot(quantite, prix)

                Then("le prix total est le bon") {
                    total shouldBe 30.0
                }
            }
        }
        given("Une quantité negative et un prix")
        {
            val lot = MangaLot()
            val quantite = -3
            val prix = 10.0

            When("je calcule le prix total") {
                try{
                    lot.calculateLot(quantite, prix)
                } catch (e: IllegalArgumentException) {
                    Then("une exception est levée") {
                        e.message shouldNotBe "La quantité ne doit pas être negative"
                    }
                }
            }
        }
        given("Je donne un prix negatif"){
            val lot = MangaLot()
            val quantite = 3
            val prix = -10.0

            When("je calcule le prix total") {
                try{
                    lot.calculateLot(quantite, prix)
                } catch (e: IllegalArgumentException) {
                    Then("une exception est levée") {
                        e.message shouldNotBe "Le prix ne doit pas être negatif"
                    }
                }
            }
        }
        given ("Je donne une quantité a 0")
        {
            val lot = MangaLot()
            val quantite = 0
            val prix = 10.0

            When("je calcule le prix total") {
                val total = lot.calculateLot(quantite, prix)

                Then("le prix total est 0") {
                    total shouldBe 0.0
                }
            }
        }
    }

}
)


