package com.techchallenge.model;

class SalesmanImpl extends NaturalPersonImpl implements Salesman {

  private Float salary;

  public SalesmanImpl(String name, String cpf, Float salary) {
    super(name, cpf);
    this.setSalary(salary);
  }

  @Override
  public Float getSalary() {
    return this.salary;
  }

  @Override
  public void setSalary(Float salary) {
    this.salary = salary;
  }

}
