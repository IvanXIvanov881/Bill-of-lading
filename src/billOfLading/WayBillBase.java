package billOfLading;

import static common.ExceptionMessages.INCORRECT;

public abstract class WayBillBase implements WayBill {

    private int numberOfWayBill;

    private double kilograms;

    private double volume;

    public String currentLocation;

    public String toLocation;


    public WayBillBase(int numberOfWayBill, double kilograms, double volume, String sendLocation, String toLocation) {
        setNumberOfWayBill(numberOfWayBill);
        setKilograms(kilograms);
        setVolume(volume);
        setCurrentLocation(sendLocation);
        setToLocation(toLocation);
    }

    @Override
    public int getNumber() {
        return numberOfWayBill;
    }

    @Override
    public double getKilograms() {
        return kilograms;
    }

    @Override
    public String getSendFrom() {
        return currentLocation;
    }

    @Override
    public String getToDelivery() {
        return toLocation;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException(INCORRECT);
        }
        this.volume = volume;
    }

    protected void setNumberOfWayBill(int numberOfWayBill) {
        if (numberOfWayBill <= 0) {
            throw new IllegalArgumentException(INCORRECT);
        }
        this.numberOfWayBill = numberOfWayBill;
    }

    protected void setKilograms(double kilograms) {
        if (kilograms <= 0) {
            throw new IllegalArgumentException(INCORRECT);
        }
        this.kilograms = kilograms;
    }

    public void setCurrentLocation(String currentLocation) {
                this.currentLocation = currentLocation;
    }

    @Override
    public void setToLocation(String newLocation) {
        toLocation= newLocation;
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("________________")).append(System.lineSeparator());
        sb.append(String.format("Номер на товарителница: %d",this.numberOfWayBill)).append(System.lineSeparator());
        String checkLoadType = getClass().getSimpleName();
        if (checkLoadType.equals("FragileLoad")) {
            sb.append(String.format("Вид на товара: чуплив.")).append(System.lineSeparator());
        } else {
            sb.append(String.format("Вид на товара: нечуплив.")).append(System.lineSeparator());
        }
        sb.append(String.format("Обем: %.1fcc.",this.volume)).append(System.lineSeparator());
        sb.append(String.format("Тегло: %.3fкг.",this.kilograms)).append(System.lineSeparator());
        sb.append(String.format("Локация на изпращане: %s",this.currentLocation)).append(System.lineSeparator());
        sb.append(String.format("Локация на пристигане: %s",this.toLocation)).append(System.lineSeparator());
        sb.append(String.format("________________")).append(System.lineSeparator());

        return sb.toString().trim();
    }

}
