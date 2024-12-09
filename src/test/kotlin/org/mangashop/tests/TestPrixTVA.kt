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
                val total = ticket.calculerTotalTTC()

                Then("on doit appliquer 20% de TVA sur le prix Total") {
                    total shouldBe 30.0 * (1 + Pays.France.tva)
                }
            }
        }
    }

    context("Je veux vendre des manga en Belgique") {

        given("Une quantité et un prix et un pays") {
            val quantite = 3
            val prix = 10.0
            val boutique = Boutique(Pays.Belgique)

            When("je calcule le prix total") {

                val ticket = boutique.creerTicket()
                ticket.ajouterLot(quantite, prix)
                val total = ticket.calculerTotalTTC()

                Then("on doit appliquer 17% de TVA sur le prix Total") {
                    total shouldBe 30.0 * (1 + Pays.Belgique.tva)
                }
            }
        }
    }

    context("Je veux vendre des manga en Espagne") {

        given("Une quantité et un prix et un pays") {
            val quantite = 3
            val prix = 10.0
            val boutique = Boutique(Pays.Espagne)

            When("je calcule le prix total") {

                val ticket = boutique.creerTicket()
                ticket.ajouterLot(quantite, prix)
                val total = ticket.calculerTotalTTC()

                Then("on doit appliquer 18.2% de TVA sur le prix Total") {
                    total shouldBe 30.0 * (1 + Pays.Espagne.tva)
                }
            }
        }
    }

    context("Je veux vendre des manga en Allemagne") {

        given("Une quantité et un prix et un pays") {
            val quantite = 3
            val prix = 10.0
            val boutique = Boutique(Pays.Allemagne)

            When("je calcule le prix total") {

                val ticket = boutique.creerTicket()
                ticket.ajouterLot(quantite, prix)
                val total = ticket.calculerTotalTTC()

                Then("on doit appliquer 15.6% de TVA sur le prix Total") {
                    total shouldBe 30.0 * (1 + Pays.Allemagne.tva)
                }
            }
        }
    }
    
    context("Je veux vendre des manga au Royaume-Uni") {

        given("Une quantité et un prix et un pays") {
            val quantite = 3
            val prix = 10.0
            val boutique = Boutique(Pays.RoyaumeUni)

            When("je calcule le prix total") {

                val ticket = boutique.creerTicket()
                ticket.ajouterLot(quantite, prix)
                val total = ticket.calculerTotalTTC()

                Then("on doit appliquer 22.8% de TVA sur le prix Total") {
                    total shouldBe 30.0 * (1 + Pays.RoyaumeUni.tva)
                }
            }
        }
    }
}
)


