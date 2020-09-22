package at.freimueller.kotlinapi.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Version

@Entity
data class Teacher(
        @Id @GeneratedValue var teacherId : Long? = null,
        var firstName: String? = null,
        var lastName: String? = null
)