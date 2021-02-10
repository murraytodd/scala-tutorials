package com.murraywilliams.intro.secondpass

import scala.util.{Failure, Success, Try}

case class Contact(id: Int, name: String, phone: Option[String], email: Option[String], friendIds: List[Int]) {
  import Contact._

  /*
   * Send an email to friends, inviting to join
   * @return List of successfully sent emails
   */
  def inviteFriends: List[Int] = {

    val contact: Contact = ???
    val email: Option[String] = contact.email
    email.map(e => sendEmail(e))

    val successes = friendIds.map { id =>
      dbLookup(id) match {
        case Failure(exception) => None
        case Success(friend) => {
          friend.email match {
            case Some(email) => if (sendEmail(email)) Some(id) else None
            case None => None
          }
        }
      }
    }
    successes.flatten
  }
}

object Contact {

  def sendEmail(email: String): Boolean = ???

  def dbLookup(id: Int): Try[Contact] = ???

}
