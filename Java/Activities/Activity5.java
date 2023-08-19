package activities;

abstract class Book{
    String title;
    abstract void setTitle(String S);
    String getTitle(){
     return title;
    }
}

class MyBook extends Book{
    @Override
    public void setTitle(String S) {
      title= S;
    }
}

public class Activity5{
public static void main(String[] args){
    String t= "Movie";
Book TitleCard = new MyBook();
          TitleCard.setTitle(t);
     String MovieTitle = TitleCard.getTitle();
     System.out.println("OutTitle is:  " + MovieTitle );

}
}
