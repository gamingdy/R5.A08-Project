
package org.mangashop.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.example.montaine.guillaume.megamangashop.MangaLot

class TestFacturation: BehaviorSpec({

    context("Je veux vendre plusieurs lot de manga hors tva et remises") {

            given("Je vends 2 lots de manga") {
                val quantite1=42
                val prix1=3.92
                val quantite2=82
                val prix2=4.10

                When("je calcule le prix total") {
                    val lot1 = MangaLot(quantite1, prix1)
                    val lot2 = MangaLot(quantite2, prix2)
                    val total = lot1.calculatePrixLot()+lot2.calculatePrixLot()

                    Then("le prix total est le bon") {
                        total shouldBe 42*3.92+82*4.10
                    }
                }
            }

    }})