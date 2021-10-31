package com.example.mvc.controller.post

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    // 예전 방식
    // RequestMethod 가 다르면 path 가 같아도 충돌이 나지 않음
    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])  // RequestMapping : 어떠한 주소를 외부에 노출시키기 위한 어노테이션
    fun requestMapping(): String {
        return "request-mapping"
    }

    // object mapper : json -> object, object -> json
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest // object -> json

    }

}