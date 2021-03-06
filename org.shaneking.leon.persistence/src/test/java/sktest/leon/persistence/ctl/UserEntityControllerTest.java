package sktest.leon.persistence.ctl;

import org.junit.jupiter.api.Test;
import org.shaneking.leon.test.SKSpringMvcUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserEntityControllerTest extends SKSpringMvcUnit {

  @Test
  void curd() throws Exception {
    setTstSeq("add");
    assertNotNull(performJT("/user/add"));
    setTstSeq("mge");
    assertNotNull(performJT("/user/mge"));
    setTstSeq("modByIdVer");
    assertNotNull(performJT("/user/mod"));
    setTstSeq("mge");
    assertNotNull(performJT("/user/mge"));
    setTstSeq("rmv");
    assertNotNull(performJT("/user/rmv"));//dd is random
  }
}
