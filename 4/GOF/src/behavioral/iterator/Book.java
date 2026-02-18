package behavioral.iterator;

class Book implements Collection{
    private final String title;
    private final String[] chapters;

    public Book(String title, String[] chapters){
        this.title = title;
        this.chapters = chapters;
    }

    public String getTitle(){return title;}

    @Override
    public Iterator getIterator(){return new ChapterIterator(); }

    private class ChapterIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext(){ return index < chapters.length;}

        @Override
        public Object next(){ return chapters[index++];}
    }
}