import java.util.*;

public class HashMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, String> students = new java.util.HashMap<>();

        students.put(101, "Ali");
        students.put(102, "Hamza");
        students.put(103, "Usman");
        students.put(104, "Ahmed");

        System.out.println(students);

        System.out.println(students.get(102));

        students.put(103, "Usman Khan");
        System.out.println(students);

        System.out.println(students.containsKey(101));
        System.out.println(students.containsKey(110));

        students.remove(104);
        System.out.println(students);

        System.out.println(students.size());
        System.out.println(students.isEmpty());

        for (Integer key : students.keySet()) {
            System.out.println(key + " -> " + students.get(key));
        }

        for (String value : students.values()) {
            System.out.println(value);
        }

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        int[] arr = {1, 2, 3, 1, 2, 1, 4, 3, 2};
        Map<Integer, Integer> freqMap = new java.util.HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        System.out.println(freqMap);

        int roll = sc.nextInt();

        if (students.containsKey(roll)) {
            System.out.println(students.get(roll));
        } else {
            System.out.println("Not Found");
        }

        Iterator<Map.Entry<Integer, String>> it = students.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            if (entry.getKey() > 102) {
                it.remove();
            }
        }

        System.out.println(students);

        Map<String, Integer> marks = new java.util.HashMap<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String subject = sc.nextLine();
            int m = sc.nextInt();
            sc.nextLine();
            marks.put(subject, m);
        }

        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
