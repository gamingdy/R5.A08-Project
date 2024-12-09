
package org.mangashop.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.example.montaine.guillaume.megamangashop.Boutique
import org.example.montaine.guillaume.megamangashop.Pays
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

class TestPrixTVA : BehaviorSpec({

    context("Je veux vendre des manga en France") {

        given("Une quantité et un prix et un pays") {
            val quantite = 3
            val prix = 10.0
            val boutique = Boutique(Pays.France)

            When("je calcule le prix total") {

                val ticket = boutique.creerTicket()
                ticket.ajouterLot(quantite, prix)
                val total = ticket.TotalTtc

                Then("on doit appliquer 20% de TVA sur le prix Total") {
                    total shouldBe 30.0*Pays.France.tva + 30.0
                }
            }
        }
    }
}
)


