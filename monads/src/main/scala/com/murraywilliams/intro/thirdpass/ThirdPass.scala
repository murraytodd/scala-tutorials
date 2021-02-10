package com.murraywilliams.intro.thirdpass

import scala.util.{Failure, Success, Try}

case class Contact(id: Int, name: String, phone: Option[String], email: Option[String], friendIds: List[Int]) {
  import Contact._

  /*
   * Send an email to friends, inviting to join
   * @return List of successfully sent emails
   */
  def inviteFriends: List[Int] = {

    val successes = friendIds.map { id =>
      dbLookup(id).map { contact =>
        contact.email.map { address =>
          sendEmail(address)
        }
      }
    }

    ??? // successes is now of type List[Try[Option[Boolean]]]
  }
}

object Contact {

  def sendEmail(email: String): Boolean = ???

  def dbLookup(id: Int): Try[Contact] = ???

}

