package at.freimueller.kotlinapi.persistence

import at.freimueller.kotlinapi.domain.Teacher
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository : JpaRepository<Teacher, Long> {
    fun findAllByFirstNameAndLastNameLike(firstName: String, lastName: String) : List<Teacher>
}