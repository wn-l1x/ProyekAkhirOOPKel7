public class ProductivityCreator extends CardCreator
{

    @Override
    public CardView createCard(String appName, String filePath, Category category) {
        return new ProductivityCard(appName, filePath, category);
    }
}
