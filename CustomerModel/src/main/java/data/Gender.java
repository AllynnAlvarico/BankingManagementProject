package data;

public enum Gender {
    MALE ("Male"),
    FEMALE ("Female"),
    OTHER ("Other");

    private String gender;

    Gender(String byVal_gender) {
        gender = byVal_gender;
    }

    public String getGender() {
        return gender;
    }
}
