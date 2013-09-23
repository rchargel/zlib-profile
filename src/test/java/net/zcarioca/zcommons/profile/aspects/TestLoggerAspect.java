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

import static org.junit.Assert.*;

import net.zcarioca.zcommons.profile.LoggedClass;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests the {@link LoggerAspect}.
 * 
 * 
 * @author zcarioca
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/zlib-profile-default-context.xml", "classpath:/TEST-zlib-profile-context.xml" })
public class TestLoggerAspect
{
   @Autowired
   LoggedClass loggedClass;

   @Test
   public void testLoggedExecTime() throws Exception
   {
      loggedClass.testLogExecTime();
   }

   @Test
   public void testLoggedAvgExecTime()
   {
      for (int i = 0; i < 30; i++)
      {
         loggedClass.testLogAvgExecTime();
      }
   }

   @Test
   public void testLoggedExecCount()
   {
      for (int i = 0; i < 30; i++)
      {
         loggedClass.testLogExecCount();
      }
   }

   @Before
   public void testInit()
   {
      assertNotNull(loggedClass);
   }

}
