
package org.mangashop.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

class TestPrixBasique : BehaviorSpec({

    context("A partir d'une quantité  et d'un prix de manga je veux un prix total") {

        given("Une quantité et un prix") {
            val ticket = TicketDeCaisse()
            val quantite = 3
            val prix = 10.0

            When("je calcule le prix total") {
                val total = ticket.calculateLot(quantite, prix)

                Then("le prix total est le bon") {
                    total shouldBe 30.0
                }
            }
        }
    }
    context("Je veux acheter plusieurs lots avec des prix de manga differents"){
        given("Deux lots de manga"){
            val ticket = TicketDeCaisse()
            val quantite1 = 3
            val prix1 = 10.0
            val quantite2 = 2
            val prix2 = 5.0

            When("je crée les lots et je calcule le prix total"){
                ticket.creerLot(quantite1, prix1)
                ticket.creerLot(quantite2, prix2)
                val total1 = ticket.TotalTtc
                Then("le prix total est le bon"){
                    total1 shouldBe 40.0
                }
            }
        }
    }
}
)


