package com.personal.practise.tree;

import com.personal.practise.Node;

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
//        Optional<Person> person = people.stream().max((p1,p2) -> p1.getAge() - p2.getAge());
//        return person.get();
//    }
//
//    public static int calculate(List<Integer> numbers) {
//        return numbers.stream().reduce((p1,p2) -> p1+p2).get();
//    }
//
//    public static Set<String> getKidNames(List<Person> people) {
//        return people.stream().filter(p -> p.getAge() > 18).map(p -> p.getName()).collect(Collectors.toSet());
//    }
//
//    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
//        Map<Boolean, List<Person>> map = new HashMap<>();
//        map.put(true, new ArrayList<>());
//        map.put(false, new ArrayList<>());
//        return people.stream().collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
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
