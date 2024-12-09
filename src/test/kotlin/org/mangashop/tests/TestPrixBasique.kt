
package org.mangashop.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe
import org.example.montaine.guillaume.megamangashop.TicketDeCaisse

class TestPrixBasique : BehaviorSpec({

    context("je veux vérifier que chaque ticket a son identifiant unique") {

        given("un ticket") {
            val ticket = TicketDeCaisse()

            And("un 2e ticket") {
                val ticket2 = TicketDeCaisse()

                When("je lis les 2 identifiants") {
                    val id1 = ticket.Id
                    val id2 = ticket2.Id

                    Then("ce n'est pas le même") {
                        id1 shouldNotBe id2
                    }

                }
            }
        }
    }})