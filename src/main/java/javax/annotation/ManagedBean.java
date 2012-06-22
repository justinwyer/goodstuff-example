package javax.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * This is a total hack to work around the fact that we do not want to include the entire EE 6 api!
 * 
 * @author Justin Wyer <justin@lifeasageek.com>
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ManagedBean
{
   public String value() default "";
}