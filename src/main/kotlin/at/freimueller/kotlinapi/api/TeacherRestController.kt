package at.freimueller.kotlinapi.api

import at.freimueller.kotlinapi.domain.Teacher
import at.freimueller.kotlinapi.service.TeacherService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/teachers", produces = [MediaType.APPLICATION_JSON_VALUE])
class TeacherRestController (val teacherService: TeacherService) {

    @GetMapping
    @ResponseBody
    fun getAllTeachers() : ResponseEntity<List<Teacher>> {
        return ResponseEntity(teacherService.getAllTeachers(), HttpStatus.OK)
    }

    @PostMapping
    @ResponseBody
    fun addTeacher(@RequestBody reqTeacher: Teacher) : ResponseEntity<Teacher> {
        val teacher = Teacher(firstName = reqTeacher.firstName, lastName = reqTeacher.lastName)
        return ResponseEntity(teacherService.createTeacher(teacher), HttpStatus.OK)
    }

}