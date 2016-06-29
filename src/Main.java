import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("D:\\KoT\\Мотоцикл2.txt")); // читаем файлик
        ArrayList<String> lines = new ArrayList<String>(); // создаем лист
        Map<String, Integer> map = new HashMap<>(); // создаем мапу

        while (reader.ready()) { // пока ридер читает записываем в переменнуж лайнс все что он читает
            lines.add(reader.readLine());
        }
        for (String line : lines) { // создали перменную лайн и записали разбитые на строки слова из лайнс
            String[] words = line.split(" "); // и созданой лайн, в масиве вордс обработали строки по пробелу
            for (String word : words) { // пробегаемся по масиву вордс и записываем все слова построчно в переменную ворд
                if (map.containsKey(word)) // если цикр первый раз проходит, делается услови - map.put(word, 1); в котором записывает слово"Это ключ" и дает ему значение"это валуе" во все следющие разы - map.put(word, map.get(word) +1); если уже слово есть то будет слово - 1 +1 = слово - 2.
                    map.put(word, map.get(word) + 1);
                else
                    map.put(word, 1);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\KoT\\words.txt"))) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) { // Мап Ентри - это объект который содержит в себе и слово и значене (ключ и валу) и сдесь с всей мапы мы эти параметры ключа и валуе заполняем данными с нашей переменной мап, где потом записываем её в переменную ентри и в выводе entry.getKey() + " - " + entry.getValue() вытскиваем и ключ и валуе
                System.out.println(entry.getKey() + " - " + entry.getValue());
                writer.write(entry.getKey() + " - " + entry.getValue());
                writer.newLine();
            }
        }
    }


}
