package com.murraywilliams.intro

import scala.util.{Failure, Success, Try}

case class Contact(id: Int, name: String, phone: Option[String],
                   email: Option[String], friendIds: List[Int]) {
  import Contact._

  /*
   * Send an email to friends, inviting to join
   * @return List of successfully sent emails
   */
  def inviteFriends: List[Int] = {

    for {
      id <- friendIds
      contact <- dbLookup(id).toOption
      eaddr <- contact.email
      status = sendEmail(eaddr)
      if (status)
    } yield (id)

  }
}

object Contact {

  /**
   * Send an email to the recipient in a blocking (synchronous) context. We're
   * assuming that this API wraps all possible exceptions and simply returns false
   * if anything goes wrong.
   * @param email An email address
   * @return True if the email was sent successfully.
   */
  def sendEmail(email: String): Boolean = ???

  /**
   * Lookup a contact from a database based on a simple Integer ID. If the contact
   * can't be found (i.e. no contact for that ID) we assume a custom Exception is
   * going to be thrown.
   * @param id User ID
   * @return Success(contact) or Failure(e) with some exception if the user can't
   *         be found.
   */
  def dbLookup(id: Int): Try[Contact] = ???

}