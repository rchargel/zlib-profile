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
package net.zcarioca.zcommons.profile;

import net.zcarioca.zcommons.profile.annotations.LoggedAverageExecutionTime;
import net.zcarioca.zcommons.profile.annotations.LoggedExecutionCount;
import net.zcarioca.zcommons.profile.annotations.LoggedExecutionTime;

/**
 * Used to test logging operations
 * 
 * @author zcarioca
 */
public class LoggedClass
{
   @LoggedExecutionCount
   public void testLogExecCount()
   {
         // do nothing
   }
   
   @LoggedAverageExecutionTime
   public void testLogAvgExecTime()
   {
      try
      {
         Thread.sleep(20);
      }
      catch (Throwable t)
      {
         // do nothing
      }
   }
   
   @LoggedExecutionTime
   public void testLogExecTime()
   {
      try
      {
         Thread.sleep(100);
      }
      catch (Throwable t)
      {
         // do nothing
      }
   }
}
