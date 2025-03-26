package org.example;


public class LeastCommonAncestor {

  Group rootGroup;

  public LeastCommonAncestor(Group rootGroup) {
    this.rootGroup = rootGroup;
  }

  public static void main(String[] args) {

    Group company = new Group("Company");
    Group hr = new Group("Hr");
    Group eng = new Group("Eng");
    company.addChildren(hr).addChildren(eng);

    Group mona = new Group("Mona");
    Group springs = new Group("Springs");
    hr.addChildren(mona).addChildren(springs);

    Group be = new Group("BE");
    Group fe = new Group("FE");
    eng.addChildren(be).addChildren(fe);

    Group alice = new Group("Alice");
    Group bob = new Group("Bob");
    be.addChildren(alice).addChildren(bob);

    Group lisa = new Group("Lisa");
    Group marley = new Group("Marley");
    fe.addChildren(lisa).addChildren(marley);

    LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor(company);
    System.out.println(
        "Lowest " + leastCommonAncestor.lowestCommonAncestor(company, "Alice", "Marley").name);

  }

  private Group lowestCommonAncestor(Group group, String firstName, String secondName) {
    if (group == null || group.name.equals(firstName) || group.name.equals(secondName)) {
      return group;
    }
    int count = 0;
    Group lowestCommon = null;
    for (Group child : group.children) {
      Group foundGroup = lowestCommonAncestor(child, firstName, secondName);
      if (foundGroup != null) {
        count++;
        lowestCommon = foundGroup;
      }
    }
    if (count >= 2) {
      return group;
    }
    return lowestCommon;
  }


}

//Company
//  HR
//    Mona
//    Springs
//  Engineering
//    BE
//      Alice
//      Bob
//    FE
//      Lisa
//      Marley