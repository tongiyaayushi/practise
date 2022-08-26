package com.personal.practise.tree;

import java.util.*;
import java.util.stream.Collectors;

public class HeightOfTree {

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return  Arrays.stream(names).filter(s -> s.toCharArray().length > 5 ).mapToInt(s -> s.toCharArray().length).sum();
    }

    public static Collection<String> getTotalNumberOfLettersOfNamesLongerThanFive1(String... names) {
        return  Arrays.stream(names).map(n -> n.toUpperCase()).collect(Collectors.toList());
    }

    public static List<String> transform(List<List<String>> collection) {
        return collection.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

//    public static Person getOldestPerson(List<Person> people) {
//        return people.stream().sorted(Comparator.comparing(person -> person.getAge()));
//    }

    int height(Node node)
    {
        int height = 0;
        if (node == null)
            return height;

        height ++;

        int leftHeight = height(node.left);
        leftHeight = height + leftHeight;

        int rightHeight = height(node.right);
        rightHeight = height + rightHeight;

        return Math.max(leftHeight,rightHeight);
    }

    public int maxDepth(Node node){
        if (node == null)
            return -1;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

}
