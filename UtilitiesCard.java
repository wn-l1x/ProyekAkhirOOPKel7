public class UtilitiesCard extends CardView
{
    public UtilitiesCard(String appName, String filePath) {
        super(appName, filePath);
    }

    @Override
    public String toCSVString() {
        return "Utilities," + appName + "," + filePath;
    }

    @Override
    public String toString() {
        return "Utilities [" + super.toString() + "]\n";
    }
}
