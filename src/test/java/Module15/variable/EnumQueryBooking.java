package Module15.variable;

import lombok.Getter;

@Getter
public enum EnumQueryBooking {

    VALID_DATA("Иван", "Иванов", 500, true, "2025-06-08",
            "2025-06-23", "textTest"),

    VALID_DATA_2("Сергей", "Сергеевич", 100, false, "2025-06-08",
                       "2025-06-23", "textTest");

    private final String firstname;
    private final String lastname;
    private final int totalprice;
    private final boolean depositpaid;
    private final String checkin;
    private final String checkout;
    private final String additionalneeds;

    EnumQueryBooking(String firstname, String lastname, int totalprice, boolean depositpaid,
                     String checkin, String checkout, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.checkin = checkin;
        this.checkout = checkout;
        this.additionalneeds = additionalneeds;
    }
}
