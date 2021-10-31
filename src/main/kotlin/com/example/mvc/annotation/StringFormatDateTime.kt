package com.example.mvc.annotation

import com.example.mvc.validator.StringFormatDateTimeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [StringFormatDateTimeValidator::class])   // 검증 지정
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class StringFormatDateTime (
            val pattern: String = "yyyy-MM-dd HH:mm:ss",
            val message: String = "시간 형식이 유효하지 않습니다.",
            val groups: Array<KClass<*>> = [],
            val payload: Array<KClass<out Payload>> = []
)

// 해당 annotation 이 붙은 변수에 대해서는 FIELD, GETTER, SETTER 에 대해서 StringFormatDateTimeValidator 를 통해 검증을 받겠다  지정
