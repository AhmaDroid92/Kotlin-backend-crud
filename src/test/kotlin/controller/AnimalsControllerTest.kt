package controller

import com.ahmedroid.simpleCRUD.SimpleCrudApplication
import com.ahmedroid.simpleCRUD.entity.Animal
import com.ahmedroid.simpleCRUD.repo.AnimalRepo
import com.ahmedroid.simpleCRUD.service.AnimalsService
import com.fasterxml.jackson.databind.ObjectMapper
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [SimpleCrudApplication::class])
@AutoConfigureMockMvc
class AnimalsControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    val service: AnimalsService = mockk()

    @Test
    fun `should Load Context`() {
    }

    @Test
    fun `should return success`() {

        // given
        mockMvc.get("/api/animals")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[0].id") { value(1L) }
            }
    }

    @Test
    fun `should return single animal by id`() {
        // given
        val id = 1L

        mockMvc.get("/api/animal/$id")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.id") { value(1L) }
            }
    }

    @Test
    fun `should return not found error`() {
        // given
        val id = 656L

        mockMvc.get("/api/animal/$id")
            .andDo { print() }
            .andExpect {
                status { isNotFound() }
            }
    }

    @Test
    fun `should accept new animal`() {

        // given
        val giraffe = Animal(44L, "giraffe", 22)

        mockMvc.post("/api/createAnimal") {
            contentType = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(giraffe)
        }.andDo {
            print()
        }.andExpect {
            status { isCreated() }
        }
    }
}