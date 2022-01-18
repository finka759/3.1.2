package web.model;

public class Car {

    private String model;
    private int numbers;
    private String series;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Car(String model, int numbers, String series) {
        this.model = model;
        this.numbers = numbers;
        this.series = series;
    }
}
