package patterns.prototype;

public class TicketTemplate implements Cloneable {
    private String templateName;
    private String movieTitle;
    private String theaterName;
    private double basePrice;

    public TicketTemplate(String templateName, String movieTitle, String theaterName, double basePrice) {
        this.templateName = templateName;
        this.movieTitle = movieTitle;
        this.theaterName = theaterName;
        this.basePrice = basePrice;
    }

    // Getters and setters
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public TicketTemplate clone() {
        try {
            return (TicketTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }

    @Override
    public String toString() {
        return "TicketTemplate{" +
                "templateName='" + templateName + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", theaterName='" + theaterName + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
