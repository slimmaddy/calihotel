package ledzepelin.calihotel.application.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {
	private Integer groupId;
	private String groupName;
	private String travelAgency;
	private Integer booker;
	private BigDecimal price;
	private String paymentMethod;
	private String comment;
	private LocalDate arrival;
	private LocalDate departure;
	private Integer days;
	private String status;
}