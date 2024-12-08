package data;

public record CardInformation(String cardNumber) {
    @Override
    public String cardNumber() {
        return cardNumber;
    }
}
