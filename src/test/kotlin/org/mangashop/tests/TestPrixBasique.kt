
package org.mangashop.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

class TestPrixBasique : BehaviorSpec({

    context("A partir d'une quantité  et d'un prix de manga je veux un prix total") {

        given("Une quantité et un prix") {
            val quantite = 3
            val prix = 10.0

            When("je calcule le prix total") {
                val total = calculateLot(quantite, prix)

                Then("le prix total est le bon") {
                    total shouldBe 30.0
                }
            }
        }
    }
    context()
}
)


