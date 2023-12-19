public class UtilitiesCreator extends CardCreator
{

    @Override
    public CardView createCard(String appName, String filePath, Category category) {
        return new UtilitiesCard(appName, filePath, category);
    }
}
