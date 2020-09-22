package at.freimueller.kotlinapi.service

import at.freimueller.kotlinapi.domain.Teacher
import at.freimueller.kotlinapi.persistence.TeacherRepository
import org.springframework.stereotype.Service

@Service
class TeacherService(val teacherRepository: TeacherRepository) {

    fun getAllTeachers() : List<Teacher> {
        return teacherRepository.findAll()
    }

    fun createTeacher(teacher: Teacher) : Teacher {
        return teacherRepository.save(teacher)
    }

    fun filterTeacher(teacher: Teacher) : List<Teacher> {
        return teacherRepository.findAllByFirstNameAndLastNameLike(teacher.firstName?:"", teacher.lastName?:"")
    }

    fun updateTeacher(teacher: Teacher) : Teacher {
        return teacher
    }

}