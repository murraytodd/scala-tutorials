package com.murraywilliams.intro.fourthPass

import scala.util.Try

case class Contact(id: Int, name: String, phone: Option[String], email: Option[String], friendIds: List[Int]) {
  import Contact._

  /*
   * Send an email to friends, inviting to join
   * @return List of successfully sent emails
   */
  def inviteFriends: List[Int] = {

    val successes = friendIds
      .flatMap(id => dbLookup(id).toOption
        .flatMap(contact => contact.email)
        .filter(sendEmail).map(_ => id))

    successes
  }

}

object Contact {

  def sendEmail(email: String): Boolean = ???

  def dbLookup(id: Int): Try[Contact] = ???

}