package org.example;

import org.example.challengeClasses.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //TODO create method to find the max sum in array
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] firstArray = {1, 3, 5, 9, 11};
        int[] secondArray = {10, 45,24, 36, 90};
        int[] blankArray = new int[0];
        int[] dupArr = {1, 2, 4, 4, 6, 8, 8, 9};
        int[] noDupArr = {1,2,3,4,5,6,7,8,9};
        System.out.println("First Array");
        System.out.println(Arrays.toString(firstArray));
        System.out.println("Array Pairs added up");
        System.out.println(Arrays.toString(sumArrayPairs(firstArray)));
        System.out.println("Second Array");
        System.out.println(Arrays.toString(secondArray));
        System.out.println("Array pairs summed up");
        System.out.println(Arrays.toString(sumArrayPairs(secondArray)));
        System.out.println("Blank Array");
        System.out.println(Arrays.toString(blankArray));
        System.out.println("Ran through sumArrayPairs");
        System.out.println(Arrays.toString(sumArrayPairs(blankArray)));
        System.out.println("Does it have duplication");
        System.out.println(hasDuplicates(dupArr));
        System.out.println(hasDuplicates(noDupArr));
        System.out.println("-------------------------");
        fizzBuzz(100);
        System.out.println("-------------------------");
        System.out.println("Prime Checker");
        for (int i = 1; i < 122; ++i) {
            System.out.println("Number: " + i);
            System.out.println(isPrime(i));
        }
        System.out.println("-------------------------");
        System.out.println("Fib Sequence");
        System.out.println(Arrays.toString(generateFibonacci(10)));
        System.out.println("-------------------------");
        System.out.println(anagramDetection("listen", "silent"));
        System.out.println(anagramDetection("hello", "goodbye"));
        System.out.println(anagramDetection("Astronomer", "Moon starer"));
        System.out.println("-------------------------");
        System.out.println(sumArray(firstArray));
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(leftAndRightArray(firstArray)));
        System.out.println("-------------------------");
        int[] missingNumber = {3,2,5,7,6,8,10,9};
        int[] missingNumber2 = {2,1,4,3,6,5,8,9,10,12,11};
        System.out.println(Arrays.toString(missingNumber));
        System.out.println("The missing number is: "+findMissingNumber(missingNumber));
        System.out.println(Arrays.toString(missingNumber2));
        System.out.println("The missing number is: "+findMissingNumber(missingNumber2));
        System.out.println("-------------------------");
        int[] numbers = {11, 15, 2, 7};
        System.out.println(Arrays.toString(findTwoSum(numbers, 9)));
        System.out.println("-------------------------");
        System.out.println("Is radar a palindrome: " + isPalindrome("radar"));
        System.out.println("Is Hello, world a palindrome: " + isPalindrome("Hello, world"));
        System.out.println("-------------------------");
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(3));
        head.getNext().getNext().setNext(new ListNode(4));
        head.getNext().getNext().getNext().setNext(new ListNode(5));

        System.out.println("Original List:");
        printList(head);

        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
        System.out.println("-------------------------");
        String text = "This is a sample text. The text contains multiple sentences. Sample text!";
        Map<String, Integer> wordFrequency = wordFrequencyCounter(text);

        wordFrequency.forEach((word, count) -> System.out.println(word+": "+ count));
        System.out.println("-------------------------");
        int[] bubbleSortArray = {10,7,4,3,6,2,9,1};
        System.out.println(Arrays.toString(missingNumber));
        System.out.println(Arrays.toString(bubbleSort(missingNumber)));
        System.out.println(Arrays.toString(bubbleSortArray));
        System.out.println(Arrays.toString(bubbleSort(bubbleSortArray)));
        System.out.println("-------------------------");
        System.out.println("Kid Candy Problem");
        int[] kidCandyArr = {2,3,5,1,3};
        int[] kidCandyArr2 = {4,2,1,1,2};
        System.out.println(kidsWithCandy(kidCandyArr, 3));
        System.out.println(kidsWithCandy(kidCandyArr2, 1));
        System.out.println("-------------------------");
        System.out.println("Compressed String");
        String test = "aabcccccaaa";
        String test1 = "abcd";
        String test2 = "aa";
        System.out.println(compressWord(test));
        System.out.println(compressWord(test1));
        System.out.println(compressWord(test2));
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(removeDuplicates(dupArr)));
    }

    public static int[] sumArrayPairs(int[] originalArray) {
        if(originalArray == null || originalArray.length == 0) {
            return new int[0];
        }

        int[] resultArray = new int[originalArray.length];
        resultArray[0] = originalArray[0];

        for (int i = 1; i < originalArray.length; i++) {
            resultArray[i] = originalArray[i] + originalArray[i-1];
        }

        return resultArray;
    }

    public static boolean hasDuplicates(int[] arr) {
        if(arr == null | arr.length == 0) {
            return false;
        }

        Set<Integer> intSet = new HashSet<Integer>(Arrays.stream(Arrays
                .stream(arr)
                .boxed()
                .toArray(Integer[]::new))
                .toList());

        return arr.length != intSet.size();
    }

    public static int[] removeDuplicates(int[] arr) {
        if(arr == null | arr.length == 0) {
            return new int[0];
        }

        Set<Integer> intSet = new HashSet<Integer>(Arrays.stream(Arrays
                        .stream(arr)
                        .boxed()
                        .toArray(Integer[]::new))
                        .toList());

        return intSet.stream().mapToInt(Number::intValue).toArray();
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        if(n / 1 == n && n / n == 1 && n % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] generateFibonacci(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr;
    }

    public static boolean anagramDetection(String a, String b) {
        char[] arr1 = a.replaceAll("\\s+","").toLowerCase().toCharArray();
        char[] arr2 = b.replaceAll("\\s+","").toLowerCase().toCharArray();
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (char value : arr1) {
            map1.merge(value, 1, Integer::sum);
        }
        for (char c : arr2) {
            map2.merge(c, 1, Integer::sum);
        }

        return map1.equals(map2);
    }

    public static int sumArray(int[] arr) {
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            result += arr[1];
        }
        return result;
    }

    public static int[] leftAndRightArray(int[] arr) {
        int[] results = new int[arr.length];
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = arr[i-1]+arr[i];
        }

        right[arr.length-1] = arr[arr.length-1];

        for (int i = arr.length-2; i >= 0; i--) {
            right[i] = right[i+1]+arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            results[i] = Math.abs(left[i]-right[i]);
        }
        return results;
    }

    public static int findMissingNumber(int[] arr) {
        if (arr == null | arr.length == 0) return 0;
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        int results = sortedArr[0];

        for (int i = 0; i < sortedArr.length; i++) {
            if(results == sortedArr[i]) {
                results++;
            } else {
                return results;
            }
        }
        return results;
    }

    public static int[] findTwoSum(int[] arr, int target){
        int[] result;
        for (int i = 0; i < arr.length; i += 2) {
            if(arr[i] + arr[i+1] == target){
                result = new int[]{arr[i], arr[i + 1]};
                return result;
            }
        }
        return new int[]{};
    }

    public static boolean isPalindrome(String str) {
        String reverseString = new StringBuilder(str).reverse().toString();
        return reverseString.equalsIgnoreCase(str);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        return prev;
    }

    public static Map<String, Integer> wordFrequencyCounter(String text) {
        Map<String, Integer> map;
        String[] stopWords = {"the", "and", "is", "in", "it", "of", "to", "this"};
        map = Arrays.stream(text.toLowerCase()
                .replaceAll("\\p{Punct}", "")
                .split("\\s+"))
                .filter(s -> !isStopWord(s, stopWords))
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
        return map;
    }

    public static int[] bubbleSort(int[] arr) {
        boolean swapped;
        int temp;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return arr;
    }

    public static String longestCommonPrefix(String[] arr){
        /*
        TODO Write a function to find the longest common prefix string amongst an array of strings.
         If there is no common prefix, return an empty string ""
        */
        return "";
    }

    public static List<Boolean> kidsWithCandy(int[] arr, int extra) {
        int greatest = 0;
        List<Boolean> truthList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] + extra > greatest) {
                truthList.add(true);
                greatest = arr[i];
            }
            else {
                truthList.add(false);
            }
        }
        return truthList;
    }

    public static String compressWord(String str) {
        char[] arr = str.toCharArray();
        StringBuilder compressString = new StringBuilder("");
        char holder = arr[0];
        int count = 0;
        for (char c : arr) {
            if(holder == c) {
                count++;
            }
            else {
                compressString.append(holder);
                compressString.append(count);
                holder = c;
                count = 1;
            }
        }

        if(str.length() > compressString.toString().length()){
            return compressString.toString();
        }
        else {
            return str;
        }
    }

    private static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }
}