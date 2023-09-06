package MSPowerPoint.Interfaces;


public interface MySlide<Slides> {

    public void createSlides();
    public void readAllSlides();

    public void updateSlide(int index);
    public void deleteSlide(int index) ;

    public void insertAfterIndex(int index);

    public void insertBeforeIndex(int index);

    }
