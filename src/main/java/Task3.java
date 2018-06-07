import java.util.*;

/**
 * На вход программе подается литературный текст.
 * Программа должна вывести список слов, встречающихся в тексте,
 * в котором для каждого слова указывается количество вхождений этого слова в текст,
 * а слова выводятся в порядке убывания частоты вхождения.
 */
//Предположения: за слово принимаются 1 или несколько символов англ. и рус. алфавита, а также последовательность цифр.
public class Task3 {

    public static void main(String args[]) {

        String text = " FFFF Aa b b b_ Aa 000% программе подается литературный текст, и. Не литературный! ";
        String[] words = text.trim().split("[^а-яА-Яa-zA-Z0-9]+");


        Map<String, Long> map = generateMap(words); //делаем map из слов и количества повторений
        TreeSet<Map.Entry<String, Long>> sortedEntries = sortByMapValue(map);//сортируем по значению добавляя в дерево

        System.out.println(sortedEntries);
    }

    private static Map<String, Long> generateMap(String[] words) {

        Map<String, Long> map = new HashMap<>();
        List<String> list = Arrays.asList(words);
        list.forEach(s -> {
            if (map.containsKey(s)) {
                long count = map.get(s);
                map.put(s, ++count);
            } else map.put(s, 1L);
        });
        return map;
    }

    private static TreeSet<Map.Entry<String, Long>> sortByMapValue(Map<String, Long> map) {

        TreeSet<Map.Entry<String, Long>> sortedEntries = new TreeSet<>(new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> e1, Map.Entry<String, Long> e2) {
                int res = e2.getValue().compareTo(e1.getValue());
                return res == 0 ? 1 : res;
            }
        });

        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

}