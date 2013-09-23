/*
 * Project: zlib-profile
 * 
 * Copyright (C) 2013 zcarioca.net
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.zcarioca.zcommons.profile.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the logger aspects.
 * 
 * 
 * @author zcarioca
 */
@Aspect
public class LoggerAspect
{
   /**
    * Wraps the execution of a method in a simple log statement.
    */
   @Around("@annotation(net.zcarioca.zcommons.profile.annotations.LoggedExecutionTime)")
   public Object logExecutionTime(final ProceedingJoinPoint pjp) throws Throwable {
      long start = System.currentTimeMillis();
      
      try {
         return pjp.proceed();
      } finally {
         long time = System.currentTimeMillis() - start;
         Signature signature = pjp.getSignature();
         Class<?> type = signature.getDeclaringType();
         Logger logger = LoggerFactory.getLogger(type);
         
         if (logger.isDebugEnabled()) {
            logger.debug(String.format("Call to '%s' executed in %d ms.", signature.toLongString(), time));
         }
      }
   }

}
