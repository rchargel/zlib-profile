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
package net.zcarioca.zcommons.profile.annotations;

/**
 * Annotation can be placed on any method. It wraps the execution of 
 * associated methods with a timer, and logs the execution time.
 * 
 * 
 * @author zcarioca
 */
public @interface LoggedExecutionTime
{
   /**
    * Defines the log level for this execution. Numbers map to Log4J values
    * as follows:
    * 
    * <ol start="0">
    * <li>TRACE</li>
    * <li>DEBUG</li>
    * <li>INFO</li>
    * <li>WARN</li>
    * <li>ERROR</li>
    * <li>FATAL</li>
    * </ol>
    * 
    * Defaults to 1 ('DEBUG').
    */
   public int getValue() default 1;
}
