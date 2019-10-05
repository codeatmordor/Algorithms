package org.gks.problems.misc;

public class Knapsack0 {

  private static class Item {
    int weight;
    int value;

    Item(int w, int v) {
      this.weight = w;
      this.value = v;
    }
  }

  public static int recursiveKnapSack(Item[] items, int maxW) {
    return knapSack(items, maxW, 0);
  }

  private static int knapSack(Item[] items, int maxW, int i) {
    if (i == items.length)
      return 0;
    if (items[i].weight > maxW)
      return knapSack(items, maxW, i + 1);

    return Math.max(knapSack(items, maxW - items[i].weight, i + 1) + items[i].value,
        knapSack(items, maxW, i + 1));

  }

  public static int bottomUpKnapsack(Item[] items, int maxW) {
    int[][] cache = new int[items.length + 1][maxW + 1];
    for (int i = 1; i <= items.length; i++) {
      for (int j = 1; j <= maxW; j++) {

        if (items[i - 1].weight > j)
          cache[i][j] = cache[i - 1][j];
        else {
          // Choice between including the item and not including the item
          cache[i][j] =
              Math.max(cache[i - 1][j], cache[i - 1][j - items[i - 1].weight] + items[i - 1].value);
        }
      }
    }
    for (int k = 0; k <= items.length; k++) {
      for (int l = 0; l <= maxW; l++) {
        System.out.print(cache[k][l] + " ");
      }
      System.out.println();
    }

    return cache[items.length][maxW];
  }

  public static void main(String[] args) {

    Item[] items = new Item[3];
    items[0] = new Item(1, 6);
    items[1] = new Item(2, 10);
    items[2] = new Item(3, 20);

    System.out.println("Bottom-Up Version Result " + bottomUpKnapsack(items, 5));
    System.out.println("Recursive Version Result " + recursiveKnapSack(items, 5));

  }

}
