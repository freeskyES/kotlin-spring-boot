package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController   // REST API Controller 으로 동작 설정
@RequestMapping("/api")  // 해당 컨트롤러는 /api 의 주소로 동작 // http://localhost:8080/api
class GetApiController {

//    @GetMapping(path = ["/hello", "/abcd"]) // GET http://localhost:8080/api/hello, // GET http://localhost:8080/api/abcd
    @GetMapping("/hello")  // GET http://localhost:8080/api/hello
    fun hello(): String{
        return "hello kotlin"
    }

    // 옛날 방식
    //    @RequestMapping("request-mapping")  // http 메소드에 제한 없이 get, post .. 등등에 동작하게 됨
    @RequestMapping(method = [RequestMethod.GET], path= ["/request-mapping"])  // GetMapping 과 똑같음
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name} , $age")
        return "$name $age"
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age: Int): String {  //value, name 같은 속성
        val name = "kotlin"

        println("${_name} , $age")
        return "$_name $age"
    }

    // http://localhost:8080/api/page?key=value&key=value&key=value
    @GetMapping("/get-mapping/query-param") // ?name=steve&age=20
    fun queryParam(
        @RequestParam name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        println("${name} , ${age}")
        return name+" "+age
    }

    // name, age, address, email
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number")
        return map
    }

}