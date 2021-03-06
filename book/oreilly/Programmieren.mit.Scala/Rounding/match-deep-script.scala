// code-examples/Rounding/match-deep-script.scala

case class Person(name: String, age: Int)

val alice = new Person("Alice", 25)
val bob = new Person("Bob", 32)
val charlie = new Person("Charlie", 32)

for (person <- List(alice, bob, charlie)) {
  person match {
    case Person("Alice", 25) => println("Hallo Alice!")
    case Person("Bob", 32) => println("Hallo Bob!")
    case Person(name, age) => 
      println("Wer bist du, " + age + " Jahre alt mit dem Namen " + name + "?")
  }
}