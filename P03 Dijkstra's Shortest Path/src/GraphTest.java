// --== CS400 File Header Information ==--
// Name: Ryan Almizyed
// Email: almizyed@wisc.edu
// Team: MG
// TA: Harit
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of Project Three: the
 * implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest
{

  private CS400Graph<Integer> graph;

  @BeforeEach
  /**
   * Instantiate graph from last week's shortest path activity.
   */
  public void createGraph()
  {
    graph = new CS400Graph<>();
    // insert vertices 0-9
    for (int i = 0; i < 10; i++)
      graph.insertVertex(i);
    // insert edges from Week 08. Dijkstra's Activity
    graph.insertEdge(0, 2, 1);
    graph.insertEdge(1, 7, 2);
    graph.insertEdge(1, 8, 4);
    graph.insertEdge(2, 4, 4);
    graph.insertEdge(2, 6, 3);
    graph.insertEdge(3, 1, 6);
    graph.insertEdge(3, 7, 2);
    graph.insertEdge(4, 5, 4);
    graph.insertEdge(5, 0, 2);
    graph.insertEdge(5, 1, 4);
    graph.insertEdge(5, 9, 1);
    graph.insertEdge(6, 3, 1);
    graph.insertEdge(7, 0, 3);
    graph.insertEdge(7, 6, 1);
    graph.insertEdge(8, 9, 3);
    graph.insertEdge(9, 4, 5);
  }

  /**
   * Checks the distance/total weight cost from the vertex labeled 0 to 8 (should be 15), and from
   * the vertex labeled 9 to 8 (should be 17).
   */
  @Test
  public void providedTestToCheckPathCosts()
  {
    assertTrue(graph.getPathCost(0, 8) == 15);
    assertTrue(graph.getPathCost(9, 8) == 17);
  }

  /**
   * Checks the ordered sequence of data within vertices from the vertex labeled 0 to 8, and from
   * the vertex labeled 9 to 8.
   */
  @Test
  public void providedTestToCheckPathContents()
  {
    assertTrue(graph.shortestPath(0, 8).toString().equals("[0, 2, 6, 3, 1, 8]"));
    assertTrue(graph.shortestPath(9, 8).toString().equals("[9, 4, 5, 1, 8]"));
  }

  /**
   * Checks that the distance from vertex 3 to vertex 5 is 14 as determined in activity.
   */
  @Test
  public void myTestConfirmPathCost()
  {
    assertTrue(graph.getPathCost(3, 5) == 14);
  }

  /**
   * Checks that the sequence from vertex 3 to vertex 5 is
   */
  @Test
  public void myTestConfirmPathSequence()
  {
    assertTrue(graph.shortestPath(3, 5).toString().equals("[3, 7, 0, 2, 4, 5]"));
  }

  /**
   * Checks that a path from a vertex to the same vertex is a path cost of 0
   */
  @Test
  public void myTestConfirmPathToSelf()
  {
    assertTrue(graph.getPathCost(3, 3) == 0);
  }

  /**
   * Checks that a correct path that has a high weight will be replaced by a path with a smaller
   * weight once discovered later on. I.E. the path from 1 to 3.
   */
  @Test
  public void myTestNonObviousShortestPath()
  {
    CS400Graph<Integer> myGraph = new CS400Graph<>();
    // insert vertices 1-3
    for (int i = 1; i <= 3; i++)
      myGraph.insertVertex(i);
    myGraph.insertEdge(1, 3, 3);
    myGraph.insertEdge(1, 2, 1);
    myGraph.insertEdge(2, 3, 1);

    System.out.println(myGraph.shortestPath(1, 3).toString());
    assertTrue(myGraph.shortestPath(1, 3).toString().equals("[1, 2, 3]"));
  }

}
