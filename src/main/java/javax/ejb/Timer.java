/*
 *  JBoss, Home of Professional Open Source
 *  Copyright 2010 Red Hat, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package javax.ejb;

import java.io.Serializable;
import java.util.Date;

/**
 * The Timer interface contains information about a timer that was created
 * through the EJB Timer Service
 **/
public interface Timer {
   
   /**
    * Cause the timer and all its associated expiration notifications to be canceled.
    *
    * @throws IllegalStateException If this method is invoked while the instance is in
    *                               a state that does not allow access to this method.
    * @throws NoSuchObjectLocalException If invoked on a timer that has expired or has been canceled.
    * @throws EJBException If this method could not complete due to a system-level failure.
    **/
   public void cancel()
      throws
         IllegalStateException,
         NoSuchObjectLocalException,
         EJBException;
   
   /**
    * Get the number of milliseconds that will elapse before the next scheduled timer expiration.
    *
    * @return Number of milliseconds that will elapse before the next scheduled timer expiration.
    *
    * @throws IllegalStateException If this method is invoked while the instance is in
    *                               a state that does not allow access to this method.
    * @throws NoMoreTimeoutsException Indicates that the timer has no future timeouts.
    * @throws NoSuchObjectLocalException If invoked on a timer that has expired or has been canceled.
    * @throws EJBException If this method could not complete due to a system-level failure.
    **/
   public long getTimeRemaining()
      throws
         IllegalStateException,
         NoMoreTimeoutsException,
         NoSuchObjectLocalException,
         EJBException;
   
   /**
    * Get the point in time at which the next timer expiration is scheduled to occur.
    *
    * @return Get the point in time at which the next timer expiration is scheduled to occur.
    *
    * @throws IllegalStateException If this method is invoked while the instance is in
    *                               a state that does not allow access to this method.
    * @throws NoMoreTimeoutsException Indicates that the timer has no future timeouts.
    * @throws NoSuchObjectLocalException If invoked on a timer that has expired or has been canceled.
    * @throws EJBException If this method could not complete due to a system-level failure.
    **/
   public Date getNextTimeout()
      throws
         IllegalStateException,
         NoMoreTimeoutsException,
         NoSuchObjectLocalException,
         EJBException;
   
   /**
    * Get the information associated with the timer at the time of creation.
    *
    * @return The Serializable object that was passed in at timer creation, or null if the
    *         info argument passed in at timer creation was null.
    *
    * @throws IllegalStateException If this method is invoked while the instance is in
    *                               a state that does not allow access to this method.
    * @throws NoSuchObjectLocalException If invoked on a timer that has expired or has been canceled.
    * @throws EJBException If this method could not complete due to a system-level failure.
    **/
   public Serializable getInfo()
      throws
         IllegalStateException,
         NoSuchObjectLocalException,
         EJBException;
   
   /**
    * Get a serializable handle to the timer. This handle can be used at a later time to
    * re-obtain the timer reference.
    *
    * @return Handle of the Timer
    *
    * @throws IllegalStateException If this method is invoked while the instance is in
    *                               a state that does not allow access to this method.
    * @throws NoSuchObjectLocalException If invoked on a timer that has expired or has been canceled.
    * @throws EJBException If this method could not complete due to a system-level failure.
    **/
   public TimerHandle getHandle()
      throws
         IllegalStateException,
         NoSuchObjectLocalException,
         EJBException;
   
   /**
    * Get the schedule expression corresponding to this timer.
    * 
    * @return
    * @throws IllegalStateException If this method is invoked while the instance
    *   is in a state that does not allow access to this method. Also thrown if
    *   invoked on a timer that was created with one of the non-ScheduleExpression
    *   TimerService.createTimer APIs.
    * @throws NoSuchObjectLocalException If invoked on a timer that has expired or 
    *   has been cancelled. 
    * @throws EJBException If this method could not complete due to a system-level
    *   failure.
    * @since 3.1
    */
   ScheduleExpression getSchedule() throws IllegalStateException, 
      NoSuchObjectLocalException, EJBException;

   /**
    * Query whether this timer is a calendar-based timer. 
    * 
    * @return true if this timer is a calendar-based timer. 
    * @throws IllegalStateException If this method is invoked while the instance
    *   is in a state that does not allow access to this method.
    * @throws NoSuchObjectLocalException If invoked on a timer that has expired
    *   or has been cancelled. 
    * @throws EJBException If this method could not complete due to a system-level failure.
    * @since 3.1
    */
   boolean isCalendarTimer() throws IllegalStateException, NoSuchObjectLocalException, 
      EJBException;
   
   /**
    * Query whether this timer has persistent semantics.
    * 
    * @return true if this timer has persistent guarantees.
    * @throws IllegalStateException If this method is invoked while the instance 
    *   is in a state that does not allow access to this method. 
    * @throws NoSuchObjectLocalException If invoked on a timer that has expired
    *   or has been cancelled. 
    * @throws EJBException If this method could not complete due to a system-level failure.
    * @since 3.1
    */
   boolean isPersistent() throws IllegalStateException, NoSuchObjectLocalException,
      EJBException;

}
