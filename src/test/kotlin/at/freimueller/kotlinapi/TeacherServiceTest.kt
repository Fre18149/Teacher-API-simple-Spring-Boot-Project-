package at.freimueller.kotlinapi

import at.freimueller.kotlinapi.domain.Teacher
import at.freimueller.kotlinapi.service.TeacherService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource

@ActiveProfiles("test")
@SpringBootTest
class TeacherServiceTest {
    @Autowired
    lateinit var teacherService: TeacherService

    @ParameterizedTest
    @CsvFileSource(resources = ["/test-sources/teachers.csv"], delimiter = '\t', numLinesToSkip = 1)
    fun `ensure saving teacher works with valid values`(firstName: String, lastName: String) {
        val teacher: Teacher = Teacher(firstName = firstName, lastName = lastName)
        assertThat(teacherService.createTeacher(teacher)).isEqualTo(teacher)
        assertNotNull(teacher.teacherId)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/test-sources/teachers.csv"], delimiter = '\t', numLinesToSkip = 1)
    fun `ensure updating teacher works with valid values`(firstName: String, lastName: String) {
        val teacher: Teacher = Teacher(firstName = firstName, lastName = lastName)

    }

}