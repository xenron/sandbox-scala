// code-examples/AppDesign/options-nulls/option-for-comp-v1-script.scala

case class User(userName: String, name: String, email: String, bio: String)

val newUserProfiles = List(
  Map("userName" -> "twitspam", "name" -> "Twit Spam"),
  Map("userName" -> "bucktrends", "name" -> "Buck Trends",
      "email" -> "thebuck@stops.he.re", "bio" -> "Weltgrößter Schwafler"),
  Map("userName" -> "lonelygurl", "name" -> "Lonely Gurl", 
      "bio" -> "Obviously fake..."),
  Map("userName" -> "deanwampler", "name" -> "Dean Wampler", 
      "email" -> "dean@....com", "bio" -> "Scala-Passionista"),
  Map("userName" -> "al3x", "name" -> "Alex Payne", 
      "email" -> "al3x@....com", "bio" -> "Twitter-API-Genius"))

// Version #1

var validUsers = for {
  user     <- newUserProfiles 
  if (user.contains("userName") && user.contains("name") &&   // #1
      user.contains("email") && user.contains("bio"))         // #1
  userName <- user get "userName" 
  name     <- user get "name" 
  email    <- user get "email"
  bio      <- user get "bio" }
    yield User(userName, name, email, bio)

validUsers.foreach (user => println(user))
