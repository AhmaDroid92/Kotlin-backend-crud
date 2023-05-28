package service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import com.ahmedroid.simpleCRUD.repo.AnimalRepo
import com.ahmedroid.simpleCRUD.service.AnimalsService

class AnimalsServiceTest {

    val animalsRepo: AnimalRepo = mockk()
    val animalsService = AnimalsService(animalsRepo)

    @Test
    fun `should call its repo`() {

        // given
        every { animalsRepo.getAnimals() } returns emptyList()

        // when
        val animals = animalsService.getAnimals()

        // assert
        verify(exactly = 1) { animalsRepo.getAnimals() }

    }
}