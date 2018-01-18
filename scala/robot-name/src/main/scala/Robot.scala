class Robot {

  var name: String = NamePool.uniqueName
  def reset(): Unit = name = NamePool.newName(name)

//  var name: String = UniqueNameGenerator.uniqueName
//  def reset(): Unit = name = UniqueNameGenerator.newName(name)
}
