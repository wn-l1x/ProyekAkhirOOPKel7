public class ProductivityCard extends CardView
{

    public ProductivityCard(String appName, String filePath) {
        super(appName, filePath);
    }

    @Override
    public String toCSVString() {
        return "Productivity," + appName + "," + filePath;
    }

    @Override
    public String toString() {
        return "Productivity [" + super.toString() + "]\n";
    }
}
