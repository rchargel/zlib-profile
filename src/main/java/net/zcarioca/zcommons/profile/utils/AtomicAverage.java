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
package net.zcarioca.zcommons.profile.utils;

import java.io.Serializable;

/**
 * Maintains an atomic average.
 * 
 * @author zcarioca
 */
public class AtomicAverage implements Serializable
{
   private static final long serialVersionUID = -1840038551327637125L;
   
   private volatile long count;
   private volatile long total;
   
   public AtomicAverage() {
      reset();
   }
   
   /**
    * Resets the count and total.
    */
   public void reset() {
      this.count = 0;
      this.total = 0;
   }
   
   /**
    * Gets the count of records for this atomic.
    */
   public long getCount() {
      return this.count;
   }
   
   /**
    * Gets the currently running average.
    */
   public double getAverage() {
      long count = getCount();
      long total = getTotal();
      
      if (count == 0) { 
         return 0;
      }
      
      double calc = total / (double)count;
      
      return calc;
   }
   
   /**
    * Adds the value and recalculates the average.
    */
   public double addAndCalculate(long value) {
      long count = getCount();
      long total = getTotal();
      
      total += value;
      count += 1;
      
      if (total < 0) {
         total = 0;
         count = 0;
      }

      double calc = 0;
      if (count != 0) { 
         calc = total / (double)count;
      }
      
      this.count = count;
      this.total = total;
      return calc;
   }
   
   private long getTotal() {
      return this.total;
   }
}
