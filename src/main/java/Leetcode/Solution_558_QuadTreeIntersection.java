package Leetcode;

class Solution_558_QuadTreeIntersection {
  public Node intersect(Node quadTreeOne, Node quadTreeTwo) {
    if (quadTreeOne.isLeaf) {
      return quadTreeOne.val ? quadTreeOne : quadTreeTwo;
    }
    if (quadTreeTwo.isLeaf) {
      return quadTreeTwo.val ? quadTreeTwo : quadTreeOne;
    }

    quadTreeOne.topLeft = intersect(quadTreeOne.topLeft, quadTreeTwo.topLeft);
    quadTreeOne.topRight = intersect(quadTreeOne.topRight, quadTreeTwo.topRight);
    quadTreeOne.bottomLeft = intersect(quadTreeOne.bottomLeft, quadTreeTwo.bottomLeft);
    quadTreeOne.bottomRight = intersect(quadTreeOne.bottomRight, quadTreeTwo.bottomRight);

    if (quadTreeOne.topLeft.isLeaf && quadTreeOne.topRight.isLeaf && quadTreeOne.bottomLeft.isLeaf
        && quadTreeOne.bottomRight.isLeaf && quadTreeOne.topLeft.val == quadTreeOne.topRight.val
        && quadTreeOne.topRight.val == quadTreeOne.bottomLeft.val
        && quadTreeOne.bottomLeft.val == quadTreeOne.bottomRight.val) {
      quadTreeOne.isLeaf = true;
      quadTreeOne.val = quadTreeOne.topLeft.val;
    }
    return quadTreeOne;
  }
}
