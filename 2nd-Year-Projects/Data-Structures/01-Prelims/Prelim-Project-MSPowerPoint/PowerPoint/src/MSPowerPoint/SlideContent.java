package MSPowerPoint;

class SlideContent {
    public String title;
    public String description;

    public SlideContent(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String toString(){
        return "Title: " + title + " Body: " + description;
    }
}

