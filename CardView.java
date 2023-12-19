public abstract class CardView
{
    String appName;
    String filePath;

    public CardView(String appName, String filePath){
        this.appName = appName;
        this.filePath = filePath;
    }

    public abstract String toCSVString();

    public static CardView parseCSVString(String csvString) {
        String[] values = csvString.split(",");
        String category = values[0].trim();

        switch (category) {
            case "Communication":
                return new CommunicationCard(values[1].trim(), values[2].trim());
            case "Entertainment":
                return new EntertainmentCard(values[1].trim(), values[2].trim());
            case "Productivity":
                return new ProductivityCard(values[1].trim(), values[2].trim());
            case "Utilities":
                return new UtilitiesCard(values[1].trim(), values[2].trim());
            default:
                throw new IllegalArgumentException("Unknown category");
        }
    }

    @Override
    public String toString() {
        return appName + " : " + filePath;
    }
}
