package com.lzl.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ShortestPathTest {
    private WordGraph wordGraph;

    @BeforeEach
    void setUp() {
        // 初始化WordGraph实例并构建图
        wordGraph = new WordGraph();
        // 假设buildGraph方法接受一个字符串并构建词图
        wordGraph.buildGraph("explore strange new worlds to seek out new life and new mind and");
        // Graphviz.showDirectedGraph(wordGraph);
        // wordGraph.buildGraph("");
    }

    // 测试用例1: 两个词都存在于词图中
    @Test
    void testShortestPath_BothWordsExist() {
        String result = wordGraph.calcShortestPath("explore", "new");
        System.out.println(result);
        assertEquals("The shortest path(s) from explore to new with length 2 are:\nexplore -> strange -> new\n", result);
    }

    // 测试用例2: 词1存在于词图中，词2不存在
    @Test
    void testShortestPath_Word1Exists_Word2NotExist() {
        String result = wordGraph.calcShortestPath("out", "unknown");
        System.out.println(result);
        assertEquals("No word2 in the graph!", result);
    }

    // 测试用例3: 词1不存在词图中，词2存在
    @Test
    void testShortestPath_Word1NotExist_Word2Exists() {
        String result = wordGraph.calcShortestPath("unknown", "mind");
        System.out.println(result);
        assertEquals("No word1 in the graph!", result);
    }

    // 测试用例4: 边界值 - 词图为空
    @Test
    void testShortestPath_NoneWordExists() {
        String result = wordGraph.calcShortestPath("unknown1", "unknown2");
        System.out.println(result);
        assertEquals("No word1 in the graph!", result);
    }

    // 测试用例5: 边界值 - 词1和词2是同一个词
    @Test
    void testShortestPath_SameWord(){
        String result = wordGraph.calcShortestPath("new", "new");
        System.out.println(result);
        assertEquals("The shortest path(s) from new to new with length 0 are:\nnew\n", result);
    }
    @Test
        // 测试用例6: 边界值 - 词1与词2无连接
    void testShortestPath_NoPath(){
        String result = wordGraph.calcShortestPath("out", "explore");
        System.out.println(result);
        assertEquals("No shortest path from out to explore!", result);
    }
    // 测试用例8: 边界值 - 词1和词2通过多个词间接相连
    @Test
    void testShortestPath_MultiPaths(){
        String result = wordGraph.calcShortestPath("new", "and");
        System.out.println(result);
        assertEquals("The shortest path(s) from new to and with length 2 are:\nnew -> life -> and\n", result);
    }
}
