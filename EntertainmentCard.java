public class EntertainmentCard extends CardView
{
    public EntertainmentCard(String appName, String filePath) {
        super(appName, filePath);
    }

    @Override
    public String toCSVString() {
        return "Entertainment," + appName + "," + filePath;
    }

    
    @Override
    public String toString() {
        return "Entertainment [" + super.toString() + "]\n";
    }
}
