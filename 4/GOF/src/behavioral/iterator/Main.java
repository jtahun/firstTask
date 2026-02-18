package behavioral.iterator;

public class Main{
    public static void main(String[] args){
        String[] chapters = {"Введение","Глава 1: Основы", "Глава 2: Продвинутые темы",
                "Глава 3: Практика","Заключение"};
        Book book = new Book("Изучаем Java",chapters);
        Iterator iterator = book.getIterator();
        System.out.println("Название книги: " + book.getTitle());
        System.out.println("Содержание");
        while(iterator.hasNext()){
            System.out.println(" " + iterator.next().toString());
        }
    }
}
