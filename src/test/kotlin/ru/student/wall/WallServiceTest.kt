package ru.student.wall

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WallServiceTest {
    @BeforeTest
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addAssignsId() {
        val result = WallService.add(Post(text = "Первый пост"))

        assertEquals(1, result.id)
    }

    @Test
    fun updateExistingPost() {
        val addedPost = WallService.add(Post(text = "Старый текст"))
        val updatedPost = addedPost.copy(text = "Новый текст", likes = LikesInfo(count = 5))

        val result = WallService.update(updatedPost)

        assertTrue(result)
    }

    @Test
    fun updateMissingPost() {
        val result = WallService.update(Post(id = 100, text = "Такого поста нет"))

        assertFalse(result)
    }
}
