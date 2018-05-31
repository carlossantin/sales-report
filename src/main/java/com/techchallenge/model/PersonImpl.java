package com.techchallenge.model;

abstract class PersonImpl implements Person {

  private String name;

  public PersonImpl(String name) {
    this.setName(name);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    boolean equals = true;

    if (obj != null && obj instanceof Person) {    
      Person objPerson = (Person)obj;
      equals = equals && (this.name.equals(objPerson.getName()));
    } else {
      equals = false;
    }

    return equals;
  }

  @Override
  public int hashCode(){
    int prime = 37;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

}
