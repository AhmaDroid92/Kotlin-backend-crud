package repo

import com.ahmedroid.simpleCRUD.repo.AnimalRepoImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat

class AnimalRepoTest {

    val mockedDataSource = AnimalRepoImpl()

    @Test
    fun `should provide animals list`() {

        // given


        // when
        val animals = mockedDataSource.getAnimals()

        // assert
        assertThat(animals).isNotNull

    }

    @Test
    fun `should provide mocked animal names`() {

        // when
        val animals = mockedDataSource.getAnimals()

        // assert
        assertThat(animals).allMatch { it.name.isNotBlank() }
        assertThat(animals).anyMatch { it.id != 0L }

    }

    @Test
    fun `should provide mocked animal list`() {

        // when
        val animals = mockedDataSource.getAnimals()

        // assert
        assertThat(animals.size).isGreaterThan(2)

    }
}