import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/torque-and-development
public class Solution {
    private static ArrayList<ArrayList<Integer>> edges;
    private static int[] vertices;
    private static int verticesNo;
    private static int[] visited;
    
    public static void showGraph() {
        for (int i = 0; i < edges.size(); i++)
            System.out.println(i + ":: " + edges.get(i));
    }
    
    // perform a BFS to find out if there exist a road to library
    public static boolean hasRoadToLibrary(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        visited = new int[verticesNo + 1];
        
        for (int neighbour : edges.get(start)) {
            if (vertices[neighbour] == 1) {
                vertices[start] = 1;
                return true;
            }
            
            q.offer(neighbour);
            visited[neighbour] = 1;
        }
        
        while(q.size() > 0) {
            int neighbour = q.poll();
            if (vertices[neighbour] == 1) {
                vertices[start] = 1;
                return true;
            }
            
            for (int n : edges.get(neighbour))
                if (visited[neighbour] == 0) {
                    q.offer(n);          
                    visited[neighbour] = 1;
                }
        }
        
        return false;
    }
    
    // perform a BFS to count a component's elements
    public static long markComponent(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        long countRoads = 0;
        
        // mark the start as visited
        visited[start] = 1;
        
        // for each neighbour
        for (int neighbour : edges.get(start)) {
            // put the neighbour in the queue
            q.offer(neighbour);
            // update the number of roads
            countRoads++;
            // mark the neighbour as visited
            visited[neighbour] = 1;
        }
        
        while(q.size() > 0) {
            int neighbour = q.poll();

            for (int n : edges.get(neighbour))
                if (visited[n] == 0) {
                    countRoads++;
                    q.offer(n);          
                    visited[n] = 1;
                }
        }
              
        return countRoads;
    }
    
    public static long repairCity(long cost_library, long cost_road) {
        long cost = 0;
               
        /* TIMEOUT
        // first city will have a library built
        vertices[1] = 1;
        cost += cost_library;
        
        for (int v = 2; v < verticesNo + 1; v++)
            if (hasRoadToLibrary(v) == true)
                cost += cost_road;
            else {
                vertices[v] = 1;
                cost += cost_library;
            }
        */
        
        for (int v = 1; v < verticesNo + 1; v++)
            if (visited[v] == 0) {
                long count = markComponent(v);
                cost += cost_library;
                if (cost_library <= cost_road)
                    cost += count * cost_library;
                else 
                    cost += count * cost_road;
            }
                    
        return cost;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            verticesNo = n;
            
            // build the graph
            edges = new ArrayList<>();
            for (int i = 0; i < n + 1; i++)
                edges.add(new ArrayList<Integer>());
            
            vertices = new int[n + 1];
            visited = new int[n + 1];
            
            int m = in.nextInt();
            long x = in.nextLong();
            long y = in.nextLong();
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                edges.get(city_1).add(city_2);
                edges.get(city_2).add(city_1);
            }
            
            System.out.println(repairCity(x, y));
        }
    }
}
