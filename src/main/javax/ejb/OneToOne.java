/*
 * JBoss, the OpenSource EJB server
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package javax.ejb;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision$
 */
@Target({ElementType.METHOD, ElementType.FIELD}) @Retention(RetentionPolicy.RUNTIME)
public @interface OneToOne
{
   String targetEntity() default "";
   CascadeType[] cascade() default {};
   FetchType fetch() default FetchType.EAGER;
   boolean optional() default true;
}
