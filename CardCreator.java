public  class CardCreator
{
    public CardView createCard(Category category, String appName, String filePath){
        switch (category) {
            case COMMUNICATION:
                return new CommunicationCard(appName, filePath);
            case ENTERTAINMENT:
                return new EntertainmentCard(appName, filePath);
            case PRODUCTIVITY:
                return new ProductivityCard(appName, filePath);
            case UTILITIES:
                return new UtilitiesCard(appName, filePath);
            default:
                throw new IllegalArgumentException("Unknown category");
        }
    }
}
