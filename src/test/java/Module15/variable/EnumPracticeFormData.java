package Module15.variable;

import lombok.Getter;

@Getter
public enum EnumPracticeFormData {

    /**
     * Валидный набор данных
     */
    VALID_DATA(
            "Иван", "Иванов", "ivan@example.com", "1234567890", "Male",
            "May", "1991", "21", "Commerce", "Sports",
            "Reading", "Music", "picture.jpg", "Москва, ул. Ленина 1",
            "Haryana", "Karnal"
    ),

    /**
     * Невалидный набор данных
     */
    INVALID_DATA(
            "Петр!", "Петров2", "invalidemail", "123", "Malee",
            "Mayy", "19900", "299", "Mathematicsw",
            "Sports!", "Readingw", "Musicw",
            "picture.jpgw", "Москваww, ул. Ленина 1", "Haryanaae", "Delheei"
    );

    EnumPracticeFormData(String firstName, String lastName, String email, String mobile, String gender,
                         String birthDateMonth, String birthDateYear, String birthDateDay, String subject,
                         String hobby1, String hobby2, String hobby3,
                         String photo, String address, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.birthDateMonth = birthDateMonth;
        this.birthDateYear = birthDateYear;
        this.birthDateDay = birthDateDay;
        this.subject = subject;
        this.hobby1 = hobby1;
        this.hobby2 = hobby2;
        this.hobby3 = hobby3;
        this.photo = photo;
        this.address = address;
        this.state = state;
        this.city = city;
    }

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String mobile;
    private final String gender;
    private final String birthDateMonth;
    private final String birthDateYear;
    private final String birthDateDay;
    private final String subject;
    private final String hobby1;
    private final String hobby2;
    private final String hobby3;
    private final String photo;
    private final String address;
    private final String state;
    private final String city;
}
