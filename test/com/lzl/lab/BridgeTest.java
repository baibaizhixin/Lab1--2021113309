package com.lzl.lab;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {

        private WordGraph wordGraph;

        @BeforeEach
        void setUp() {
            // 初始化WordGraph实例并构建图
            wordGraph = new WordGraph();
            // 假设buildGraph方法接受一个字符串并构建词图
            wordGraph.buildGraph("explore strange new worlds to seek out new life and new mind and");

            //wordGraph.buildGraph("");
        }

        // 测试用例1: 两个词都存在于词图中且存在一个桥接词
        @Test
        void testQueryBridgeWords_BothWordsExist_HasBridge() {
            String result = wordGraph.queryBridgeWords("explore", "new");
            System.out.println(result);
            assertEquals("The bridge words from explore to new are: strange", result);
        }

        // 测试用例2: 两个词都存在于词图中但不存在桥接词
        @Test
        void testQueryBridgeWords_BothWordsExist_NoBridge() {
            String result = wordGraph.queryBridgeWords("to", "new");
            System.out.println(result);
            assertEquals("No bridge words from to to new!", result);
        }


        // 测试用例3: 词1存在于词图中，词2不存在
        @Test
        void testQueryBridgeWords_Word1Exists_Word2NotExist() {
            String result = wordGraph.queryBridgeWords("out", "unknown");
            System.out.println(result);
            assertEquals("No unknown in the graph!", result);
        }

        // 测试用例4: 词1不存在词图中，词2存在
        @Test
        void testQueryBridgeWords_Word1NotExist_Word2Exists() {
            String result = wordGraph.queryBridgeWords("unknown", "mind");
            System.out.println(result);
            assertEquals("No unknown in the graph!", result);
        }



        // 测试用例5: 两个词都不存在于词图中 边界值 - 词图为空
        @Test
        void testQueryBridgeWords_NoneWordExists() {
            String result = wordGraph.queryBridgeWords("unknown1", "unknown2");
            System.out.println(result);
            assertEquals("Neither unknown1 nor unknown2 is in the graph!", result);
        }


        // 测试用例6: 边界值 - 词1和词2是同一个词
        @Test
        void testQueryBridgeWords_SameWord(){
            String result = wordGraph.queryBridgeWords("new", "new");
            System.out.println(result);
            assertEquals("No bridge words from new to new!", result);
        }
        @Test
        // 测试用例7: 边界值 - 词1或词2是词图中的第一个或最后一个词
        void testQueryBridgeWords_FirstWord(){
            String result = wordGraph.queryBridgeWords("explore", "strange");
            System.out.println(result);
            assertEquals("No bridge words from explore to strange!", result);
        }


        // 测试用例8: 边界值 - 词1和词2通过多个词间接相连
        @Test
        void testQueryBridgeWords_MultiBridgeWords(){
            String result = wordGraph.queryBridgeWords("new", "and");
            System.out.println(result);
            assertEquals("The bridge words from new to and are: life, mind", result);
        }


}
