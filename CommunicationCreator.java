public class CommunicationCreator extends CardCreator
{
    @Override
    public CardView createCard(String appName, String filePath, Category category) {
        return new CommunicationCard(appName, filePath, category);
    }
}
