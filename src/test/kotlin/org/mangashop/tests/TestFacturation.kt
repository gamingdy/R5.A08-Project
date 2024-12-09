
package org.mangashop.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.example.montaine.guillaume.megamangashop.MangaLot
import org.example.montaine.guillaume.megamangashop.Pays
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

class TestFacturation: BehaviorSpec({

    context("Je veux vendre plusieurs lot de manga hors tva et remises") {

        given("Je vends 2 lots de manga") {
            val quantite1 = 42
            val prix1 = 3.92
            val quantite2 = 82
            val prix2 = 4.10

            When("je calcule le prix total") {
                val lot1 = MangaLot(quantite1, prix1)
                val lot2 = MangaLot(quantite2, prix2)
                val total = lot1.calculatePrixLot() + lot2.calculatePrixLot()

                Then("le prix total est le bon") {
                    total shouldBe 42 * 3.92 + 82 * 4.10

                }

            }
            When("J'affiche le ticket de caisse") {
                val ticket = TicketDeCaisse(pays = Pays.France)
                ticket.ajouterLot(quantite1, prix1)
                ticket.ajouterLot(quantite2, prix2)
                val totalHT = ticket.calculateTotalHT()
                val totalTTC = ticket.calculerTotalTTC()
                val ticketString = ticket.afficherTicket()
                Then("le ticket de caisse est le bon") {
                    ticketString shouldBe "Ticket de caisse n°${ticket.Id} \n" +
                            "Taxe : ${Pays.France.tva} \n" +
                            "Remise : ${ticket.remise}" +
                            "Total TTC : $totalTTC"
                }
            }
        }
    }
    context("Je veux m'assurer que les tickets ont un identifiant unique")
    {
        given("Deux tickets de caisse")
        {
            val ticket1 = TicketDeCaisse(pays = Pays.France)
            val ticket2 = TicketDeCaisse(pays = Pays.France)
            When("je compare les identifiants")
            {
                Then("les identifiants sont différents")
                {
                    ticket1.Id shouldNotBe ticket2.Id
                }
            }
        }
    }
})