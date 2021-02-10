package com.murraywilliams.intro.finalPass

import scala.util.Try

case class Contact(id: Int, name: String, phone: Option[String], email: Option[String], friendIds: List[Int]) {
  import Contact._

  /*
   * Send an email to friends, inviting to join
   * @return List of successfully sent emails
   */
  def inviteFriends: List[Int] = {
    for {
      id <- friendIds
      contact <- dbLookup(id).toOption
      email <- contact.email
      if sendEmail(email)
    } yield(id)
  }
}

object Contact {

  def sendEmail(email: String): Boolean = ???

  def dbLookup(id: Int): Try[Contact] = ???

}