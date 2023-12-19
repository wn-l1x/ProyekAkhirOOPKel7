public class CommunicationCard extends CardView
{
    public CommunicationCard(String appName, String filePath) {
        super(appName, filePath);
    }

    @Override
    public String toCSVString() {
        return "Communication," + appName + "," + filePath;
    }

    @Override
    public String toString() {
        return "Communication [" + super.toString() + "]\n";
    }
}
