package org.example.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1260 {
    static int V;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int root = Integer.parseInt(input[2]);
        
    }
}
