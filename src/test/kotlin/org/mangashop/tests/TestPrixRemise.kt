
package org.mangashop.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.example.montaine.guillaume.megamangashop.MangaLot
import org.example.montaine.guillaume.megamangashop.Pays
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

class TestPrixRemise : BehaviorSpec({

    context("J'ai vendu des manga au prix elevé et donc j'applique une remise") {
        given("J'ai vendu entre 150 € et 200 €") {
            val ticket = TicketDeCaisse(pays = Pays.France)
            val quantite = 10
            val prix = 15.0
            When("je calcule le prix total") {
                ticket.ajouterLot(quantite, prix)
                Then("je dois appliquer une remise de 2%") {
                    ticket.calculerTotalTTC() shouldBe 150.0 * (1 + Pays.France.tva) * 0.98
                }
            }
        }
        given ("J'ai vendu entre 200 € et 300 €") {
            val ticket = TicketDeCaisse(pays = Pays.France)
            val quantite = 10
            val prix = 20.0
            When("je calcule le prix total") {
                ticket.ajouterLot(quantite, prix)
                Then("je dois appliquer une remise de 3%") {
                    ticket.calculerTotalTTC() shouldBe 200.0 * (1 + Pays.France.tva) * 0.97
                }
            }
        }
        given("J'ai vendu entre 300 et 500 €"){
            val ticket = TicketDeCaisse(pays = Pays.France)
            val quantite = 10
            val prix = 30.0
            When("je calcule le prix total") {
                ticket.ajouterLot(quantite, prix)
                Then("je dois appliquer une remise de 5%") {
                    ticket.calculerTotalTTC() shouldBe 300.0 * (1 + Pays.France.tva) * 0.95
                }
            }
        }
        given("J'ai vendu entre 500€ et 1000€"){
            val ticket = TicketDeCaisse(pays = Pays.France)
            val quantite = 10
            val prix = 50.0
            When("je calcule le prix total") {
                ticket.ajouterLot(quantite, prix)
                Then("je dois appliquer une remise de 7%") {
                    ticket.calculerTotalTTC() shouldBe 500.0 * (1 + Pays.France.tva) * 0.93
                }
            }
        }
        given("J'ai vendu a plus de 1000€"){
            val ticket = TicketDeCaisse(pays = Pays.France)
            val quantite = 10
            val prix = 100.0
            When("je calcule le prix total") {
                ticket.ajouterLot(quantite, prix)
                Then("je dois appliquer une remise de 10%") {
                    ticket.calculerTotalTTC() shouldBe 1000.0 * (1 + Pays.France.tva) * 0.9
                }
            }
        }
    }
    }
)


