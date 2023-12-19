public abstract class CardView
{
    String appName;
    String filePath;
    Category category;

    public CardView(String appName, String filePath, Category category){
        this.appName = appName;
        this.filePath = filePath;
        this.category = category;
    }
}
