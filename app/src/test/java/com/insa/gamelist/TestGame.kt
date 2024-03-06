package com.insa.gamelist

import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestGame {
    @Test
    fun testGameAttributes() {
        // Créer un objet Game pour le test
        val game = Game(
            id = 1,
            title = "Super Mario Bros",
            type = "Platformer",
            console = listOf("Nintendo Switch", "NES"),
            editor = "Nintendo",
            developer = "Nintendo",
            timestamp = System.currentTimeMillis(),
            image = "mario.jpg",
            description = "Classic platformer game"
        )

        // Q3
        assertEquals(1, game.id)
        assertEquals("Super Mario Bros", game.title)
        assertEquals("Platformer", game.type)
        assertEquals(listOf("Nintendo Switch", "NES"), game.console)
        assertEquals("Nintendo", game.editor)
        assertEquals("Nintendo", game.developer)
        // Vous pouvez ajuster la vérification du timestamp en fonction de votre besoin
        // assertEquals(expectedTimestamp, game.timestamp)
        assertEquals("mario.jpg", game.image)
        assertEquals("Classic platformer game", game.description)

        // Q4
        println("Titre du jeu: ${game.title}")
    }
}