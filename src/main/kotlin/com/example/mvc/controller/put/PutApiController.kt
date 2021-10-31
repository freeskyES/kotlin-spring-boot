package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    @PutMapping(path = ["/put-mapping/object"])  // userRequest 데이터가 없으면 생성, 있으면 수정
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest,
                         bindingResult: BindingResult  //Valid 한 결과가 BindingResult에 담기게 됨
    ): ResponseEntity<String> {   // @Valid  해당 빈에 대해 검증 (부분 검증)

        if (bindingResult.hasErrors()) {
            // 500 error
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field +" : "+message+"\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity.ok("")
/*
        // 0. Response
        return UserResponse().apply {
            // 1. result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            // 2. description
            this.description = "~~~~~~"
        }.apply {
            // 3. user mutable list
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "es"
                this.age = 10
                this.email = "es@gmail.com"
                this.address = "es address"
                this.phoneNumber = "010-1111-2222"
            })
            userList.add(UserRequest().apply {
                this.name = "es2"
                this.age = 10
                this.email = "es@gmail.com"
                this.address = "es address"
                this.phoneNumber = "010-1111-2222"
            })

            this.userRequest = userList
        }*/
    }
}