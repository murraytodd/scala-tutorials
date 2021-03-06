package com.murraywilliams.intro.firstpass

import scala.util.Try

case class Contact(id: Int, name: String, phone: Option[String], email: Option[String], friendIds: List[Int]) {
  import Contact._

  /*
   * Send an email to friends, inviting to join
   * @return List of successfully sent emails
   */
  def inviteFriends: List[Int] = {

    var successes: List[Int] = List.empty

    for (id <- friendIds) {
      val record = dbLookup(id)
      if (record.isSuccess) {
        val maybeEmail = record.get.email
        if (maybeEmail.isDefined) {
          val send = sendEmail(maybeEmail.get)
          if (send) successes = id :: successes
        }
      }
    }

    successes
  }
}

object Contact {

  /**
   * Send an email to the recipient in a blocking (synchronous) context. We're assuming
   * that this API wraps all possible exceptions and simply returns false if anything goes wrong.
   * @param email An email address
   * @return True if the email was sent successfully.
   */
  def sendEmail(email: String): Boolean = ???

  /**
   * Lookup a contact from a database based on a simple Integer ID. If the contact can't be
   * found (i.e. no contact for that ID) we assume a custom Exception is going to be thrown.
   * @param id User ID
   * @return Success(contact) or Failure(e) with some exception if the user can't be found.
   */
  def dbLookup(id: Int): Try[Contact] = ???

}
