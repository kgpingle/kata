package org.leetcode.arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RemoveElementTest {

  @Test
  @DisplayName("Should remove element")
  public void shouldRemoveElement() {
    assertEquals(2, RemoveElement.removeElement(new int[]{3, 2, 2, 3}, 3));
  }
}