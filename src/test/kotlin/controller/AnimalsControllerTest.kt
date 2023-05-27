package controller

import com.ahmedroid.simpleCRUD.SimpleCrudApplication
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [SimpleCrudApplication::class])
@AutoConfigureMockMvc
class AnimalsControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

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

        // when


        // assert


    }
}