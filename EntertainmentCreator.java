public class EntertainmentCreator extends CardCreator
{
    @Override
    public CardView createCard(String appName, String filePath, Category category) {
        return new EntertainmentCard(appName, filePath, category);
    }
    
}
