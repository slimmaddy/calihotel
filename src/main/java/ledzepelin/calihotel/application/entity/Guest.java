package ledzepelin.calihotel.application.entity;

import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {
    private Integer id;
    private String lastName;
    private String name;
    private String sex;
    private String email;
    private Long phone;
    private LocalDate arrival;
    private LocalDate departure;
    private LocalDate checkOut;
    private Integer days;
    private String travelAgency;
    private String roomNo;
    private Integer price;
    private String comment;
    private String paymentMethod;
    private String vip;
    private String specials;
    private String status;
}
