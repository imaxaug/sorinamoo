package kr.co.crewmate.site.web.security;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.Mapping;

/**
 * 
 * 클래스명: <code>Access</code>
 * <pre>
 * 인증 인터페이스
 * </pre>
 *
 * @author 이경연
 * @date 2011. 3. 28.
 *
 */
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface Access {
    public abstract String value() default "";
}
