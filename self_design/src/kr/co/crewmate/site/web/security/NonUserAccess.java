package kr.co.crewmate.site.web.security;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.Mapping;

/**
 * 비회원 Access 체크
 * 
 * @author 남세건
 *
 */
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface NonUserAccess {
    public abstract String value() default "";
}
